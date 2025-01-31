FROM openjdk:17-jdk-slim

# Create a non-root user
RUN groupadd -r appgroup && useradd -r -g appgroup appuser

# Set working directory
WORKDIR /app

# Copy JAR file
COPY target/simple-time-service.jar simple-time-service.jar

# Set ownership
RUN chown -R appuser:appgroup /app
USER appuser

# Expose port and run app
EXPOSE 8080
CMD ["java", "-jar", "simple-time-service.jar"]
