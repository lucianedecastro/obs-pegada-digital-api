# Estágio 1: Build - Usamos a JDK 21 para compilar o projeto
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
# O Maven usará a versão 17 definida no seu pom.xml para gerar o .jar
RUN mvn clean package -DskipTests

# Estágio 2: Execução - Rodamos no JRE 17 (conforme seu pom.xml)
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /app/target/rastreabilidade-api-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]