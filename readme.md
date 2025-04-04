# Sales Monitoring System

Este projeto é uma aplicação web que simula um sistema de monitoramento de vendas. A aplicação é composta por um back-end em Spring Boot (utilizando Spring Security, Spring Data JPA e JWT para autenticação) e um banco de dados H2 para armazenamento em memória.

## Pré-requisitos

- **Java JDK 17 ou superior:** Necessário para compilar e executar a aplicação.
- **Maven:** Utilizado para gerenciar dependências e construir o projeto.

## Instalação e Execução

### 1. Clonando o Repositório

Abra um terminal e execute:

```bash
git clone https://github.com/seu-usuario/sales-monitoring-system.git
```

Navegue até o diretório do projeto:

```bash
cd sales-monitoring-system
```

### 2. Compilando o Projeto

Utilize o Maven para compilar o projeto:

```bash
mvn clean install
```

### 3. Executando a Aplicação

Após a compilação, execute o projeto com:

```bash
mvn spring-boot:run
```

A aplicação estará disponível em [http://localhost:8080](http://localhost:8080).

## Principais Tecnologias e Bibliotecas

- **Spring Boot:** Facilita a criação e configuração de aplicações Java com mínima configuração inicial.
- **Spring Security:** Gerencia a autenticação e autorização dos usuários na aplicação. É utilizado para proteger endpoints e implementar a autenticação via JWT.
- **Spring Data JPA:** Simplifica a integração com o banco de dados através de repositórios e permite o uso da Java Persistence API (JPA) para operações CRUD.
- **JWT (JSON Web Tokens):** Utilizado para criar tokens que garantem a segurança e a integridade das informações de autenticação.
- **H2 Database:** Banco de dados relacional em memória utilizado para desenvolvimento e testes, facilitando o acesso e a visualização dos dados sem configuração externa.

## Testes Rápidos da Aplicação

### 1. Teste de Endpoints via ferramentas de API

- **Insomnia ou Postman:**

  - **Endpoint para criar usuário:**
    Faça uma requisição `POST` para:

    ```
    http://localhost:8080/user
    ```

    Corpo da requisição (JSON): [Os valores dessas variáveis podem ser alterados - mas lembre-se de alterar nos endpoints seguintes]

    ```json
    {
      "username": "gheyson",
      "email": "gheysonmelo@hotmail.com",
      "password": "123"
    }
    ```

  - **Endpoint de Login:**  
    Faça uma requisição `POST` para:

    ```
    http://localhost:8080/auth/login
    ```

    Corpo da requisição (JSON):

    ```json
    {
      "username": "gheyson",
      "password": "123"
    }
    ```

    Caso a autenticação seja bem-sucedida, um token JWT será retornado.
    OBS: Colocar na parte de autorização o token retornado no formato Bearer {token} no cabeçalho de todas as requisições que não sejam as citadas acima.

  - **Criando um Produto:**  
    Enviar uma requisição `POST` para:

    ```
    http://localhost:8080/product
    ```

    Corpo da requisição (JSON):

    ```json
    {
      "productName": "Coca-Cola Zero Lata",
      "productValue": 3.5
    }
    ```

  - **Criando uma Venda:**  
    Enviar uma requisição `POST` para:

    ```
    http://localhost:8080/sale
    ```

    Corpo da requisição (JSON):

    ```json
    {
      "quantity": 2,
      "saleDate": "2024-04-03",
      "price": 7.0,
      "product": { "id": 1 }
    }
    ```

    Se a requisição for bem-sucedida, a venda será registrada no banco de dados.

  -**Listando todas as vendas:**  
   Enviar uma requisição `GET` para:

  ```
  http://localhost:8080/sale
  ```

  Se a requisição for bem-sucedida, você verá uma listagem das vendas.
