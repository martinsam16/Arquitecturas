sh build.sh

docker-compose build
docker-compose up -d

docker build -t email-service ./email-service
docker run -t -d --name="email-service" "email-service"