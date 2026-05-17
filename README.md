

# Customer Complaint Analytics & Ticket Management System

A Java Spring Boot backend application designed to simulate enterprise-style customer complaint and ticket management workflows. The system enables complaint tracking, ticket prioritization, analyst comments, workflow status management, and operational analytics using RESTful APIs and PostgreSQL.

---

## Features

* Customer complaint/ticket creation
* Ticket status management
* Automated priority assignment
* Analyst comments and updates
* Complaint categorization
* Operational analytics APIs
* RESTful backend architecture
* PostgreSQL database integration
* Layered Spring Boot application design
* Postman API testing support

---

## Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Maven
* Lombok
* REST APIs
* Postman

---

## Project Structure

```bash id="hmg7l2"
src/main/java/com/prajwal/complaints
│
├── controller
├── dto
├── entity
├── repository
├── service
└── ComplaintAnalyticsApplication.java
```

---

## Core Functionalities

### Ticket Management

* Create customer complaints
* Assign categories and priorities
* Track ticket status:

  * OPEN
  * IN_PROGRESS
  * RESOLVED

### Analytics

* Total tickets summary
* Open vs resolved tickets
* High-priority complaint tracking
* Complaint category analytics
* Workflow monitoring APIs

### Comments System

* Add analyst investigation comments
* Track ticket updates
* Maintain operational notes history

---

## API Endpoints

### Tickets

#### Create Ticket

```http id="mv29l4"
POST /api/tickets
```

#### Get All Tickets

```http id="v4j5uo"
GET /api/tickets
```

#### Get Ticket By ID

```http id="xwdjjq"
GET /api/tickets/{id}
```

#### Update Ticket Status

```http id="h0lfyn"
PUT /api/tickets/{id}/status
```

---

### Comments

#### Add Comment

```http id="dyu4e8"
POST /api/tickets/{ticketId}/comments
```

#### Get Ticket Comments

```http id="ejixcr"
GET /api/tickets/{ticketId}/comments
```

---

### Analytics

#### Ticket Summary

```http id="3d8w8v"
GET /api/analytics/summary
```

---

## Sample Ticket Request

```json id="2s9v7f"
{
  "customerName": "John Murphy",
  "customerEmail": "john@email.com",
  "category": "Fraud",
  "subject": "Unauthorized transaction",
  "description": "Customer reported an unauthorized card transaction on their account."
}
```

---

## Sample Response

```json id="42mcfm"
{
  "id": 1,
  "customerName": "John Murphy",
  "category": "Fraud",
  "priority": "HIGH",
  "status": "OPEN"
}
```

---

## Database Setup

Create PostgreSQL database:

```sql id="3v95hm"
CREATE DATABASE complaint_analytics_db;
```

---

## Configure application.properties

```properties id="gxx73p"
spring.datasource.url=jdbc:postgresql://localhost:5432/complaint_analytics_db
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## Run the Project

### Clone Repository

```bash id="rbdd90"
git clone https://github.com/PrajwalMahanawar/Customer-Complaint-Analytics-Ticket-Management-System.git
```

### Navigate to Project

```bash id="r8m3a6"
cd Customer-Complaint-Analytics-Ticket-Management-System
```

### Run Spring Boot Application

```bash id="y88spn"
./mvnw spring-boot:run
```

---

## Future Improvements

* Spring Security + JWT Authentication
* Role-based access control
* SLA breach monitoring
* Email notification integration
* Dashboard frontend integration
* Pagination and filtering
* Swagger/OpenAPI documentation
* Docker deployment
* Unit and integration testing

---

## Learning Outcomes

This project helped strengthen understanding of:

* Java Spring Boot backend development
* REST API architecture
* Enterprise workflow systems
* PostgreSQL integration
* Layered application architecture
* Ticket management workflows
* Operational analytics systems
* API testing and debugging

---

## Author

### Prajwal Mahanawar

* GitHub: https://github.com/PrajwalMahanawar
* LinkedIn: https://www.linkedin.com/in/prajwal-mahanawar-710325222/
