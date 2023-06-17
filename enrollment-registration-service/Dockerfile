# Define a imagem base do Java
FROM openjdk:17-jdk-slim
# Install Maven
RUN apt-get update && apt-get install -y maven
# Define o diretório de trabalho no container
WORKDIR /app
# Copia o arquivo pom.xml para o diretório de trabalho
COPY pom.xml .
# Copia a pasta src para o diretório de trabalho
COPY src ./src
# Executa o comando Maven para construir o projeto
RUN mvn package -DskipTests
# Expõe a porta em que o microserviço estará executando
EXPOSE 8002
# Define o comando para executar o microserviço
CMD ["java", "-jar", "target/sub-reg-0.0.1-SNAPSHOT.jar"]
