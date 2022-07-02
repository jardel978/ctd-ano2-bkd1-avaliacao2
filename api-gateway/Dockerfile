FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=/target/apigateway.jar
COPY ${JAR_FILE} apigateway.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","apigateway.jar"]