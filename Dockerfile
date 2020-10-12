FROM maven:3.6.3-openjdk-14 AS MAVEN_BUILD
COPY pom.xml /build/
COPY src /build/src/
COPY ./src/main/resources/app.yml /build/src/main/resources/application.yml
WORKDIR /build/
RUN mvn package -Dmaven.test.skip=true
FROM openjdk:14-alpine
WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/smartlab.jar /app/
EXPOSE 80
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/urandom","-jar", "smartlab.jar"]