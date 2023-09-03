FROM eclipse-temurin:17-jdk-jammy

WORKDIR clinic-app

#RUN sudo apt install dos2unix
RUN realpath ./mvnw
COPY .mvn .mvn
COPY src src
COPY mvnw pom.xml ./

#RUN ls -a
#WORKDIR .mvn/wrapper
#RUN ls -a

RUN  /clinic-app/mvnw dependency:resolve
#RUN ./mvnw compile package -DskipTests

#ENTRYPOINT ["./mvnw", "spring-boot:run", "-Pproduction", "-DskipTests"]
