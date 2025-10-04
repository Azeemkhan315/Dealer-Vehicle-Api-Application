# Dealer Vehicle API Application 

This is a **Spring Boot REST API project** for managing **Dealers and Vehicles**.  
The application provides endpoints to add, view, and manage dealer details along with their vehicles.  

---

## Features
- Add new Dealer
- Fetch all Dealers
- Fetch Dealer by ID
- Update Dealer details
- Delete Dealer
- Add Vehicle for Dealer
- View Vehicles by Dealer

---

## 🛠 Tech Stack
- **Java 17** (or compatible)
- **Spring Boot 3.x**
- **Spring Data JPA**
- **MySQL Database**
- **Maven** for build
- **STS 

---

## 📂 Project Structure
Dealer-Vehicle-Api-Application/
┣ src/main/java/com/dealer/vehicle/
┃ ┣ controller/
┃ ┣ entity/
┃ ┣ repository/
┃ ┗ DealerVehicleApiApplication.java
┣ src/main/resources/
┃ ┣ application.properties
┗ pom.xml

---

## ⚙️ Configuration (application.properties)
```properties
spring.application.name=DealerVehicleApiApplication
spring.datasource.url=jdbc:mysql://localhost:3306/akdatabase
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
server.port=7777
▶️ Run the Project
Clone the repo:

git clone https://github.com/your-username/Dealer-Vehicle-Api-Application.git
Import into STS as a Maven Project.

Configure your MySQL DB in application.properties.

Run:

mvn spring-boot:run
OR simply run from your IDE.

🔗 API Endpoints
Dealer APIs
POST /dealers → Add new dealer

GET /dealers → Get all dealers

GET /dealers/{id} → Get dealer by ID

PUT /dealers/{id} → Update dealer

DELETE /dealers/{id} → Delete dealer

Vehicle APIs
POST /dealers/{id}/vehicles → Add vehicle to dealer

GET /dealers/{id}/vehicles → Get all vehicles of a dealer

📸 Screenshots

2. API Testing in Postman
![Postman Test](screenshots/postman (3).jpg)

🤝 Author
Azeem Khan
📧 azeemkhan37804@gmail.com
🌐 GitHub Profile
https://github.com/Azeemkhan315

Thank You
