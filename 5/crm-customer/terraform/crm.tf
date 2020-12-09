resource "kubernetes_deployment" "customer" {
  metadata {
    name      = "customer"
    namespace = "default"
  }

  spec {
    replicas = 1

    selector {
      match_labels = {
        app = "customer"
      }
    }

    template {
      metadata {
        name = "customer"

        labels = {
          app = "customer"
        }
      }

      spec {
        container {
          name  = "customer"
          image = "malditoidealismo/crm-customer"

          port {
            name           = "liveness-port"
            host_port      = 8080
            container_port = 8080
            protocol       = "TCP"
          }

          env {
            name  = "POSTGRES_HOST"
            value = "postgres.default.svc.cluster.local"
          }

          env {
            name = "POSTGRES_USER"

            value_from {
              config_map_key_ref {
                name = "postgres-config"
                key  = "postgres_user"
              }
            }
          }

          env {
            name = "POSTGRES_PASSWORD"

            value_from {
              config_map_key_ref {
                name = "postgres-config"
                key  = "postgres_password"
              }
            }
          }

          resources {
            limits {
              cpu    = "500m"
              memory = "300Mi"
            }

            requests {
              memory = "256Mi"
              cpu    = "250m"
            }
          }

          liveness_probe {
            http_get {
              path = "/actuator/health"
              port = "liveness-port"
            }

            initial_delay_seconds = 35
            period_seconds        = 3
          }

          image_pull_policy = "IfNotPresent"
        }
      }
    }
  }
}

resource "kubernetes_service" "customer" {
  metadata {
    name = "customer"
  }

  spec {
    port {
      port        = 80
      target_port = "8080"
      node_port   = 31000
    }

    selector = {
      app = "customer"
    }

    type = "NodePort"
  }
}

resource "kubernetes_ingress" "ingress_aks" {
  metadata {
    name = "ingress-aks"

    annotations = {
      "kubernetes.io/ingress.class" = "nginx"

      "nginx.ingress.kubernetes.io/rewrite-target" = "/$1"

      "nginx.ingress.kubernetes.io/ssl-redirect" = "false"

      "nginx.ingress.kubernetes.io/use-regex" = "true"
    }
  }

  spec {
    rule {
      http {
        path {
          path = "/customer/?(.*)"

          backend {
            service_name = "customer"
            service_port = "80"
          }
        }
      }
    }
  }
}

resource "kubernetes_config_map" "postgres_config" {
  metadata {
    name      = "postgres-config"
    namespace = "default"
  }

  data = {
    postgres_password = "c1oudc0w"

    postgres_user = "admin"
  }
}

resource "kubernetes_persistent_volume_claim" "postgres_pv_claim" {
  metadata {
    name = "postgres-pv-claim"
  }

  spec {
    access_modes = ["ReadWriteOnce"]

    resources {
      requests = {
        storage = "5Gi"
      }
    }
  }
}

resource "kubernetes_deployment" "postgres" {
  metadata {
    name = "postgres"
  }

  spec {
    selector {
      match_labels = {
        app = "postgres"
      }
    }

    template {
      metadata {
        labels = {
          app = "postgres"
        }
      }

      spec {
        volume {
          name = "postgres-storage"

          persistent_volume_claim {
            claim_name = "postgres-pv-claim"
          }
        }

        container {
          name  = "postgres"
          image = "postgres:10-alpine"

          port {
            name           = "postgres"
            container_port = 5432
          }

          env {
            name = "POSTGRES_USER"

            value_from {
              config_map_key_ref {
                name = "postgres-config"
                key  = "postgres_user"
              }
            }
          }

          env {
            name = "POSTGRES_PASSWORD"

            value_from {
              config_map_key_ref {
                name = "postgres-config"
                key  = "postgres_password"
              }
            }
          }

          env {
            name  = "PGDATA"
            value = "/var/lib/postgresql/data/pgdata"
          }

          volume_mount {
            name       = "postgres-storage"
            mount_path = "/var/lib/postgresql/data"
          }
        }
      }
    }
  }
}

resource "kubernetes_service" "postgres" {
  metadata {
    name = "postgres"
  }

  spec {
    port {
      port = 5432
    }

    selector = {
      app = "postgres"
    }

    type = "ClusterIP"
  }
}

