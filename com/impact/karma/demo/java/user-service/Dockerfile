FROM azul/zulu-openjdk-alpine:13-jre

WORKDIR /tmp/application

COPY ./target/*.jar application.jar

EXPOSE 8104
ENTRYPOINT java -jar application.jar
