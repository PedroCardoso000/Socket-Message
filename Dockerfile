# Etapa 1: construir a aplicação com Maven
FROM maven:3.9.4-eclipse-temurin-21 AS builder

WORKDIR /app

# Copia o arquivo de configuração do Maven e as dependências primeiro (para cache)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia o restante dos arquivos do projeto
COPY src ./src

# Compila o projeto e empacota como um JAR
RUN mvn clean package -DskipTests

# Etapa 2: imagem para rodar o app
FROM eclipse-temurin:21-jre

# Diretório de trabalho dentro do container
WORKDIR /app

# Copia o JAR construído da imagem anterior
COPY --from=builder /app/target/project-socket-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
