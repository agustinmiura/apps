FROM adoptopenjdk/openjdk11:jre-11.0.11_9-alpine
MAINTAINER user
COPY target/students-api.jar students-api.jar
ENTRYPOINT ["java","-jar","/students-api.jar"]