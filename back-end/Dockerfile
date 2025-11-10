# === Backend Dockerfile (Spring Boot) ===
# Multi-stage build: Maven build then lightweight JRE runtime

# --- Build Stage ---
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml ./
# Pre-download dependencies (better layer caching)
RUN mvn -q dependency:go-offline
COPY src ./src
RUN mvn -q package -DskipTests

# --- Runtime Stage ---
FROM eclipse-temurin:21-jre-alpine AS runtime
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75 -XX:InitialRAMPercentage=50 -XX:+AlwaysActAsServerClassMachine -XX:+TieredCompilation"
ENV SPRING_PROFILES_ACTIVE=docker
WORKDIR /app
# Create non-root user
RUN addgroup -S spring && adduser -S spring -G spring && chown -R spring:spring /app
USER spring

# Copy built jar
COPY --from=build /app/target/*.jar app.jar

# Expose application port
EXPOSE 8080

# Default MySQL connection env vars (override in compose)
ENV DB_HOST=db
ENV DB_PORT=3306
ENV DB_NAME=eventdb
ENV DB_USER=root
ENV DB_PASSWORD=example

# Entrypoint
ENTRYPOINT ["java", "-jar", "app.jar"]
