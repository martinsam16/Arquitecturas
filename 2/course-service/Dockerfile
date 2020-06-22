FROM alpine

RUN apk update \
	&& apk add openjdk8-jre

COPY target/course-service-0.0.1.jar course/course-service.jar

EXPOSE 3007

CMD ["java", "-jar", "course/course-service.jar"]