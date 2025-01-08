# Step 1: Use a base image with Java
FROM eclipse-temurin:17-jdk-alpine

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the JAR file of your Spring Boot application into the container
COPY target/project-0.0.1-SNAPSHOT.jar app.jar

# Step 4: Expose the application port
EXPOSE 8083

# Step 5: Define the entry point for running the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]