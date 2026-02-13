# 💸 ExpenseApp 

A Spring Boot backend application inspired by Splitwise, designed to manage shared expenses, split bills among users, track balances, and settle up payments.

---

## 🚀 Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA (Hibernate)
- MySQL
- Maven
- RESTful APIs
- Apache Tomcat (Embedded)

---

## ✨ Features

- 👤 User creation  
- 💰 Add expenses  
- 👥 Split expenses among multiple users  
- 📊 Track balances between users  
- 🔁 Settle up (clear dues)  
- 🧱 Layered architecture (Controller → Service → Repository)

---

## 🏗️ Project Architecture
```
expenseapp
├── controller
├── service
├── repository
├── entity
├── dto
└── ExpenseappApplication.java
```
---

## 📌 API Endpoints

### 👤 Users
- POST `/users`
- GET `/users`

### 💰 Expenses
- POST `/expenses`
- GET `/expenses`

### 🔀 Split Expense
- POST `/expenses/{expenseId}/split`

### 🤝 Settle Up
- POST `/settle`

---

## 🧪 Sample JSON Requests

### 👤 Create User
```json
{
  "name": "Gangadhar",
  "email": "gangadhar@gmail.com"
}
```
### 💰 Add Expense
```json
{
  "amount": 600,
  "description": "Trip Dinner",
  "userId": 1
}
```
### 🔀 Split Expense
```json
{
  "splits": [
    { "userId": 1, "amount": 300 },
    { "userId": 2, "amount": 300 }
  ]
}
```

## ⚙️ Database Configuration

Update `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/expenseapp
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.open-in-view=false

server.port=8081
```

## ▶️ Run the Application

### Using Maven
```bash
./mvnw spring-boot:run
```

### Using JAR
```bash
java -jar target/expenseapp-0.0.1-SNAPSHOT.jar
```

## 🎯 Learning Outcomes

- Built a real-world backend system
- Hands-on experience with Spring Boot & JPA
- REST API design
- Maven lifecycle & GitHub workflow
- Debugged real production issues

## 🔮 Future Enhancements

- JWT Authentication
- Group-based expenses
- Expense analytics
- Frontend integration
- Cloud deployment

## 👨‍💻 Author

**Gangadhar Kodari**  
B.Tech – Computer Science  
Backend Developer (Java | Spring Boot)

🔗 GitHub: https://github.com/kodari-gangadhar
