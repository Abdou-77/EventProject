# 🚀 EventApp - Complete Setup Guide

## 📋 Project Overview

**EventApp** is a full-stack event management application with:
- **Backend**: Spring Boot 3.5.7 + MySQL (Java 25)
- **Frontend**: Angular 20 + TypeScript
- **Features**: Event CRUD, Categories, Locations, Search & Filtering

---

## ✅ Current System Status

- ✅ Java 25 installed (OpenJDK)
- ✅ Node.js v22.19.0 installed
- ✅ Frontend dependencies installed
- ⚠️ **MySQL needs to be installed/configured**

---

## 📦 Prerequisites Installation

### 1. Install MySQL (Required)

MySQL is **NOT currently installed** on your system. Choose one of these options:

#### Option A: Install via Homebrew (Recommended)
```bash
# Install Homebrew if not installed
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"

# Install MySQL
brew install mysql

# Start MySQL service
brew services start mysql

# Secure installation (set root password)
mysql_secure_installation
```

#### Option B: Download MySQL Installer
1. Visit: https://dev.mysql.com/downloads/mysql/
2. Download MySQL Community Server for macOS
3. Install and follow setup wizard
4. Remember your root password!

#### Option C: Use Docker (Alternative)
```bash
# Install Docker Desktop for Mac first, then:
docker run --name mysql-eventdb -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=eventdb -p 3306:3306 -d mysql:8.0
```

---

## 🗄️ Database Setup

### Step 1: Start MySQL
```bash
# If using Homebrew:
brew services start mysql

# If using Docker:
docker start mysql-eventdb

# Check if MySQL is running:
ps aux | grep mysql
```

### Step 2: Create Database
```bash
# Connect to MySQL (password might be empty initially)
mysql -u root -p

# In MySQL console, run:
CREATE DATABASE IF NOT EXISTS eventdb;
SHOW DATABASES;
EXIT;
```

### Step 3: Update Database Credentials (if needed)
Edit `back-end/src/main/resources/application.properties`:
```properties
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD_HERE
```

---

## 🚀 Quick Start (Once MySQL is Running)

### Method 1: Using Shell Scripts (Easiest)

```bash
# Terminal 1 - Start Backend with auto-seeding
cd /Users/abdallahsofi/Downloads/EventProject/back-end
chmod +x start-with-seeder.sh
./start-with-seeder.sh
```

```bash
# Terminal 2 - Start Frontend
cd /Users/abdallahsofi/Downloads/EventProject/front-end
chmod +x start.sh
./start.sh
```

### Method 2: Manual Commands

```bash
# Terminal 1 - Backend
cd /Users/abdallahsofi/Downloads/EventProject/back-end
./mvnw clean spring-boot:run
```

```bash
# Terminal 2 - Frontend
cd /Users/abdallahsofi/Downloads/EventProject/front-end
npm start
```

---

## 🌐 Access Your Application

Once both servers are running:

- **Frontend**: http://localhost:4200
- **Backend API**: http://localhost:8080
- **Test Endpoints**:
  - http://localhost:8080/api/events
  - http://localhost:8080/api/categories
  - http://localhost:8080/api/locations

---

## 🔧 Troubleshooting

### Problem: "MySQL connection failed"

**Solution 1**: Check if MySQL is running
```bash
# For Homebrew installation:
brew services list

# For Docker:
docker ps

# Generic check:
lsof -i :3306
```

**Solution 2**: Check credentials in `application.properties`
```bash
cd back-end/src/main/resources
cat application.properties
```

**Solution 3**: Test MySQL connection
```bash
mysql -u root -p -e "SHOW DATABASES;"
```

### Problem: "Port 8080 already in use"

```bash
# Find process using port 8080
lsof -i :8080

# Kill the process
kill -9 <PID>
```

### Problem: "Port 4200 already in use"

```bash
# Find and kill process
lsof -i :4200
kill -9 <PID>

# Or start on different port
ng serve --port 4300
```

### Problem: Frontend can't connect to backend

