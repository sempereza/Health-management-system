# Health Management System - Java Spring Boot Backend

## Overview
This is the Java Spring Boot backend for the Health Management System. It provides RESTful APIs for managing healthcare operations including doctors, patients, nurses, appointments, emergencies, payments, and inventory.

## Technology Stack
- **Java 17**
- **Spring Boot 3.2.0**
- **Spring Data MongoDB**
- **Spring Security**
- **JWT Authentication**
- **Lombok**
- **Maven**

## Project Structure
```
backend-java/
├── src/
│   └── main/
│       ├── java/com/hospital/
│       │   ├── HospitalManagementApplication.java
│       │   ├── model/              # Entity models
│       │   ├── repository/         # MongoDB repositories
│       │   ├── controller/         # REST controllers
│       │   └── config/             # Configuration classes
│       └── resources/
│           └── application.properties
├── pom.xml
└── README.md
```

## Prerequisites
- Java 17 or higher
- Maven 3.6+
- MongoDB 4.4+

## Installation

### 1. Install Java 17
Download and install Java 17 from [Oracle](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://adoptium.net/).

Verify installation:
```bash
java -version
```

### 2. Install Maven
Download from [Maven website](https://maven.apache.org/download.cgi) and add to PATH.

Verify installation:
```bash
mvn -version
```

### 3. Install Dependencies
```bash
cd backend-java
mvn clean install
```

## Configuration

### application.properties
Located at `src/main/resources/application.properties`:

```properties
server.port=8081
spring.data.mongodb.uri=mongodb://127.0.0.1:27017/hospitalDB
jwt.secret=your_secret_key_change_in_production_hospital_system_java
```

## Running the Application

### Using Maven
```bash
mvn spring-boot:run
```

### Using Java
```bash
mvn clean package
java -jar target/hospital-management-java-1.0.0.jar
```

The server will start on **http://localhost:8081**

## API Endpoints

### Base URL
```
http://localhost:8081/api/hospital
```

### Doctors API
- `GET /api/hospital/doctors` - Get all doctors
- `GET /api/hospital/doctors/{id}` - Get doctor by ID
- `GET /api/hospital/doctors/department/{department}` - Get doctors by department
- `GET /api/hospital/doctors/specialization/{specialization}` - Get doctors by specialization
- `POST /api/hospital/doctors` - Create new doctor
- `PUT /api/hospital/doctors/{id}` - Update doctor
- `DELETE /api/hospital/doctors/{id}` - Delete doctor

### Patients API
- `GET /api/hospital/patients` - Get all patients
- `GET /api/hospital/patients/{id}` - Get patient by ID
- `GET /api/hospital/patients/bloodGroup/{bloodGroup}` - Get patients by blood group
- `POST /api/hospital/patients` - Create new patient
- `PUT /api/hospital/patients/{id}` - Update patient
- `DELETE /api/hospital/patients/{id}` - Delete patient

### Nurses API
- `GET /api/hospital/nurses` - Get all nurses
- `GET /api/hospital/nurses/{id}` - Get nurse by ID
- `GET /api/hospital/nurses/department/{department}` - Get nurses by department
- `GET /api/hospital/nurses/shift/{shift}` - Get nurses by shift
- `POST /api/hospital/nurses` - Create new nurse
- `PUT /api/hospital/nurses/{id}` - Update nurse
- `DELETE /api/hospital/nurses/{id}` - Delete nurse

### Appointments API
- `GET /api/hospital/appointments` - Get all appointments
- `GET /api/hospital/appointments/today` - Get today's appointments
- `GET /api/hospital/appointments/patient/{patientId}` - Get appointments by patient
- `GET /api/hospital/appointments/doctor/{doctorId}` - Get appointments by doctor
- `POST /api/hospital/appointments` - Create new appointment
- `PUT /api/hospital/appointments/{id}` - Update appointment
- `DELETE /api/hospital/appointments/{id}` - Delete appointment

### Emergency API
- `GET /api/hospital/emergencies` - Get all emergencies
- `GET /api/hospital/emergencies/active` - Get active emergencies
- `GET /api/hospital/emergencies/severity/{severity}` - Get emergencies by severity
- `POST /api/hospital/emergencies` - Create new emergency
- `PUT /api/hospital/emergencies/{id}` - Update emergency

### Payments API
- `GET /api/hospital/payments` - Get all payments
- `GET /api/hospital/payments/patient/{patientId}` - Get payments by patient
- `GET /api/hospital/payments/status/{status}` - Get payments by status
- `POST /api/hospital/payments` - Create new payment
- `PUT /api/hospital/payments/{id}` - Update payment

### Storage/Inventory API
- `GET /api/hospital/storage` - Get all storage items
- `GET /api/hospital/storage/low-stock` - Get low stock items
- `GET /api/hospital/storage/category/{category}` - Get items by category
- `POST /api/hospital/storage` - Create new storage item
- `PUT /api/hospital/storage/{id}` - Update storage item
- `DELETE /api/hospital/storage/{id}` - Delete storage item

### Admissions API
- `GET /api/hospital/admissions` - Get all admissions
- `GET /api/hospital/admissions/active` - Get active admissions
- `GET /api/hospital/admissions/patient/{patientId}` - Get admissions by patient
- `POST /api/hospital/admissions` - Create new admission
- `PUT /api/hospital/admissions/{id}` - Update admission

### Dashboard API
- `GET /api/hospital/dashboard/stats` - Get dashboard statistics

## Testing APIs

### Using cURL
```bash
# Get all doctors
curl http://localhost:8081/api/hospital/doctors

# Create a new patient
curl -X POST http://localhost:8081/api/hospital/patients \
  -H "Content-Type: application/json" \
  -d '{"patientId":"P001","firstName":"John","lastName":"Doe","email":"john@example.com"}'
```

### Using Postman
Import the API endpoints into Postman and test them.

## Database Models

All models are automatically mapped to MongoDB collections using Spring Data MongoDB.

### Key Models:
- **Doctor** - Doctor profiles with specializations
- **Patient** - Patient records with medical history
- **Nurse** - Nurse management
- **Appointment** - Appointment scheduling
- **Emergency** - Emergency case tracking
- **Payment** - Billing and payments
- **Storage** - Inventory management
- **Admission** - Patient admissions

## Development

### Hot Reload
Spring Boot DevTools is included for automatic restart during development.

### Build
```bash
mvn clean package
```

### Run Tests
```bash
mvn test
```

## Deployment

### Create JAR
```bash
mvn clean package -DskipTests
```

The JAR file will be created in the `target/` directory.

### Run JAR
```bash
java -jar target/hospital-management-java-1.0.0.jar
```

## Port Configuration

- **Java Backend**: Port 8081
- **Node.js Backend**: Port 8080 (separate service)
- **React Frontend**: Port 3000

Both backends can run simultaneously and connect to the same MongoDB database.

## Troubleshooting

### Port Already in Use
Change the port in `application.properties`:
```properties
server.port=8082
```

### MongoDB Connection Failed
Ensure MongoDB is running:
```bash
net start MongoDB
```

### Java Version Issues
Ensure Java 17 is installed and set in JAVA_HOME.

## Contributing
Contributions are welcome! Please follow the coding standards and submit pull requests.

## License
MIT License

## Author
Kubanja Elijah Eldred & Team

---

**Hospital Management System - Java Backend Ready!** ☕🏥
