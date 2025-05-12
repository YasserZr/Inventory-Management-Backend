# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Maven wrapper and pom.xml to leverage Docker cache
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Download dependencies
RUN ./mvnw dependency:go-offline -B

# Copy the rest of the application source code
COPY src src

# Package the application
RUN ./mvnw package -DskipTests

# Argument to specify the JAR file name (optional, but good practice)
ARG JAR_FILE=target/*.jar

# Copy the packaged jar file into the container
COPY ${JAR_FILE} app.jar

# Expose the port the app runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java","-jar","app.jar"]
