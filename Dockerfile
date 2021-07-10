# Dockerfile to copy
FROM openjdk:11.0.8-jre-slim
COPY build/libs/spring-tutorial-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT java -jar -Dspring.profiles.active=$SPRING_PROFILES_ACTIVE /app.jar