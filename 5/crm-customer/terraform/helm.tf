resource "helm_release" "ingress" {
  name       = "ingress"
  repository = "https://kubernetes-charts.storage.googleapis.com"
  chart      = "nginx-ingress"
  namespace  = "default"
  version    = "1.34.2"

  set {
    name  = "controller.replicaCount"
    value = "1"
  }

}
