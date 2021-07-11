FROM openjdk:11.0.8-jre-slim

## build image with jar
#COPY build/libs/spring-tutorial-0.0.1-SNAPSHOT.jar app.jar
#
#ENTRYPOINT java -jar -Dspring.profiles.active=$SPRING_PROFILES_ACTIVE /app.jar

## build image with unpacked files
ARG DEPENDENCY=build/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java","-cp","app:app/lib/*","dev.aquashdw.demo.springtutorial.SpringTutorialApplication"]