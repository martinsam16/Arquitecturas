FROM alpine

RUN apk update \
	&& apk add openjdk8-jre

COPY target/user-service-0.0.1.jar user/user-service.jar

EXPOSE 3005

CMD ["java", "-jar", "user/user-service.jar"]