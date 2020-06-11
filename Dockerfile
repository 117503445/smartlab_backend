FROM openjdk:14-alpine

EXPOSE 80

ADD ./target/smartlab-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/urandom","-jar","/app.jar"]