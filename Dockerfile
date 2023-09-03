FROM eclipse-temurin:17-jdk-jammy

WORKDIR clinic-app

COPY .mvn .mvn
COPY src src
COPY mvnw pom.xml ./

RUN chmod 777 /clinic-app/mvnw
RUN /clinic-app/mvnw dependency:resolve
RUN /clinic-app/mvnw compile package -DskipTests

ENTRYPOINT ["/clinic-app/mvnw", "spring-boot:run", "-Pproduction", "-DskipTests"]
