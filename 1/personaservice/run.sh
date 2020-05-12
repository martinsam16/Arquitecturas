## db
docker rm -f persona-db
docker run -d -p 8001:27017 --name persona-db mongo

## microservicio
docker rm -f persona-service
docker rmi -f $(docker images |grep 'persona-service')
docker build -t persona-service:0.1 .
docker run -d -p 8000:8000 --name persona-service persona-service:0.1