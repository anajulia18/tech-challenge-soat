# Usar uma imagem base do OpenJDK
FROM openjdk:11-jre-slim

# Informar o diretório de trabalho dentro do container
WORKDIR /app

# Copiar o arquivo JAR para o diretório de trabalho
COPY target/revenda-veiculos-api-1.0-SNAPSHOT.jar app.jar

# Expor a porta que a aplicação vai rodar
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java","-jar","app.jar"]
