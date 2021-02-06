FROM adoptopenjdk/openjdk14:alpine-slim
COPY target/crud-0.0.1-SNAPSHOT.jar crud.jar
EXPOSE 4000
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "crud.jar"]