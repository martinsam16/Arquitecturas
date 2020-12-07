PHONY: build-jars run down

build-jars:
	mvn -f ./superdev-crm-customer-part2/pom.xml clean package -DskipTests=true

run:
	docker-compose up --build

down:
	docker-compose down