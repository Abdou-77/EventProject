# 🎯 New Laptop Setup - Quick Start

Follow these steps to run the EventProject on **any laptop**:

## 🚀 3-Step Setup

### Step 1: Install Docker Desktop

**Download and install Docker Desktop for your operating system:**

- **macOS**: https://docs.docker.com/desktop/install/mac-install/
- **Windows**: https://docs.docker.com/desktop/install/windows-install/
- **Linux**: https://docs.docker.com/desktop/install/linux-install/

**Verify installation:**
```bash
docker --version
docker compose version
```

### Step 2: Get the Project

**Option A: Clone from Git**
```bash
git clone <your-repository-url>
cd EventProject
```

**Option B: Copy the Folder**
- Copy the entire `EventProject` folder to the new laptop
- Open Terminal (macOS/Linux) or PowerShell (Windows)
- Navigate to the project:
```bash
cd /path/to/EventProject
```

### Step 3: Start the Application

```bash
# Start all services (first time takes 2-5 minutes)
docker compose up -d

# Wait for services to be ready
docker compose ps
```

**That's it!** Open your browser to: **http://localhost:8000**

## ✅ Verification

Check everything is working:

```bash
# Check container status
docker compose ps
# All should show "Up" or "healthy"

# Test backend API
curl http://localhost:8081/api/events

# Open application
open http://localhost:8000  # macOS
# or
start http://localhost:8000  # Windows
```

## 📋 What You DON'T Need to Install

✅ **No Java installation needed** - Runs in Docker  
✅ **No Node.js needed** - Runs in Docker  
✅ **No Maven needed** - Runs in Docker  
✅ **No NPM needed** - Runs in Docker  
✅ **No MySQL needed** - Runs in Docker  

**Only Docker Desktop is required!**

## 🛠️ Common Commands

```bash
# Start
docker compose up -d

# Stop
docker compose down

# View logs
docker compose logs -f

# Restart everything
docker compose restart

# Full cleanup (removes database data!)
docker compose down -v
```

## 🐛 Troubleshooting

### Problem: Port already in use
```bash
# Find what's using the port
lsof -i :8000  # macOS/Linux
netstat -ano | findstr :8000  # Windows

# Kill the process or change ports in docker-compose.yml
```

### Problem: Docker command not found
```bash
# Make sure Docker Desktop is running
# macOS: Check menu bar for Docker icon
# Windows: Check system tray for Docker icon

# Add Docker to PATH (macOS/Linux)
export PATH="/usr/local/bin:$PATH"
```

### Problem: Build fails
```bash
# Clean everything and try again
docker compose down -v
docker system prune -a
docker compose up -d --build
```

### Problem: Database won't start
```bash
# Remove old database volume
docker compose down -v
docker compose up -d

# Check logs
docker compose logs db
```

## 🌐 Access Points

Once running:

| Service | URL | Description |
|---------|-----|-------------|
| **Application** | http://localhost:8000 | Main Angular app |
| **API** | http://localhost:8081 | Backend REST API |
| **API (via proxy)** | http://localhost:8000/api | API through Nginx |

## 📊 Resource Usage

**First Build:**
- Time: 2-5 minutes
- Download: ~2 GB (Maven + NPM dependencies)
- Disk: ~2 GB

**After Initial Build:**
- RAM: ~750 MB
- Disk: ~1.5 GB
- Startup: 30-60 seconds

## 📖 Detailed Documentation

For more information, see:
- `PORTABLE_SETUP.md` - Complete setup guide
- `DOCKER_QUICK_START.md` - Command reference
- `DOCKER_GUIDE.md` - Comprehensive documentation

## 🎉 You're Done!

The application should now be running at http://localhost:8000

Need help? Check the documentation files above.
