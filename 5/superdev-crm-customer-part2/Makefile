PHONY: build-push kubernetes scale

build-push:
	mvn clean package -DskipTests=true
	docker build . -t malditoidealismo/crm-customer
	docker push malditoidealismo/crm-customer

config-azure:
	helm repo add ingress-nginx https://kubernetes.github.io/ingress-nginx
	helm install nginx-ingress ingress-nginx/ingress-nginx --set controller.replicaCount=2 --set controller.nodeSelector."beta\.kubernetes\.io/os"=linux --set defaultBackend.nodeSelector."beta\.kubernetes\.io/os"=linux --set controller.admissionWebhooks.patch.nodeSelector."beta\.kubernetes\.io/os"=linux

apply:
	kubectl apply -f ./specs/.

scale:
	kubectl scale deployment crm-customer --replicas=3
