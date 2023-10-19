
FROM eclipse-temurin:17-jdk-alpine as build

WORKDIR /workspace/app

COPY mvnw .

COPY .mvn .mvn

COPY pom.xml .

COPY src src

RUN --mount=type=cache,target=/root/.m2 ./mvnw install -DskipTests

#ENTRYPOINT [ "java", "-jar", "target/farmacia-0.0.1.jar" ]

FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY --from=build /workspace/app/target/farmacia-0.0.1.jar farmacia-0.0.1.jar

ENTRYPOINT [ "java", "-jar", "farmacia-0.0.1.jar" ]
# RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)
# FROM eclipse-temurin:17-jdk-alpine
# VOLUME /tmp
# ARG DEPENDENCY=/workspace/app/target/dependency
# COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
# COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
# COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
# ENTRYPOINT [ "ls", "/app" ]
#ENTRYPOINT ["java","-cp","app:app/lib/*","FarmaciaApplication.class"]
#ENTRYPOINT ["java","-cp","app:app/lib/*","Farmacia.Application"]