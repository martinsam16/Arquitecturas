FROM alpine 

RUN apk update \
	&& apk add openjdk8-jre
 
EXPOSE 8000

COPY target/personaservice-0.0.1-SNAPSHOT.jar personaservice.jar

CMD ["java", "-jar", "personaservice.jar"]