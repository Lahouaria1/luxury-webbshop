Luxury Webshop Backend (Java + Spring Boot)

A simple webshop backend where users can browse, add, and manage products — built with Spring Boot.

Requirements

Java 21

Maven 3.9.9 (automatically installed via Maven Wrapper)

How to Build and Run
1. Clone the Repository

Open your terminal, navigate to your preferred folder, and run:

git clone https://github.com/Lahouaria1/luxury-webbshop.git
cd luxury-webbshop

2. Run the Application
Option 1 — Using the Maven Wrapper (recommended)
# Linux / macOS / WSL
./mvnw spring-boot:run

# Windows
mvnw.cmd spring-boot:run

Option 2 — Using globally installed Maven
mvn spring-boot:run


Once started, the app will run on:

http://localhost:8080

API Documentation

This project uses Swagger to document and test the API endpoints.

After starting the app, open this in your browser:

http://localhost:8080/swagger-ui/index.html

Test with Postman

You can also test all endpoints using Postman.

Example requests

GET http://localhost:8080/api/products — Get all products

GET http://localhost:8080/api/products/{id} — Get a specific product

POST http://localhost:8080/api/orders — Create a new order

Example POST body (raw JSON)
{
  "name": "Test Customer",
  "address": "Test Street",
  "email": "test@example.com",
  "items": [
    { "productId": 1, "quantity": 2 }
  ]
}

"# luxury-webbshop" 
