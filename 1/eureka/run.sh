mvn clean package
docker rm -f eureka
docker rmi -f $(docker images |grep 'eureka')
docker build -t eureka:0.1 .
docker run -d -p 8761:8761 --name eureka eureka:0.1