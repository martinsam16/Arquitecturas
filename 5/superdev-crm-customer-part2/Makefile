PHONY: build-push kubernetes scale

build-push:
	mvn clean package -DskipTests=true
	docker build . -t malditoidealismo/crm-customer
	docker push malditoidealismo/crm-customer

kubernetes:
	kubectl apply -f ./specs/.

scale:
	kubectl scale deployment crm-customer --replicas=3
