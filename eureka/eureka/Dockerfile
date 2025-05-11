FROM eclipse-temurin:11-jdk-jammy
WORKDIR /opt
COPY target/*.jar /opt/app.jar
ENTRYPOINT exec java $JAVAOPTS -jar app.jar