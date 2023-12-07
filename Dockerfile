
FROM eclipse-temurin:17-jdk-alpine as build

WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN --mount=type=cache,target=/root/.m2 ./mvnw clean install -DskipTests

FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY --from=build /workspace/app/target/farmacia-0.0.1.jar farmacia-0.0.1.jar

RUN addgroup -S user && adduser -S user -G user
USER user

ENV JAVA_OPTS="-Xmx256m -Xms128m"

ENTRYPOINT [ "java", "-jar", "farmacia-0.0.1.jar" ]
