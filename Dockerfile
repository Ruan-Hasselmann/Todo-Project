FROM ubuntu:20.04

RUN apt-get update && \
    apt-get install -y openjdk-17-jdk && \
    rm -rf /var/lib/apt/lists/*

WORKDIR /app

COPY target/todo-0.0.1-SNAPSHOT.jar /app/todo.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/todo.jar"]


# Uso do dockerfile
# - mvn clean package
# - docker run -p 8080:8080 todo
# DEPLOY em: https://fly.io/docs/
