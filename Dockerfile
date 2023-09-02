FROM eclipse-temurin:8-jdk-jammy

WORKDIR clinic-app

COPY ".mvn" ".mvn"
COPY .mvn ./.mmm
COPY src src
COPY mvnw pom.xml ./

RUN ls

RUN ./mvnw dependency:resolve
RUN ./mvnw compile package -DskipTests

ENTRYPOINT ["./mvnw", "spring-boot:run", "-Pproduction", "-DskipTests"]
