# EstoqueFácil API

API RESTful desenvolvida em Java com Spring Boot para controle de estoque de produtos por categoria.

## ✅ Requisitos

- Java JDK 17 ou superior
- Maven 3.8+
- PostgreSQL

## 📦 Dependências principais

- Spring Boot Starter Web
- Spring Data JPA
- PostgreSQL Driver
- Lombok
- Springdoc OpenAPI (Swagger)

## 🚀 Como rodar

1. Clone o projeto:
```bash
git clone https://martinsdevv/estoquefacil-api.git
```

2. Configure o `application.properties` com suas credenciais do banco:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/estoque
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

3. Rode com Maven:
```bash
mvn spring-boot:run
```

4. Acesse o Swagger:
```
http://localhost:8080/swagger-ui.html
```

---

## 📊 Endpoints (com prints da execução via Postman)

### 📁 Categoria

#### 🔸 Criar Categoria
![criar-categoria](docs/criar-categoria.PNG)

#### 🔸 Listar Categorias
![listar-categoria](docs/listar-categoria.PNG)

---

### 📦 Produto

#### 🔸 Criar Produto
![criar-produto](docs/criar-produto.PNG)

#### 🔸 Listar Produtos
![listar-produto](docs/listar-produto.PNG)

#### 🔸 Buscar Produto por ID
![buscar-produto](docs/buscar-produto.PNG)

#### 🔸 Atualizar Produto
![atualizar-produto](docs/atualizar-produto.PNG)

#### 🔸 Entrada de Estoque
![entrada-estoque](docs/entrada-estoque.PNG)

#### 🔸 Saída de Estoque
![saida-estoque](docs/saida-estoque.PNG)

#### 🔸 Deletar Produto
![deletar-produto](docs/deletar-produto.PNG)

---
