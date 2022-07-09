FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=/target/movieservice.jar
COPY ${JAR_FILE} movieservice.jar
EXPOSE 8084
ENTRYPOINT ["java","-jar","movieservice.jar"]