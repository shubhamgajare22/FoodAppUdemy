FROM adoptopenjdk/openjdk11:jdk-11.0.9-slim
WORKDIR /opt
COPY target/*.jar /opt/app.jar
ENTRYPOINT exec java $JAVAOPTS -jar app.jar