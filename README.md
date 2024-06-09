# Desafio IBM - Simulação de Operações Bancárias

Este projeto é uma aplicação que simula operações bancárias, desenvolvida como parte do Desafio IBM. A aplicação é construída utilizando Java 17, Spring Boot, Maven, JPA, H2, e Angular.

## Repositório

O código-fonte do projeto está disponível em: [GitHub - allandesenv/desafio-ibm](https://github.com/allandesenv/desafio-ibm/)

## Sumário

- [Introdução](#introdução)
- [Pré-requisitos](#pré-requisitos)
- [Instalação](#instalação)
- [Configuração](#configuração)
- [Endpoints da API](#endpoints-da-api)
- [Banco de Dados](#banco-de-dados)
- [Execução](#execução)
- [Testes](#testes)
- [Contribuição](#contribuição)
- [Licença](#licença)

## Introdução

Esta aplicação permite a simulação de operações bancárias, como cadastro de clientes, créditos, débitos e consulta de extrato. O backend é construído com Spring Boot e utiliza um banco de dados H2 em memória para persistência de dados.

## Pré-requisitos

Antes de começar, certifique-se de ter o seguinte instalado em sua máquina:

- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [Node.js e npm](https://nodejs.org/en/download/)

## Instalação

1. Clone o repositório:

    ```bash
    git clone https://github.com/allandesenv/desafio-ibm.git
    cd desafio-ibm
    ```

2. Navegue até o diretório do backend:

    ```bash
    cd backend
    ```

3. Instale as dependências do Maven:

    ```bash
    mvn clean install
    ```

## Configuração

A configuração padrão do banco de dados H2 em memória é feita no arquivo `src/main/resources/application.properties`. Caso precise modificar alguma configuração, ajuste este arquivo conforme necessário.

## Endpoints da API

Aqui estão os principais endpoints da API disponíveis:

### Clientes

- **GET /api/clientes**: Lista todos os clientes.
- **POST /api/clientes**: Adiciona um novo cliente.
- **GET /api/clientes/{id}**: Retorna um cliente específico.
- **PUT /api/clientes/{id}**: Atualiza um cliente específico.
- **DELETE /api/clientes/{id}**: Deleta um cliente específico.

### Créditos

- **POST /api/creditos**: Adiciona um novo crédito a uma conta.

### Débitos

- **POST /api/debitos**: Adiciona um novo débito a uma conta.

### Extrato

- **GET /api/extratos**: Retorna o extrato de todas as operações de uma conta.

## Banco de Dados

A aplicação utiliza um banco de dados H2 em memória, configurado no arquivo `application.properties`. O banco de dados é reiniciado toda vez que a aplicação é iniciada.

Para acessar a console do H2, acesse `http://localhost:8080/h2-console` e utilize as seguintes credenciais:

- **JDBC URL**: `jdbc:h2:mem:testdb`
- **User Name**: `sa`
- **Password**: *(deixe em branco)*

## Execução

1. Navegue até o diretório do backend:

    ```bash
    cd backend
    ```

2. Execute a aplicação:

    ```bash
    java -jar target/desafio-ibm-0.0.1-SNAPSHOT.jar
    ```

A aplicação estará disponível em `http://localhost:8080`.
