FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN .\mvnw.cmd clean package

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/app-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]