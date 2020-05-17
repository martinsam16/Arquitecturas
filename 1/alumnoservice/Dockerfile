FROM alpine

RUN apk update \
	&& apk add openjdk8-jre

EXPOSE 8002

COPY target/alumnoservice-0.0.1-SNAPSHOT.jar alumnoservice.jar

CMD ["java", "-jar", "alumnoservice.jar"]