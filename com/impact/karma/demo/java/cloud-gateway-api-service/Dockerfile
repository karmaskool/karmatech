FROM azul/zulu-openjdk-alpine:13-jre

WORKDIR /tmp/application

COPY ./target/*.jar application.jar

EXPOSE 8101

ENTRYPOINT java -jar application.jar
