PHONY: build-push kubernetes scale

build-push:
	mvn clean package -DskipTests=true
	docker build . -t malditoidealismo/crm-customer
	docker push malditoidealismo/crm-customer

kubernetes:
	kubectl create -f specs/postgres.yml
	kubectl create configmap hostname-config --from-literal=postgres_host=$(kubectl get svc postgres -o jsonpath="{.spec.clusterIP}")
	kubectl create -f specs/crm-customer.yml

scale:
	kubectl scale deployment crm-customer --replicas=3
