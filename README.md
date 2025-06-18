# Todo Alucom

Este é um projeto de demonstração desenvolvido com Spring Boot, que implementa uma API REST para gerenciamento de tarefas (Todo).

## Requisitos

- Java 17 ou superior
- Maven
- PostgreSQL
- Docker e Docker Compose

## Rodando Projeto

O projeto já se encontra em ambiente de produção e pode ser acessado através das URLs: 
- Back-end: [https://todoalucomapi.onrender.com](https://todoalucomapi.onrender.com)
- Front-end: [https://to-do-alucom-app.vercel.app/](https://to-do-alucom-app.vercel.app/)

Para executar localmente, siga os passos abaixo:

1. Clone o repositório:

```bash
git clone https://github.com/pedroalima/ToDoAlucomAPI.git
```

Entre na raiz do projeto

```bash
cd ToDoAlucomAPI
```

### Usando Docker

Ainda no terminal, na raiz do projeto, construa a imagem Docker:

```bash
docker build -t pedroalima/alucom-api .
```

### Usando Docker Compose

Execute a aplicação usando Docker Compose:

```bash
docker-compose up -d
```

Este comando irá:

- Configurar automaticamente as variáveis de ambiente do banco de dados
- Iniciar o container do PostgreSQL
- Iniciar o container da API na porta 8080

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.5.0
- Spring Data JPA
- PostgreSQL
- Lombok
- Maven
- Docker
- Docker Compose
- Vercel
- Render

## Endpoints da API

A API fornece os seguintes endpoints para gerenciamento de tarefas:

### Listar Tarefas

- **GET** `/tasks`
- Resposta: Lista de tarefas

### Criar Tarefa

- **POST** `/tasks`
- Cria uma nova tarefa
- Corpo da requisição:
  ```json
  {
    "title": "string",       // obrigatório
    "description": "string", // opcional
    "completed": boolean,    // opcional
    "priority": integer     // opcional
  }
  ```
- Resposta: Lista atualizada de tarefas

### Atualizar Tarefa

- **PUT** `/tasks/:{id}`
- Atualiza uma tarefa existente
- Parâmetros:
  - `id`: ID da tarefa (path parameter)
- Corpo da requisição:
  ```json
  {
    "title": "string",
    "description": "string",
    "completed": boolean,
    "priority": int
  }
  ```
- Resposta: Lista atualizada de tarefas

### Excluir Tarefa

- **DELETE** `/tasks/:{id}`
- Remove uma tarefa
- Parâmetros:
  - `id`: ID da tarefa (path parameter)
- Resposta: Lista atualizada de tarefas

## Autor

- LinkedIn - [Pedro A. Lima](https://www.linkedin.com/in/pedroalima6/)
