FROM alpine

RUN apk update \
	&& apk add openjdk8-jre

COPY target/api-gateway-0.0.1.jar api-gateway/api-gateway.jar

EXPOSE 8080

CMD ["java", "-jar", "api-gateway/api-gateway.jar"]