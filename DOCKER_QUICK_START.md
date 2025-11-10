# 🐳 Docker Quick Start

## ✅ Your Application is Running!

All containers are up and running successfully!

### 🌐 Access URLs

| Service | URL | Description |
|---------|-----|-------------|
| **Frontend** | http://localhost:8000 | Angular application with Nginx |
| **Backend API** | http://localhost:8081 | Spring Boot REST API |
| **API via Proxy** | http://localhost:8000/api/... | Nginx reverse proxy to backend |
| **Database** | `db:3306` (internal) | MySQL 8.4 (not exposed externally) |

## 🚀 Quick Commands

```bash
# Start all services
./start-docker.sh
# OR
docker compose up -d

# Stop all services
docker compose down

# View logs
docker compose logs -f

# View specific service logs
docker compose logs -f backend
docker compose logs -f frontend
docker compose logs -f db

# Check status
docker compose ps

# Rebuild after code changes
docker compose build
docker compose up -d

# Complete cleanup (removes volumes/database)
docker compose down -v
```

## 📋 Container Status

- ✅ **Database** (MySQL 8.4): Healthy
- ✅ **Backend** (Spring Boot): Running on port 8081
- ✅ **Frontend** (Angular + Nginx): Running on port 8000

## 🔍 Verification

Test the setup:

```bash
# Test backend directly
curl http://localhost:8081/api/events

# Test via Nginx proxy
curl http://localhost:8000/api/events

# Test Angular app
curl http://localhost:8000
```

## 🎯 Next Steps

1. **Open in browser**: http://localhost:8000
2. The Angular app will automatically connect to the backend via the Nginx proxy
3. All API calls from frontend use relative paths (`/api/...`) that Nginx forwards to the backend

## 📝 Architecture

```
Browser → http://localhost:8000 → Nginx (Frontend Container)
                                      ↓
                              /api/* requests → Backend Container (port 8080)
                                                      ↓
                                              MySQL Container (port 3306)
```

## ⚙️ Environment Variables

Backend container uses these environment variables (configured in docker-compose.yml):

- `DB_HOST=db`
- `DB_PORT=3306`
- `DB_NAME=eventdb`
- `DB_USER=root`
- `DB_PASSWORD=rootpassword`
- `SERVER_PORT=8080`

## 🐛 Troubleshooting

### Port conflicts
If you see "port already allocated":
```bash
# Check what's using the port
lsof -i :8000
lsof -i :8081

# Stop conflicting process or change ports in docker-compose.yml
```

### Database issues
If database doesn't start:
```bash
# Remove old volumes and restart
docker compose down -v
docker compose up -d
```

### Build issues
If containers fail to build:
```bash
# Clean rebuild
docker compose down
docker compose build --no-cache
docker compose up -d
```

## 📚 Full Documentation

See `DOCKER_GUIDE.md` for comprehensive documentation.