1. Check backend is running: `curl http://localhost:8080/api/events`
2. Check browser console for CORS errors
3. Verify API URLs in frontend services

### Problem: "npm command not found"

```bash
# Verify Node.js installation
node --version
npm --version

# If missing, reinstall Node.js
```

### Problem: Maven build fails

```bash
# Clean Maven cache
cd back-end
./mvnw clean

# Rebuild
./mvnw clean install
```

---

## 📝 Development Commands

### Backend Commands
```bash
cd back-end

# Clean and build
./mvnw clean install

# Run application
./mvnw spring-boot:run

# Run tests
./mvnw test

# Build without tests
./mvnw clean install -DskipTests
```

### Frontend Commands
```bash
cd front-end

# Install dependencies
npm install

# Development server
npm start
# or
ng serve

# Build for production
ng build

# Run tests
ng test

# Generate component
ng generate component components/my-component

# Generate service
ng generate service services/my-service
```

---

## 🗂️ Project Structure

```
EventProject/
├── back-end/
│   ├── src/main/java/com/atlas/backend/
│   │   ├── BackEndApplication.java      # Main application
│   │   ├── config/                      # CORS, etc.
│   │   ├── controller/                  # REST endpoints
│   │   ├── model/                       # JPA entities
│   │   ├── repository/                  # Data access
│   │   └── service/                     # Business logic
│   ├── src/main/resources/
│   │   └── application.properties       # Configuration
│   └── pom.xml                          # Maven dependencies
│
└── front-end/
    ├── src/app/
    │   ├── components/                  # Angular components
    │   ├── services/                    # HTTP services
    │   ├── models/                      # TypeScript models
    │   └── app.routes.ts               # Routing configuration
    └── package.json                     # npm dependencies
```

---

## 🎯 Key Features

### Backend API Endpoints
- `GET /api/events` - List all events
- `GET /api/events/{id}` - Get event details
- `POST /api/events` - Create event
- `PUT /api/events/{id}` - Update event
- `DELETE /api/events/{id}` - Delete event
- `GET /api/categories` - List categories
- `GET /api/locations` - List locations
- `GET /api/events/search?title=...` - Search events

### Frontend Features
- Event listing with search
- Category filtering
- Event details view
- Create/Edit events
- Responsive design
- Real-time search

---

## 🔐 Default Configuration

### Database
- **Host**: localhost:3306
- **Database**: eventdb
- **Username**: root
- **Password**: (empty - update if different)

### Servers
- **Backend**: http://localhost:8080
- **Frontend**: http://localhost:4200

---

## 📚 Additional Documentation

- `back-end/API_DOCUMENTATION.md` - Complete API reference
- `back-end/DATABASE_SEEDING.md` - Database seeding guide
- `front-end/README_MVP.md` - Frontend MVP guide
- `front-end/TESTING_GUIDE.md` - Testing instructions

---

## 🆘 Getting Help

### Check Logs

**Backend logs**: Look in terminal where `mvnw spring-boot:run` is running
**Frontend logs**: Browser console (F12)

### Common Issues

1. **Database connection**: Ensure MySQL is running and credentials are correct
2. **CORS errors**: Backend includes CORS configuration
3. **Build failures**: Try `mvn clean install` or `npm install`
4. **Port conflicts**: Change ports in application.properties or angular.json

---

## ✅ Verification Checklist

Before starting development:

- [ ] MySQL installed and running
- [ ] Database `eventdb` created
- [ ] Java 25 installed (`java -version`)
- [ ] Node.js installed (`node --version`)
- [ ] Backend compiles (`./mvnw clean install`)
- [ ] Frontend dependencies installed (`npm install`)
- [ ] Backend starts successfully
- [ ] Frontend starts successfully
- [ ] Can access http://localhost:4200
- [ ] Can access http://localhost:8080/api/events

---

## 🎉 Next Steps

Once everything is running:

1. Access the app at http://localhost:4200
2. Explore the event list
3. Try creating a new event
4. Test search and filtering
5. Review API documentation for backend integration

---

**Last Updated**: November 9, 2025
**Status**: MySQL setup required, then ready to run!
