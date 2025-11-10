# 🐳 Docker Setup Guide - EventProject

## Prerequisites

### Install Docker Desktop for macOS

**Option 1: Homebrew (Recommended)**
```bash
brew install --cask docker
```

**Option 2: Direct Download**
Download from: https://www.docker.com/products/docker-desktop/

After installation, open Docker Desktop:
```bash
open -a Docker
```

Wait for the Docker whale icon in the menu bar to show as stable/running.

---

## Quick Start

### 1. Start Everything
```bash
cd /Users/abdallahsofi/Downloads/EventProject
./start-docker.sh
```

This will:
- ✅ Check Docker is installed and running
- ✅ Build all images (MySQL, Backend, Frontend)
- ✅ Start all containers in detached mode
- ✅ Show you the URLs to access

### 2. Access the Application
- **Frontend (Angular + Nginx)**: http://localhost
- **Backend API**: http://localhost:8080
- **API via Frontend Proxy**: http://localhost/api/...

### 3. View Logs
```bash
# All services
docker compose logs -f

# Specific service
docker compose logs -f backend
docker compose logs -f frontend
docker compose logs -f db
```

### 4. Stop Everything
```bash
docker compose down
```

### 5. Stop and Remove Data
```bash
docker compose down -v
```

---

## Manual Docker Commands

If `start-docker.sh` doesn't work, use these commands directly:

### Build Images
```bash
docker compose build
```

### Start Services
```bash
docker compose up -d
```

### Check Status
```bash
docker compose ps
```

### Restart a Service
```bash
docker compose restart backend
docker compose restart frontend
```

### Rebuild and Restart
```bash
docker compose up -d --build
```

---

## Architecture

### Services

1. **db** (MySQL 8.4)
   - Internal port: 3306
   - Database: `eventdb`
   - Root password: `example`
   - User: `eventuser` / Password: `eventpass`
   - Volume: `db_data` (persists data)

2. **backend** (Spring Boot)
   - Exposed port: 8080
   - Depends on: db (waits for healthcheck)
   - Environment variables injected for DB connection
   - Multi-stage build: Maven → Temurin JRE 25

3. **frontend** (Angular + Nginx)
   - Exposed port: 80
   - Nginx serves built Angular app
   - Reverse proxies `/api/` → `backend:8080`
   - Multi-stage build: Node 20 → Nginx Alpine

### Network
All services on shared bridge network: `eventnet`

### Volumes
- `db_data`: Persists MySQL data between container restarts

---

## Troubleshooting

### Docker Not Found
```bash
# Install Docker
brew install --cask docker

# Start Docker Desktop
open -a Docker

# Verify
docker --version
docker compose version
```

### Port Conflicts
If port 80 or 8080 is in use:

**Option 1: Stop conflicting services**
```bash
# Check what's using port 80
sudo lsof -i :80

# Check what's using port 8080
sudo lsof -i :8080
```

**Option 2: Change ports in docker-compose.yml**
```yaml
services:
  frontend:
    ports:
      - "3000:80"  # Change 80 to any available port
  
  backend:
    ports:
      - "8081:8080"  # Change 8080 to any available port
```

### Backend Can't Connect to Database
Check backend logs:
```bash
docker compose logs backend
```

Common issues:
- DB not ready yet (wait 30s and check again)
- Wrong credentials (check environment vars in docker-compose.yml)

### Frontend Shows 502 Bad Gateway
- Backend might not be started yet
- Check backend health:
```bash
docker compose ps
docker compose logs backend
```

### Rebuild from Scratch
```bash
# Stop and remove everything
docker compose down -v

# Remove images
docker compose rm -f
docker rmi eventproject-backend eventproject-frontend

# Rebuild
docker compose up -d --build
```

---

## Development Workflow

### Local Development (Without Docker)

**Backend:**
```bash
cd back-end
./mvnw spring-boot:run
```

**Frontend with API Proxy:**
```bash
cd front-end
npm run start:proxy
```

This uses `proxy.conf.json` to forward `/api` requests to `http://localhost:8080`.

### Hybrid Development
Run backend in Docker, frontend locally:

```bash
# Start only DB and backend
docker compose up -d db backend

# Run frontend locally with proxy
cd front-end
npm run start:proxy
```

### Database Access

**Connect to MySQL container:**
```bash
docker compose exec db mysql -u root -p
# Password: example

# List databases
SHOW DATABASES;

# Use eventdb
USE eventdb;

# Show tables
SHOW TABLES;
```

**Export database:**
```bash
docker compose exec db mysqldump -u root -pexample eventdb > backup.sql
```

**Import database:**
```bash
docker compose exec -T db mysql -u root -pexample eventdb < backup.sql
```

---

## File Structure

```
EventProject/
├── docker-compose.yml          # Orchestrates all services
├── start-docker.sh             # Helper script to start everything
├── back-end/
│   ├── Dockerfile              # Backend build instructions
│   ├── .dockerignore           # Exclude files from build context
│   └── src/...
├── front-end/
│   ├── Dockerfile              # Frontend build instructions
│   ├── .dockerignore           # Exclude files from build context
│   ├── nginx.conf              # Nginx configuration
│   └── src/...
```

---

## Next Steps

1. **Install Docker Desktop** if not already installed
2. **Run `./start-docker.sh`**
3. **Open http://localhost** in your browser
4. **Check logs** if anything doesn't work: `docker compose logs -f`

---

## Support

If you encounter issues:
1. Check Docker Desktop is running (whale icon in menu bar)
2. Check logs: `docker compose logs -f`
3. Try rebuilding: `docker compose up -d --build`
4. Check this guide's troubleshooting section

---

**Status:** ✅ All Docker configuration ready  
**Last Updated:** November 10, 2025
