FROM openjdk:17-jdk-alpine
COPY target/SpringAPI-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]

EXPOSE 8080