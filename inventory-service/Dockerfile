FROM openjdk:17
WORKDIR /app
COPY ./target/Inventory-Service-0.0.1-SNAPSHOT.jar /app/
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "Inventory-Service-0.0.1-SNAPSHOT.jar"]