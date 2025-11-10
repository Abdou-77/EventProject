# 🚀 Portable Docker Setup Guide

This guide ensures your EventProject works identically on **ANY laptop** with Docker installed.

## 📋 Prerequisites

The only requirement is **Docker Desktop** installed on the target machine:

### macOS
```bash
# Download from: https://www.docker.com/products/docker-desktop
# Or install via Homebrew:
brew install --cask docker
```

### Windows
```bash
# Download from: https://www.docker.com/products/docker-desktop
# Requires WSL2 enabled
```

### Linux
```bash
# Ubuntu/Debian
sudo apt-get update
sudo apt-get install docker.io docker-compose-plugin

# Fedora/RHEL
sudo dnf install docker docker-compose-plugin

# Start Docker service
sudo systemctl start docker
sudo systemctl enable docker
```

## 📦 What's Included (Everything You Need)

Your project is **100% self-contained**:

```
EventProject/
├── docker-compose.yml          ← Orchestrates all services
├── back-end/
│   ├── Dockerfile              ← Backend build instructions
│   ├── pom.xml                 ← Maven dependencies
│   └── src/                    ← Java source code
├── front-end/
│   ├── Dockerfile              ← Frontend build instructions
│   ├── package.json            ← NPM dependencies
│   └── src/                    ← Angular source code
└── database/                   ← (Optional SQL scripts)
```

**No external dependencies needed!** Everything builds from scratch.

## 🎯 Step-by-Step Setup on Any Laptop

### 1. Clone/Copy the Project

```bash
# Option A: Clone from Git (if you have a repository)
git clone <your-repo-url>
cd EventProject

# Option B: Copy the entire EventProject folder
# Just copy/paste or use USB drive
```

### 2. Start the Application

```bash
# Navigate to project directory
cd EventProject

# Start everything (first time will take 2-5 minutes to build)
docker compose up -d

# Watch the logs (optional)
docker compose logs -f
```

That's it! The application will:
1. ✅ Download MySQL 8.4 image
2. ✅ Build backend (Maven downloads all Java dependencies)
3. ✅ Build frontend (NPM downloads all Node dependencies)
4. ✅ Create database with schema
5. ✅ Start all services

### 3. Access the Application

Open your browser to: **http://localhost:8000**

- Frontend: http://localhost:8000
- Backend API: http://localhost:8081
- Database: Running internally (not exposed)

## ⚙️ Configuration (Already Done!)

All configuration is **environment-based** and works automatically:

### Database Credentials
```yaml
# In docker-compose.yml - Already configured!
DB_HOST: db
DB_PORT: 3306
DB_NAME: eventdb
DB_USER: root
DB_PASSWORD: rootpassword
```

### Port Mappings
```yaml
Backend:  8081 → 8080 (internal)
Frontend: 8000 → 80 (internal)
Database: 3306 (internal only)
```

### Network
All services communicate via Docker network `eventnet` (automatically created).

## 🔄 Common Commands

```bash
# Start application
docker compose up -d

# Stop application
docker compose down

# View logs
docker compose logs -f

# Check status
docker compose ps

# Restart specific service
docker compose restart backend

# Rebuild after code changes
docker compose up -d --build

# Complete cleanup (removes database data)
docker compose down -v

# View resource usage
docker stats
```

## 🌍 Cross-Platform Compatibility

### ✅ Verified On
- macOS (Intel & Apple Silicon)
- Windows 10/11 with WSL2
- Linux (Ubuntu, Fedora, Debian)

### 🔧 Platform-Specific Notes

#### macOS
- Docker Desktop includes Docker Compose
- Start Docker Desktop before running commands
- `/usr/local/bin/docker` should be in PATH

#### Windows
- Use PowerShell or WSL2 terminal
- File paths use forward slashes in Docker
- Line endings: Git should use LF not CRLF

#### Linux
- May need `sudo` for docker commands
- Or add user to docker group: `sudo usermod -aG docker $USER`

## 📁 What Gets Built

### Backend Image (`eventproject-backend`)
- Base: Eclipse Temurin 21 JRE Alpine
- Size: ~250 MB
- Contains: Spring Boot JAR + Java runtime
- Build time: 60-90 seconds (first time)

### Frontend Image (`eventproject-frontend`)
- Base: Nginx 1.27 Alpine
- Size: ~50 MB
- Contains: Built Angular app + Nginx
- Build time: 90-120 seconds (first time)

### Database Image (`mysql:8.4`)
- Downloaded: From Docker Hub
- Size: ~500 MB
- Data: Persisted in Docker volume `db_data`

**Total**: ~800 MB (downloaded/built once, then cached)

## 🔐 Security Notes

### Default Passwords (⚠️ Change for Production!)

The current setup uses default passwords for development:

```yaml
MYSQL_ROOT_PASSWORD: rootpassword
MYSQL_DATABASE: eventdb
```

**For production**, create a `.env` file:

```bash
# .env (create this file)
MYSQL_ROOT_PASSWORD=your_secure_password_here
DB_PASSWORD=your_secure_password_here
```

