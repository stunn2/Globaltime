FROM maven:3-openjdk-18-slim AS build-env


WORKDIR /app
COPY pom.xml ./
COPY src ./src

# Download dependencies and build a release artifact.
RUN mvn package -DskipTests

FROM amazoncorretto:17.0.7-alpine

# Copy the jar to the production image from the builder stage.
COPY --from=build-env /app/target/time-service*.war /time-service.war

EXPOSE 8080

# Run the web service on container startup.
CMD ["java", "-jar" ,"-Djdk.util.jar.enableMultiRelease=false", "/time-service.war"]