PHONY: build push config-azure apply scale

build:
	mvn clean package -DskipTests=true
	docker build . -t malditoidealismo/crm-customer

push:
	docker push malditoidealismo/crm-customer

# Cloud, ya aprovisionado
config-azure:
	helm repo add ingress-nginx https://kubernetes.github.io/ingress-nginx
	helm install nginx-ingress ingress-nginx/ingress-nginx --set controller.replicaCount=1 --set controller.nodeSelector."beta\.kubernetes\.io/os"=linux --set defaultBackend.nodeSelector."beta\.kubernetes\.io/os"=linux --set controller.admissionWebhooks.patch.nodeSelector."beta\.kubernetes\.io/os"=linux

apply:
	kubectl apply -f ./specs/.

scale:
	kubectl scale deployment crm-customer --replicas=3

tf:
	k2tf -f ./specs/ -o terraform/crm.tf -x