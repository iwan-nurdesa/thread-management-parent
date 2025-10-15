FROM eclipse-temurin:21-jdk
# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/ms-thread-async-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that the application will run on
EXPOSE 8081

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
