# api_techmanage
Sistema de aplicação para gerenciar usuários

#  Tecnologias
- Java 17
- Spring Boot 3.4.2
- Spring Data JPA
- Spring Data JDBC
- Spring Web
- Spring Boot Dev Tools
- H2 Database em memória 
- JDBC API

##  Como Rodar o Projeto

### 1. Clone o repositório:
```sh
git clone https://github.com/GisellaCosta/api_techmanage.git
```
### 2. Acesse o diretório do projeto:
```sh
cd api_techmanage
```
### 3.Com o maven instalado compile e rode a aplicação:
```sh
mvn spring-boot:run
```

## Como Rodar os Testes 

### 1. Execute este comando no terminal
```sh
mvn test
```

## Exemplos de requests 

### 1. Cadastrar novo usuário
POST /api/users/
```
{
    "fullName": "João da Silvaa",
    "email": "pedro.silva@emaill.com",
    "phone": "+55954199945",
    "birthDate": "1990-05-25",
    "userType": "ADMIN"
}
```

### 2. Buscar todos os usuários 
GET /api/users/
```
Sem body para essa requisição
```

### 3. Buscar usuários por Id
GET /api/users/1
```
Sem body para essa requisição
```

### 4. Atualizar cadastro do usuário
PUT /api/users/1
```
{
    "id": 2,
    "fullName": "João da Silva",
    "email": "gisella.silvaa@email.com",
    "phone": "+559999999998",
    "birthDate": "1990-05-20T00:00:00.000+00:00",
    "userType": "ADMIN"
}
```

### 5. Deletar um usuário
DELETE /api/users/1
```
Sem body para essa requisição
```

## Observações

 - Por padrão o projeto roda na porta 8080





