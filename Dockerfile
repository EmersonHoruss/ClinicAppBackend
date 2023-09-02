FROM eclipse-temurin:8-jdk-jammy

WORKDIR clinic-app

COPY .mvn .mvn
COPY src src
COPY mvnw pom.xml ./

RUN chmod +x ./mvnw dependency:resolve
RUN ./mvnw compile package -DskipTests

ENTRYPOINT ["./mvnw", "spring-boot:run", "-Pproduction", "-DskipTests"]
