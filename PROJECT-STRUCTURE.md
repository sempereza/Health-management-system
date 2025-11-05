# Hospital Management System - Project Structure

```
hospital-management-system/
│
├── 📁 backend/                          # Node.js Backend Server
│   ├── 📁 middleware/                   # Authentication & validation middleware
│   │
│   ├── 📁 models/                       # MongoDB/Mongoose Models
│   │   ├── 📄 Admin.js                 # Admin user model
│   │   ├── 📄 Admission.js             # Patient admission model
│   │   ├── 📄 Appointment.js           # Appointment scheduling model
│   │   ├── 📄 Doctor.js                # Doctor profile model
│   │   ├── 📄 Emergency.js             # Emergency case model
│   │   ├── 📄 Nurse.js                 # Nurse profile model
│   │   ├── 📄 Patient.js               # Patient records model
│   │   ├── 📄 Payment.js               # Payment & billing model
│   │   ├── 📄 Storage.js               # Inventory management model
│   │   └── 📄 User.js                  # User authentication model
│   │
│   ├── 📁 routes/                       # API Route Handlers
│   │   ├── 📄 hospital-api.js          # Main hospital API routes
│   │   ├── 📄 auth.js                  # Authentication routes
│   │   └── 📄 package.json             # Routes package config
│   │
│   ├── 📁 uploads/                      # File upload directory
│   │
│   ├── 📄 server.js                     # Express server entry point
│   ├── 📄 package.json                  # Backend dependencies
│   └── 📄 package-lock.json             # Dependency lock file
│
├── 📁 frontend/                         # React Frontend Application
│   ├── 📁 public/                       # Static files
│   │   ├── 📄 index.html               # HTML template
│   │   └── 📄 manifest.json            # PWA manifest
│   │
│   ├── 📁 src/                          # React source code
│   │   ├── 📁 components/              # Reusable components
│   │   │   ├── 📄 Layout.js           # Page layout wrapper
│   │   │   └── 📄 Sidebar.js          # Navigation sidebar
│   │   │
│   │   ├── 📁 pages/                   # Page components
│   │   │   ├── 📄 Dashboard.js        # Main dashboard
│   │   │   ├── 📄 Login.js            # Login page
│   │   │   ├── 📄 Login.css           # Login styles
│   │   │   ├── 📄 Doctors.js          # Doctors management
│   │   │   ├── 📄 Patients.js         # Patients management
│   │   │   ├── 📄 Nurses.js           # Nurses management
│   │   │   ├── 📄 Appointments.js     # Appointments scheduling
│   │   │   ├── 📄 Emergency.js        # Emergency cases
│   │   │   ├── 📄 Payments.js         # Payment management
│   │   │   ├── 📄 Storage.js          # Inventory management
│   │   │   └── 📄 Admissions.js       # Patient admissions
│   │   │
│   │   ├── 📄 App.js                   # Main app component
│   │   ├── 📄 App.css                  # App styles
│   │   ├── 📄 index.js                 # React entry point
│   │   └── 📄 index.css                # Global styles
│   │
│   ├── 📄 package.json                  # Frontend dependencies
│   └── 📄 package-lock.json             # Dependency lock file
│
├── 📄 .env                              # Environment variables
├── 📄 .gitignore                        # Git ignore rules
│
├── 📄 README.md                         # Complete documentation
├── 📄 QUICK-START-GUIDE.md             # Quick setup guide
├── 📄 CHANGES.md                        # Transformation changelog
├── 📄 PROJECT-STRUCTURE.md             # This file
│
├── 📄 INSTALL-DEPENDENCIES.bat         # Auto-install script
├── 📄 START-HEALTH-SYSTEM.bat          # Auto-start script
└── 📄 cleanup-models.ps1                # Utility script

```

## 📊 Component Hierarchy

```
App.js
│
├── Router
    │
    ├── Login (/)
    │
    └── Protected Routes
        │
        ├── Dashboard (/dashboard)
        │   └── Layout
        │       ├── Sidebar
        │       └── Dashboard Stats
        │
        ├── Doctors (/doctors)
        │   └── Layout
        │       ├── Sidebar
        │       └── Doctors Table + Modal
        │
        ├── Patients (/patients)
        │   └── Layout
        │       ├── Sidebar
        │       └── Patients Table
        │
        ├── Nurses (/nurses)
        │   └── Layout
        │       ├── Sidebar
        │       └── Nurses Table
        │
        ├── Appointments (/appointments)
        │   └── Layout
        │       ├── Sidebar
        │       └── Appointments Table
        │
        ├── Emergency (/emergency)
        │   └── Layout
        │       ├── Sidebar
        │       └── Emergency Cases Table
        │
        ├── Payments (/payments)
        │   └── Layout
        │       ├── Sidebar
        │       └── Payments Table
        │
        ├── Storage (/storage)
        │   └── Layout
        │       ├── Sidebar
        │       └── Inventory Table
        │
        └── Admissions (/admissions)
            └── Layout
                ├── Sidebar
                └── Admissions Table
```

