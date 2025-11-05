# 🚀 Quick Start Guide - Hospital Management System

## Prerequisites
Before you begin, ensure you have:
- ✅ Node.js installed (v14 or higher)
- ✅ MongoDB installed and configured
- ✅ npm package manager

## Installation Steps

### Step 1: Install Dependencies
Run the installation script:
```bash
INSTALL-DEPENDENCIES.bat
```

Or manually:
```bash
# Install backend dependencies
cd backend
npm install

# Install frontend dependencies
cd ../frontend
npm install
```

### Step 2: Configure MongoDB
Make sure MongoDB is running:
```bash
net start MongoDB
```

### Step 3: Start the Application
Run the startup script:
```bash
START-HEALTH-SYSTEM.bat
```

Or manually:
```bash
# Terminal 1 - Backend
cd backend
npm start

# Terminal 2 - Frontend
cd frontend
npm start
```

### Step 4: Access the Application
- **Frontend:** http://localhost:3000
- **Backend API:** http://localhost:8080

## Default Login Credentials
Create an admin user or use these test credentials:
- **Email:** admin@hospital.com
- **Password:** admin123

## Available Scripts

### Backend (in `backend/` directory)
- `npm start` - Start the backend server
- `npm run dev` - Start with nodemon (auto-restart)

### Frontend (in `frontend/` directory)
- `npm start` - Start development server
- `npm run build` - Build for production
- `npm test` - Run tests

## Features Overview

### 📊 Dashboard
View real-time statistics:
- Total patients, doctors, nurses
- Active emergencies
- Today's appointments
- Current admissions
- Payment status
- Inventory alerts

### 👥 Patient Management
- Register new patients
- Update patient records
- View medical history
- Track allergies and medications
- Manage insurance information

### 👨‍⚕️ Doctor Management
- Add/Edit doctor profiles
- Set specializations and departments
- Configure consultation fees
- Manage availability schedules

### 👩‍⚕️ Nurse Management
- Register nurses
- Assign shifts and wards
- Track department assignments

### 📅 Appointments
- Schedule appointments
- View doctor availability
- Manage appointment status
- Send reminders

### 🛏️ Admissions
- Admit patients
- Assign rooms and beds
- Track admission status
- Process discharges

### 🚨 Emergency
- Quick emergency admission
- Triage categorization
- Severity assessment
- Immediate treatment tracking

### 💰 Payments
- Process patient payments
- Generate invoices
- Track payment methods
- Insurance claim management

### 📦 Storage & Inventory
- Manage medical supplies
- Track medicine stock
- Low stock alerts
- Reorder management

## API Endpoints

All API endpoints are documented in the main README.md file.

**Base URL:** `http://localhost:8080/api`

### Quick API Examples

**Get all doctors:**
```javascript
GET http://localhost:8080/api/hospital/doctors
```

**Create new patient:**
```javascript
POST http://localhost:8080/api/hospital/patients
Content-Type: application/json

{
  "patientId": "P001",
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@email.com",
  "phone": "+1234567890",
  "dateOfBirth": "1990-01-01",
  "gender": "Male",
  "bloodGroup": "O+"
}
```

**Get dashboard stats:**
```javascript
GET http://localhost:8080/api/hospital/dashboard/stats
```

## Troubleshooting

### MongoDB Connection Failed
```bash
# Check if MongoDB is running
mongosh

# Start MongoDB service
net start MongoDB
```

### Port 8080 Already in Use
Edit `.env` file:
```
PORT=3001
```

### Frontend Can't Connect to Backend
1. Ensure backend is running on port 8080
2. Check `proxy` in `frontend/package.json`

### Dependencies Installation Errors
```bash
# Clear npm cache
npm cache clean --force

# Delete node_modules and reinstall
rmdir /s /q node_modules
npm install
```

## Next Steps

1. **Create Admin User** - Use the registration endpoint or MongoDB directly
2. **Add Sample Data** - Add doctors, patients, and other records
3. **Customize** - Modify UI colors, add features as needed
4. **Deploy** - Follow deployment guide for production

## Support

For issues or questions:
- Check the main README.md
- Review the API documentation
- Contact: support@hospital.com

---

**Happy Hospital Managing! 🏥**
