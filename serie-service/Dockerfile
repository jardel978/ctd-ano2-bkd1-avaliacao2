FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=/target/serieservice.jar
COPY ${JAR_FILE} serieservice.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","serieservice.jar"]