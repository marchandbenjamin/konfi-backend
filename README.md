# 🥘 Konfi Notes — Cooking Recipe Blog Backend

**Konfi Notes** is a personal project aiming to power a cooking recipe blog. This backend application provides a REST API to manage recipes, ingredients, and cooking steps.

## ✨ Features

- Full CRUD for cooking recipes
- Ingredient and step-by-step management
- RESTful API
- PostgreSQL database
- Schema migration with Flyway
- Unit tests with Spring Boot Test

## 🛠️ Tech Stack

- Java 21
- Spring Boot 3
- PostgreSQL
- JPA (Hibernate)
- Flyway
- Maven
- Lombok

---

## 🚀 Getting Started

### 1. Prerequisites

You’ll need the following installed:

- [Java 21](https://adoptium.net/)
- [Maven](https://maven.apache.org/)
- [PostgreSQL](https://www.postgresql.org/) (v13+ recommended)

### 2. Start PostgreSQL with Docker

A `docker-compose.yml` file is included for local development. Just run:

```bash
docker-compose up -d
```

This will start a PostgreSQL container with the correct configuration.  

### 3. Run the application

With Maven wrapper:

```bash
./mvnw spring-boot:run
```

Or by building the JAR:

```bash
./mvnw clean package
java -jar target/konfi-0.0.1-SNAPSHOT.jar
```

The API will be available at: `http://localhost:8080`

---

## 🧪 Running Tests

```bash
./mvnw test
```

---

## 👨‍💻 Author

Created by **Benjamin Marchand**

---
