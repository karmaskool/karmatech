FROM azul/zulu-openjdk-alpine:13-jre

WORKDIR /data/cloud-config-server/git
WORKDIR /tmp/application

VOLUME /data/cloud-config-server

COPY ./target/*.jar application.jar

EXPOSE 8100

ENTRYPOINT java -jar application.jar
