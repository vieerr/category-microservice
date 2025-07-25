FROM openjdk:17-jdk-alpine as builder

WORKDIR /app

RUN apk add --no-cache maven

COPY pom.xml .

RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-alpine

WORKDIR /app

RUN mkdir -p ./logs

COPY --from=builder /app/target/*.jar ./app.jar

EXPOSE $PORT

ENTRYPOINT ["java", "-jar", "app.jar"]
