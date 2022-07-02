FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=/target/configservice.jar
COPY ${JAR_FILE} configservice.jar
EXPOSE 8888
ENTRYPOINT ["java","-jar","configservice.jar"]