## 🔄 Data Flow

```
User Interface (React)
        ↓
    Axios HTTP Request
        ↓
Express Server (Port 8080)
        ↓
    Route Handler
        ↓
MongoDB Database (hospitalDB)
        ↓
    Mongoose Model
        ↓
    JSON Response
        ↓
React Component Update
        ↓
    UI Re-render
```

## 🗄️ Database Collections

```
hospitalDB
│
├── users              # Authentication users
├── doctors            # Doctor profiles
├── patients           # Patient records
├── nurses             # Nurse profiles
├── admins             # Admin users
├── appointments       # Appointment schedules
├── admissions         # Patient admissions
├── emergencies        # Emergency cases
├── payments           # Payment records
└── storages           # Inventory items
```

## 🚀 API Endpoints Structure

```
http://localhost:8080
│
├── /api/auth/
│   ├── POST /login
│   └── POST /register
│
└── /api/hospital/
    ├── /doctors
    │   ├── GET    /
    │   ├── GET    /:id
    │   ├── POST   /
    │   ├── PUT    /:id
    │   └── DELETE /:id
    │
    ├── /patients
    │   ├── GET    /
    │   ├── GET    /:id
    │   ├── POST   /
    │   ├── PUT    /:id
    │   └── DELETE /:id
    │
    ├── /nurses
    │   ├── GET    /
    │   ├── POST   /
    │   ├── PUT    /:id
    │   └── DELETE /:id
    │
    ├── /appointments
    │   ├── GET    /
    │   ├── GET    /doctor/:doctorId
    │   ├── GET    /patient/:patientId
    │   ├── POST   /
    │   ├── PUT    /:id
    │   └── DELETE /:id
    │
    ├── /emergencies
    │   ├── GET    /
    │   ├── GET    /active
    │   ├── POST   /
    │   └── PUT    /:id
    │
    ├── /payments
    │   ├── GET    /
    │   ├── GET    /patient/:patientId
    │   ├── POST   /
    │   └── PUT    /:id
    │
    ├── /storage
    │   ├── GET    /
    │   ├── GET    /low-stock
    │   ├── POST   /
    │   ├── PUT    /:id
    │   └── DELETE /:id
    │
    ├── /admissions
    │   ├── GET    /
    │   ├── GET    /active
    │   ├── POST   /
    │   └── PUT    /:id
    │
    └── /dashboard
        └── GET    /stats
```

## 📦 Dependencies Overview

### Backend Dependencies
- **express** - Web framework
- **mongoose** - MongoDB ODM
- **bcryptjs** - Password hashing
- **jsonwebtoken** - JWT auth
- **cors** - Cross-origin requests
- **dotenv** - Environment config
- **multer** - File uploads

### Frontend Dependencies
- **react** - UI library
- **react-dom** - React DOM renderer
- **react-router-dom** - Routing
- **axios** - HTTP client
- **react-scripts** - Build tools

## 🔐 Security Layers

```
Request Flow with Security:

User → HTTPS → CORS Middleware → Authentication Middleware → Authorization Check → Route Handler → Database
```

## 📱 Responsive Design Breakpoints

```css
Mobile:     < 768px
Tablet:     768px - 1024px
Desktop:    > 1024px
```

## 🎨 UI Component Structure

```
Page Layout
│
├── Sidebar (Fixed, 250px width)
│   ├── Logo & Title
│   ├── Navigation Menu
│   └── Logout Button
│
└── Main Content (Responsive)
    ├── Page Header
    │   ├── Title
    │   └── Action Button
    │
    └── Content Area
        ├── Stats Cards (Dashboard)
        ├── Data Tables
        └── Modal Forms
```

## 📊 Database Schema Relationships

```
User
│
├── hasOne → Doctor
├── hasOne → Nurse
├── hasOne → Patient
└── hasOne → Admin

Doctor
│
├── hasMany → Appointments
└── hasMany → Admissions

Patient
│
├── hasMany → Appointments
├── hasMany → Admissions
├── hasMany → Payments
└── hasMany → Emergencies

Appointment
│
├── belongsTo → Doctor
└── belongsTo → Patient

Admission
│
├── belongsTo → Doctor
└── belongsTo → Patient
```

---

**This structure provides a scalable, maintainable hospital management system with clear separation of concerns.**
