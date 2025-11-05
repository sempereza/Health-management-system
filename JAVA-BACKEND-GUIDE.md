# Java Spring Boot Backend - Setup and Usage Guide

## 🎯 Overview
Your Hospital Management System now includes a **Java Spring Boot** backend alongside the Node.js backend. Both backends:
- Connect to the same MongoDB database (`hospitalDB`)
- Provide identical REST APIs
- Can run simultaneously
- Support the same React frontend

## ✅ What Was Created

### Complete Java Spring Boot Application
```
backend-java/
├── src/main/java/com/hospital/
│   ├── HospitalManagementApplication.java  # Main application
│   ├── model/                              # 8 Entity models
│   │   ├── Doctor.java
│   │   ├── Patient.java
│   │   ├── Nurse.java
│   │   ├── Payment.java
│   │   ├── Emergency.java
│   │   ├── Appointment.java
│   │   ├── Storage.java
│   │   └── Admission.java
│   ├── repository/                         # 8 MongoDB repositories
│   ├── controller/                         # 9 REST controllers
│   └── config/                             # Configuration classes
├── src/main/resources/
│   └── application.properties              # Configuration
├── pom.xml                                 # Maven dependencies
└── README.md                               # Documentation
```

## 📋 Prerequisites

### 1. Install Java 17
**Download:**
- [Oracle JDK 17](https://www.oracle.com/java/technologies/downloads/#java17)
- [OpenJDK 17 (Adoptium)](https://adoptium.net/temurin/releases/)

**Windows Installation:**
1. Download the installer
2. Run the installer
3. Add Java to PATH
4. Verify:
```bash
java -version
```

### 2. Install Maven
**Download:** [Apache Maven](https://maven.apache.org/download.cgi)

**Windows Installation:**
1. Download the Binary zip archive
2. Extract to `C:\Program Files\Apache\maven`
3. Add to PATH: `C:\Program Files\Apache\maven\bin`
4. Verify:
```bash
mvn -version
```

### 3. Ensure MongoDB is Running
```bash
net start MongoDB
```

## 🚀 Quick Start

### Option 1: Using the Batch Script
```bash
cd backend-java
RUN-JAVA-BACKEND.bat
```

### Option 2: Using Maven Command
```bash
cd backend-java
mvn spring-boot:run
```

### Option 3: Build and Run JAR
```bash
cd backend-java
mvn clean package
java -jar target/hospital-management-java-1.0.0.jar
```

## 🌐 Access Points

### Java Backend
- **URL:** http://localhost:8081
- **API Base:** http://localhost:8081/api/hospital
- **Example:** http://localhost:8081/api/hospital/doctors

### Node.js Backend (still available)
- **URL:** http://localhost:8080
- **API Base:** http://localhost:8080/api/hospital

### Frontend
- **URL:** http://localhost:3000
- Configured to use **Node.js backend** (port 8080) by default

## 📊 Running Both Backends Simultaneously

### Terminal 1 - MongoDB
```bash
net start MongoDB
```

### Terminal 2 - Node.js Backend
```bash
cd backend
npm start
```

### Terminal 3 - Java Backend
```bash
cd backend-java
mvn spring-boot:run
```

### Terminal 4 - React Frontend
```bash
cd frontend
npm start
```

## 🔄 Switching Frontend Between Backends

### To Use Java Backend (Port 8081)
Update `frontend/package.json`:
```json
{
  "proxy": "http://localhost:8081"
}
```

### To Use Node.js Backend (Port 8080)
```json
{
  "proxy": "http://localhost:8080"
}
```

Then restart the React development server.

## 🧪 Testing the Java Backend

### Test with cURL

**Get all doctors:**
```bash
curl http://localhost:8081/api/hospital/doctors
```

**Get dashboard stats:**
```bash
curl http://localhost:8081/api/hospital/dashboard/stats
```

**Create a new patient:**
```bash
curl -X POST http://localhost:8081/api/hospital/patients ^
  -H "Content-Type: application/json" ^
  -d "{\"patientId\":\"P001\",\"firstName\":\"John\",\"lastName\":\"Doe\",\"email\":\"john@example.com\",\"phone\":\"+1234567890\",\"gender\":\"Male\",\"bloodGroup\":\"O+\",\"status\":\"Active\"}"
```

### Test with Browser
Open these URLs in your browser:
- http://localhost:8081/api/hospital/doctors
- http://localhost:8081/api/hospital/patients
- http://localhost:8081/api/hospital/dashboard/stats

## 📡 API Endpoints

All endpoints mirror the Node.js backend:

### Core Endpoints
- **Doctors:** `/api/hospital/doctors`
- **Patients:** `/api/hospital/patients`
- **Nurses:** `/api/hospital/nurses`
- **Appointments:** `/api/hospital/appointments`
- **Emergencies:** `/api/hospital/emergencies`
- **Payments:** `/api/hospital/payments`
- **Storage:** `/api/hospital/storage`
- **Admissions:** `/api/hospital/admissions`
- **Dashboard:** `/api/hospital/dashboard/stats`

### Example Operations

**GET** `/api/hospital/doctors` - Get all doctors
**GET** `/api/hospital/doctors/{id}` - Get doctor by ID
**GET** `/api/hospital/doctors/department/Cardiology` - Get cardiologists
**POST** `/api/hospital/doctors` - Create new doctor
**PUT** `/api/hospital/doctors/{id}` - Update doctor
**DELETE** `/api/hospital/doctors/{id}` - Delete doctor

## 🏗️ Architecture Comparison

### Node.js Backend
- **Runtime:** Node.js
- **Framework:** Express.js
- **Language:** JavaScript
- **Database:** Mongoose ODM
- **Port:** 8080

### Java Backend
- **Runtime:** JVM
- **Framework:** Spring Boot
- **Language:** Java 17
- **Database:** Spring Data MongoDB
- **Port:** 8081

### Shared Database
- **MongoDB:** hospitalDB
- **Collections:** Same collections for both backends

## 💡 When to Use Which Backend

### Use Node.js Backend When:
- You prefer JavaScript
- You need rapid development
- You're already familiar with Express.js
- Lighter resource usage needed

### Use Java Backend When:
- You prefer strongly-typed languages
- You need enterprise-level features
- Better IDE support needed (IntelliJ, Eclipse)
- Deploying to Java infrastructure

### Use Both When:
- Learning both technologies
- Load balancing across backends
- Gradual migration scenarios
- Redundancy requirements

## 🔧 Development

### Hot Reload (Java)
Spring Boot DevTools is included. Changes to Java files will trigger automatic restart.

### Build Project
```bash
mvn clean package
```

### Run Tests
```bash
mvn test
```

### Check Dependencies
```bash
mvn dependency:tree
```

## 📦 Key Dependencies

- **Spring Boot Starter Web** - REST API
- **Spring Boot Data MongoDB** - Database
- **Lombok** - Reduce boilerplate code
- **Spring Boot DevTools** - Development tools
- **Spring Boot Validation** - Input validation
- **JWT** - Authentication (ready for implementation)

## 🐛 Troubleshooting

### Port 8081 Already in Use
Change port in `application.properties`:
```properties
server.port=8082
```

### Maven Build Fails
```bash
# Clean Maven cache
mvn clean

# Update dependencies
mvn clean install -U
```

### Cannot Connect to MongoDB
1. Check MongoDB is running: `sc query MongoDB`
2. Verify connection string in `application.properties`
3. Test MongoDB: `mongosh`

### Java Not Found
```bash
# Check Java installation
java -version

# Set JAVA_HOME
setx JAVA_HOME "C:\Program Files\Java\jdk-17"
```

### Maven Not Found
Add Maven to PATH:
```bash
setx PATH "%PATH%;C:\Program Files\Apache\maven\bin"
```

## 📊 Performance Comparison

### Startup Time
- **Node.js:** ~2-3 seconds
- **Java:** ~5-8 seconds (first time), ~3-4 seconds (with JVM warm-up)

### Memory Usage
- **Node.js:** ~150-200 MB
- **Java:** ~300-400 MB

### Request Processing
- **Both:** Similar performance for CRUD operations
- **Java:** Better for complex calculations
- **Node.js:** Better for I/O operations

## 🔐 Security Features (Ready to Implement)

Both backends include JWT dependencies:
- Token-based authentication
- Password hashing
- Role-based access control
- CORS configuration

## 📚 Additional Resources

### Java/Spring Boot
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Data MongoDB](https://spring.io/projects/spring-data-mongodb)
- [Lombok Documentation](https://projectlombok.org/)

### Tools
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- [Eclipse IDE](https://www.eclipse.org/)
- [Spring Tool Suite](https://spring.io/tools)

## 🎓 Learning Path

1. **Start with Node.js backend** (easier learning curve)
2. **Learn Java basics** if not familiar
3. **Explore Spring Boot** tutorials
4. **Compare implementations** between both backends
5. **Choose your preferred stack** for production

## 🚀 Next Steps

1. **Install Java 17 and Maven**
2. **Run the Java backend** using `RUN-JAVA-BACKEND.bat`
3. **Test the APIs** with Postman or cURL
4. **Compare with Node.js backend**
5. **Choose your preferred backend** for development

---

**You now have TWO powerful backends for your Hospital Management System!** ☕🚀

**Node.js** (Port 8080) + **Java Spring Boot** (Port 8081) + **React** (Port 3000) = Complete Full-Stack Application! 🏥✨
