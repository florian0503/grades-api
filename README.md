# 📚 Grades API

Une API REST construite avec **Spring Boot** pour gérer des sujets (topics) et leurs évaluations.

## 🚀 Fonctionnalités

- ✅ Créer, lire, mettre à jour et supprimer des sujets (`CRUD`)
- ✅ Architecture RESTful avec Spring Boot
- ✅ Persistance des données avec MySQL
- ✅ Validation des entrées avec Jakarta Validation

## 🧰 Technologies utilisées

- Java 17
- Spring Boot 3.4
- Spring Data JPA
- MySQL 8
- Maven

## 🗂 Structure du projet

src/ ├── controller # Contrôleurs REST ├── model # Entités JPA ├── repository # Interfaces de persistance ├── service # Logique métier └── GradesApiApplication.java


## ⚙️ Configuration de la base de données  

Le fichier `src/main/resources/application.properties` contient :  ```properties spring.datasource.url=jdbc:mysql://localhost:8889/evaluationdb spring.datasource.username=app_user spring.datasource.password=securePass123  spring.jpa.hibernate.ddl-auto=update spring.jpa.show-sql=true spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

📬 Endpoints  

Méthode URL Description 
GET /topics Liste tous les sujets 
GET /topics/{id} Détail d’un sujet 
POST /topics Crée un nouveau sujet 
PUT /topics/{id} Met à jour un sujet existant 
DELETE /topics/{id} Supprime un sujet  mvn spring-boot:run 

