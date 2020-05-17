## microservicio
mvn clean package
docker rm -f alumno-service
docker rmi -f $(docker images |grep 'alumno-service')
docker build -t alumno-service:0.1 .
docker run -d -p 8002:8002 --name alumno-service alumno-service:0.1