FROM openjdk:17
WORKDIR /app
COPY ./target/Order-Service-0.0.1-SNAPSHOT.jar /app/
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "Order-Service-0.0.1-SNAPSHOT.jar"]