FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=/target/catalogservice.jar
COPY ${JAR_FILE} catalogservice.jar
EXPOSE 8086
ENTRYPOINT ["java","-jar","catalogservice.jar"]