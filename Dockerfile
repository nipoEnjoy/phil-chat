FROM maven:3.9.15-eclipse-temurin-25-alpine AS builder
WORKDIR /build
COPY pom.xml ./
COPY .mvn ./.mvn
COPY mvnw ./

RUN chmod +x mvnw && ./mvnw -B dependency:go-offline

COPY src ./src
RUN ./mvnw -X -DskipTests package

FROM eclipse-temurin:25-jre-alpine
WORKDIR /app
COPY --from=builder /build/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar", "--debug"]