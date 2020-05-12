FROM alpine 

RUN apk update \
	&& apk add openjdk8-jre
 
EXPOSE 8761

COPY target/eureka-0.0.1-SNAPSHOT.jar eureka.jar

CMD ["java", "-jar", "eureka.jar"]