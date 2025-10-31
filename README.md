# Projeto MALU – CRUD Spring Boot

## Sobre o Projeto

Uma aplicação web desenvolvida em **Java**, modelada no padrão **MVC** e construída com o **Spring Boot**.  
O projeto implementa operações de **CRUD (Create, Read, Update e Delete)** com persistência em **banco de dados MySQL**.

Na camada de visualização, foram utilizados **HTML**, **CSS**, o framework **Bootstrap** e o template engine **Thymeleaf**.  
O sistema conta ainda com **validação de regras de negócio em JavaScript**, além de **autenticação com tela de login** e **criptografia de dados de usuários**.

---

## 🧰 Tecnologias Utilizadas

- Java
- Spring Boot
- JPA / Hibernate
- Maven
- HTML / CSS / JS
- Bootstrap
- Thymeleaf
- MySQL

---

## 🗃️ Banco de Dados

### Entidade Usuário

![Entidade Usuário]
https://github.com/marcianev/malu/blob/master/src/main/resources/static/img/entidade_usuario.png

### Entidade Produto

![Entidade Produto]
https://github.com/marcianev/malu/blob/master/src/main/resources/static/img/entidade_produto.png

---

## ⚙️ Instalação

O projeto é gerenciado pelo **Maven**.  
Para utilizá-lo, basta importá-lo em uma IDE compatível (como Eclipse ou IntelliJ).

---

## 🛠️ Configurações do Banco de Dados

Crie um banco de dados **MySQL** (nome à sua escolha) e ajuste as configurações no arquivo  
`src/main/resources/application.properties` conforme abaixo:

```properties
spring.datasource.url = jdbc:mysql://localhost:3306/nome-do-seu-banco?useTimezone=true&serverTimezone=UTC
spring.datasource.username = root
spring.datasource.password = ""
```
