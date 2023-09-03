FROM eclipse-temurin:17-jdk-jammy

WORKDIR clinic-app

#RUN sudo apt install dos2unix

COPY .mvn .mvn
COPY src src
COPY mvnw pom.xml ./


RUN realpath ./mvnw
#RUN ls -a
#WORKDIR .mvn/wrapper
#RUN ls -a
RUN chmod 777 /clinic-app/mvnw
RUN /clinic-app/mvnw dependency:resolve
#RUN ./mvnw compile package -DskipTests

#ENTRYPOINT ["./mvnw", "spring-boot:run", "-Pproduction", "-DskipTests"]
