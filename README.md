# 🏥 Health Management System

A comprehensive healthcare platform built with **React**, **Node.js/Java Spring Boot**, **Express**, and **MongoDB**. Health Management System manages all aspects of healthcare operations including patients, doctors, nurses, appointments, emergency cases, payments, and inventory.

> **NEW:** Now includes **Java Spring Boot** backend alongside Node.js! Choose your preferred backend technology.

## 📋 Table of Contents
- [Features](#features)
- [Technology Stack](#technology-stack)
- [System Architecture](#system-architecture)
- [Installation](#installation)
- [Configuration](#configuration)
- [Running the Application](#running-the-application)
- [API Documentation](#api-documentation)
- [Database Models](#database-models)
- [Project Structure](#project-structure)
- [Contributing](#contributing)

## ✨ Features

### Core Modules
- **👥 Patient Management** - Register, update, and manage patient records with complete medical history
- **👨‍⚕️ Doctor Management** - Manage doctor profiles, specializations, schedules, and availability
- **👩‍⚕️ Nurse Management** - Track nurse assignments, shifts, and departments
- **📅 Appointment Scheduling** - Book, reschedule, and manage patient appointments
- **🛏️ Admission Management** - Handle patient admissions, room assignments, and discharges
- **🚨 Emergency Module** - Rapid emergency case management with triage system
- **💰 Payment System** - Process payments, generate invoices, and manage billing
- **📦 Storage & Inventory** - Track medical supplies, equipment, and medicines
- **📊 Dashboard** - Real-time statistics and quick access to critical information

### Key Features
- ✅ Role-based access control (Admin, Doctor, Nurse, Patient, etc.)
- ✅ Real-time dashboard with statistics
- ✅ Comprehensive patient medical history
- ✅ Emergency triage categorization
- ✅ Insurance claim management
- ✅ Low stock alerts for inventory
- ✅ Appointment scheduling and management
- ✅ Modern and responsive UI
- ✅ RESTful API architecture

## 🛠️ Technology Stack

### Frontend
- **React 18.2** - UI library
- **React Router 6.20** - Client-side routing
- **Axios** - HTTP client
- **CSS3** - Styling

### Backend (Dual Options)

#### Option 1: Node.js Backend (Port 8080)
- **Node.js** - Runtime environment
- **Express 4.19** - Web framework
- **MongoDB** - Database
- **Mongoose 8.7** - ODM for MongoDB
- **bcryptjs** - Password hashing
- **jsonwebtoken** - JWT authentication
- **CORS** - Cross-origin resource sharing
- **Multer** - File upload handling

#### Option 2: Java Spring Boot Backend (Port 8081) ⭐ NEW
- **Java 17** - Programming language
- **Spring Boot 3.2** - Application framework
- **Spring Data MongoDB** - Database integration
- **Spring Security** - Security framework
- **JWT** - Authentication tokens
- **Lombok** - Code generation
- **Maven** - Build tool

### Development Tools
- **nodemon** - Auto-restart server during development
- **dotenv** - Environment variable management

## 🏗️ System Architecture

```
hospital-management-system/
│
├── backend/                    # Node.js/Express backend (Port 8080)
├── backend-java/               # Java Spring Boot backend (Port 8081) ⭐ NEW
│   ├── models/                 # Mongoose models
│   │   ├── Admin.js
│   │   ├── Doctor.js
│   │   ├── Patient.js
│   │   ├── Nurse.js
│   │   ├── Payment.js
│   │   ├── Emergency.js
│   │   ├── Storage.js
│   │   ├── Appointment.js
│   │   ├── Admission.js
│   │   └── User.js
│   │
│   ├── routes/                 # API routes
│   │   ├── hospital-api.js     # Main hospital routes
│   │   └── auth.js             # Authentication routes
│   │
│   ├── middleware/             # Custom middleware
│   ├── uploads/                # File uploads directory
│   ├── server.js               # Express server
│   └── package.json            # Backend dependencies
│
├── frontend/                   # React frontend
│   ├── public/                 # Static files
│   │   ├── index.html
│   │   └── manifest.json
│   │
│   ├── src/
│   │   ├── components/         # Reusable components
│   │   │   ├── Sidebar.js
│   │   │   └── Layout.js
│   │   │
│   │   ├── pages/              # Page components
│   │   │   ├── Dashboard.js
│   │   │   ├── Login.js
│   │   │   ├── Doctors.js
│   │   │   ├── Patients.js
│   │   │   ├── Nurses.js
│   │   │   ├── Appointments.js
│   │   │   ├── Emergency.js
│   │   │   ├── Payments.js
│   │   │   ├── Storage.js
│   │   │   └── Admissions.js
│   │   │
│   │   ├── App.js              # Main app component
│   │   ├── App.css             # Main styles
│   │   ├── index.js            # Entry point
│   │   └── index.css           # Global styles
│   │
│   └── package.json            # Frontend dependencies
│
├── .env                        # Environment variables
└── README.md                   # Documentation
```

## 📦 Installation

### Prerequisites
- **Node.js** (v14 or higher)
- **MongoDB** (v4.4 or higher)
- **npm** or **yarn**

### Step 1: Clone or Navigate to Repository
```bash
cd "c:\Users\ELDRED\Desktop\hospital management system"
```

### Step 2: Install Backend Dependencies
```bash
cd backend
npm install
```

### Step 3: Install Frontend Dependencies
```bash
cd ../frontend
npm install
```

### Step 4: Configure MongoDB
Make sure MongoDB is installed and running on your system.

**Windows:**
```bash
net start MongoDB
```

**Linux/Mac:**
```bash
sudo systemctl start mongod
```

## ⚙️ Configuration

### Environment Variables
The `.env` file is already configured at the root directory:

```env
MONGODB_URI=mongodb://127.0.0.1:27017/hospitalDB
PORT=8080
JWT_SECRET=your_secret_key_change_in_production_hospital_system
```

**Important:** Change the `JWT_SECRET` in production!

## 🚀 Running the Application

### Development Mode

#### Option 1: Run Both Servers Separately

**Terminal 1 - Backend Server:**
```bash
cd backend
npm start
# or for auto-restart on changes:
npm run dev
```

**Terminal 2 - Frontend Development Server:**
```bash
cd frontend
npm start
```

The React app will open at `http://localhost:3000` and proxy API requests to `http://localhost:8080`.

#### Option 2: Build and Run Production

**Build Frontend:**
```bash
cd frontend
npm run build
```

**Start Backend (serves frontend build):**
```bash
cd backend
npm start
```

Access the application at `http://localhost:8080`

## 📚 API Documentation

### Base URL
```
http://localhost:8080/api
```

### Authentication Routes
- `POST /api/auth/login` - User login
- `POST /api/auth/register` - User registration

### Hospital API Routes (Prefix: `/api/hospital`)

#### Doctors
- `GET /api/hospital/doctors` - Get all doctors
- `GET /api/hospital/doctors/:id` - Get doctor by ID
- `POST /api/hospital/doctors` - Create new doctor
- `PUT /api/hospital/doctors/:id` - Update doctor
- `DELETE /api/hospital/doctors/:id` - Delete doctor

#### Patients
- `GET /api/hospital/patients` - Get all patients
- `GET /api/hospital/patients/:id` - Get patient by ID
- `POST /api/hospital/patients` - Create new patient
- `PUT /api/hospital/patients/:id` - Update patient
- `DELETE /api/hospital/patients/:id` - Delete patient

#### Nurses
- `GET /api/hospital/nurses` - Get all nurses
- `POST /api/hospital/nurses` - Create new nurse
- `PUT /api/hospital/nurses/:id` - Update nurse
- `DELETE /api/hospital/nurses/:id` - Delete nurse

#### Appointments
- `GET /api/hospital/appointments` - Get all appointments
- `GET /api/hospital/appointments/doctor/:doctorId` - Get appointments by doctor
- `GET /api/hospital/appointments/patient/:patientId` - Get appointments by patient
- `POST /api/hospital/appointments` - Create new appointment
- `PUT /api/hospital/appointments/:id` - Update appointment
- `DELETE /api/hospital/appointments/:id` - Delete appointment

#### Emergency
- `GET /api/hospital/emergencies` - Get all emergencies
- `GET /api/hospital/emergencies/active` - Get active emergencies
- `POST /api/hospital/emergencies` - Create new emergency
- `PUT /api/hospital/emergencies/:id` - Update emergency

#### Payments
- `GET /api/hospital/payments` - Get all payments
- `GET /api/hospital/payments/patient/:patientId` - Get payments by patient
- `POST /api/hospital/payments` - Create new payment
- `PUT /api/hospital/payments/:id` - Update payment

#### Storage/Inventory
- `GET /api/hospital/storage` - Get all storage items
- `GET /api/hospital/storage/low-stock` - Get low stock items
- `POST /api/hospital/storage` - Create new storage item
- `PUT /api/hospital/storage/:id` - Update storage item
- `DELETE /api/hospital/storage/:id` - Delete storage item

#### Admissions
- `GET /api/hospital/admissions` - Get all admissions
- `GET /api/hospital/admissions/active` - Get active admissions
- `POST /api/hospital/admissions` - Create new admission
- `PUT /api/hospital/admissions/:id` - Update admission

#### Dashboard
- `GET /api/hospital/dashboard/stats` - Get dashboard statistics

## 🗄️ Database Models

### User Model
- **Fields:** name, email, passwordHash, photoPath, role, isActive, profileId
- **Roles:** admin, doctor, nurse, patient, receptionist, pharmacist, lab_technician

### Doctor Model
- **Fields:** doctorId, firstName, lastName, email, phone, specialization, qualification, department, yearsOfExperience, consultationFee, availableDays, availableTimeSlots, licenseNumber, status

### Patient Model
- **Fields:** patientId, firstName, lastName, dateOfBirth, gender, bloodGroup, email, phone, address, emergencyContact, medicalHistory, allergies, currentMedications, insuranceDetails, status

### Nurse Model
- **Fields:** nurseId, firstName, lastName, email, phone, department, qualification, specialization, yearsOfExperience, shift, licenseNumber, assignedWard, status

### Admin Model
- **Fields:** adminId, firstName, lastName, email, phone, role, department, permissions, status

### Payment Model
- **Fields:** paymentId, patientId, amount, paymentType, paymentMethod, status, transactionId, invoiceNumber, insuranceClaim, discount, tax, totalAmount

### Emergency Model
- **Fields:** emergencyId, patientId, patientName, age, gender, arrivalTime, emergencyType, severity, chiefComplaint, vitalSigns, symptoms, allergies, triageCategory, assignedDoctor, assignedNurse, treatment, diagnosis, outcome, status

### Storage Model
- **Fields:** itemId, itemName, category, description, quantity, unit, minimumStockLevel, reorderLevel, supplier, manufacturer, batchNumber, expiryDate, purchasePrice, sellingPrice, location, status

### Appointment Model
- **Fields:** appointmentId, patientId, doctorId, appointmentDate, timeSlot, department, appointmentType, reason, status

### Admission Model
- **Fields:** admissionId, patientId, doctorId, admissionDate, dischargeDate, roomNumber, bedNumber, ward, admissionType, diagnosis, treatment, status

## 📁 Project Structure Details

### Backend Structure
- **models/** - Contains all Mongoose schemas and models
- **routes/** - Express route handlers for all API endpoints
- **middleware/** - Custom middleware for authentication, validation, etc.
- **uploads/** - Directory for storing uploaded files
- **server.js** - Main Express server configuration

### Frontend Structure
- **components/** - Reusable React components (Sidebar, Layout, etc.)
- **pages/** - Individual page components for each module
- **App.js** - Main application component with routing
- **index.js** - Entry point for React application

## 🔐 Security Features

- Password hashing with bcryptjs
- JWT-based authentication
- Role-based access control
- CORS protection
- Environment variable protection
- Input validation

## 🎨 UI Features

- Modern and clean design
- Responsive layout
- Intuitive navigation with sidebar
- Color-coded status badges
- Modal dialogs for forms
- Real-time dashboard statistics
- Mobile-friendly interface

## 📝 Default Credentials

**Note:** Create an admin user in MongoDB or use the registration endpoint.

```
Email: admin@hospital.com
Password: admin123
```

## 🐛 Troubleshooting

### MongoDB Connection Issues
```bash
# Check if MongoDB is running
mongosh

# Or check service status (Windows)
sc query MongoDB

# Start MongoDB (Windows)
net start MongoDB
```

### Port Already in Use
```bash
# Change PORT in .env file
PORT=3001
```

### Frontend Not Connecting to Backend
- Ensure backend is running on port 8080
- Check proxy setting in frontend/package.json

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License.

## 👥 Authors

**Kubanja Elijah Eldred & Team**

## 🙏 Acknowledgments

- React community for excellent documentation
- Express.js for the robust web framework
- MongoDB for flexible database solution
- All open-source contributors

## 📞 Support

For support, email support@hospital.com or open an issue in the repository.

---

**Health Management System - Built with ❤️ for better healthcare management**