Update `docker-compose.yml`:
```yaml
environment:
  MYSQL_ROOT_PASSWORD: ${MYSQL_ROOT_PASSWORD}
  DB_PASSWORD: ${DB_PASSWORD}
```

## 🐛 Troubleshooting

### Issue: "Port already allocated"
```bash
# Check what's using the port
lsof -i :8000
lsof -i :8081

# Option 1: Stop the conflicting process
kill <PID>

# Option 2: Change ports in docker-compose.yml
ports:
  - "8001:80"  # Changed from 8000
```

### Issue: "Cannot connect to database"
```bash
# Remove old volumes and restart fresh
docker compose down -v
docker compose up -d

# Wait for healthy status
docker compose ps
```

### Issue: "Build failed - no space left"
```bash
# Clean up old Docker images/containers
docker system prune -a

# Check available space
docker system df
```

### Issue: Docker command not found (macOS)
```bash
# Ensure Docker Desktop is running
open -a Docker

# Add to PATH temporarily
export PATH="/usr/local/bin:$PATH"

# Or permanently (add to ~/.zshrc or ~/.bashrc)
echo 'export PATH="/usr/local/bin:$PATH"' >> ~/.zshrc
```

### Issue: "Build takes too long"
First build downloads all dependencies (Maven, NPM):
- Backend: ~1-2 GB of Maven dependencies
- Frontend: ~500 MB of Node modules
- Subsequent builds use cache (much faster)

### Issue: "Database not initializing"
```bash
# Check database logs
docker compose logs db

# Common fix: Remove corrupted volume
docker compose down -v
docker compose up -d
```

## 🚀 Performance Tips

### Speed Up Builds
```bash
# Use BuildKit (faster builds)
export DOCKER_BUILDKIT=1
docker compose build
```

### Reduce Image Sizes
Already optimized with:
- ✅ Multi-stage builds
- ✅ Alpine Linux base images
- ✅ .dockerignore files

### Persistent Development
```bash
# Mount code as volumes for live reload (development only)
# Add to docker-compose.yml:
volumes:
  - ./back-end/src:/app/src  # Backend hot reload
  - ./front-end/src:/app/src # Frontend hot reload
```

## 📊 Resource Requirements

### Minimum System Requirements
- **RAM**: 4 GB (8 GB recommended)
- **Disk**: 5 GB free space
- **CPU**: 2 cores (4 cores recommended)

### Expected Resource Usage
- **MySQL**: ~200 MB RAM
- **Backend**: ~512 MB RAM
- **Frontend**: ~10 MB RAM
- **Total**: ~750 MB RAM + ~1 GB disk

## ✅ Verification Checklist

After setup on a new laptop:

```bash
# 1. Check all containers are running
docker compose ps
# Should show: db (healthy), backend (up), frontend (up)

# 2. Test backend API
curl http://localhost:8081/api/events
# Should return JSON array of events

# 3. Test frontend proxy
curl http://localhost:8000/api/events
# Should return same JSON array

# 4. Test frontend app
curl http://localhost:8000
# Should return HTML with "FrontEnd" title

# 5. Open in browser
# Navigate to http://localhost:8000
# Should see the application interface
```

## 📝 Git Repository Setup (Optional)

To make it even easier to deploy on new laptops:

### Create `.gitignore`
```bash
# Already included, but verify:
**/target/
**/node_modules/
**/dist/
**/.idea/
**/.vscode/
```

### Push to Repository
```bash
git init
git add .
git commit -m "Initial Docker setup"
git remote add origin <your-repo-url>
git push -u origin main
```

### Clone on New Laptop
```bash
git clone <your-repo-url>
cd EventProject
docker compose up -d
```

## 🎯 Quick Start Summary

For someone setting up on a **brand new laptop**:

1. **Install Docker Desktop** (one-time)
2. **Copy/Clone the project folder**
3. **Run**: `docker compose up -d`
4. **Wait**: 2-5 minutes for first build
5. **Open**: http://localhost:8000

**That's it!** No Java, Node, Maven, NPM, or MySQL installation needed.

## 🔄 Updating the Application

After making code changes:

```bash
# Backend changes
docker compose build backend
docker compose up -d backend

# Frontend changes
docker compose build frontend
docker compose up -d frontend

# Database schema changes
docker compose down -v  # Warning: deletes data!
docker compose up -d
```

## 📚 Additional Resources

- Docker Documentation: https://docs.docker.com
- Docker Compose Reference: https://docs.docker.com/compose/
- Spring Boot Docker: https://spring.io/guides/gs/spring-boot-docker/
- Angular Docker: https://angular.io/guide/deployment#docker

## 🎉 Success Indicators

Your setup is working correctly when:

✅ `docker compose ps` shows all containers as "Up"  
✅ `docker compose logs db` shows "ready for connections"  
✅ `docker compose logs backend` shows "Started BackendApplication"  
✅ `curl http://localhost:8000` returns HTML  
✅ Browser at http://localhost:8000 shows your application  

---

**Last Updated**: November 10, 2025  
**Docker Version**: 27.x+  
**Compose Version**: 2.x+
