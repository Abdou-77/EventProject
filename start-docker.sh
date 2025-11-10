#!/usr/bin/env bash
set -euo pipefail

# Normalize CWD to repo root if called from subdir
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd "$SCRIPT_DIR"

# Add /usr/local/bin to PATH for Docker Desktop
export PATH="/usr/local/bin:$PATH"

# Check Docker CLI
if ! command -v docker >/dev/null 2>&1; then
  echo "[ERROR] Docker is not installed or not on PATH."
  echo "Install Docker Desktop for macOS: https://www.docker.com/products/docker-desktop/"
  echo "Or via Homebrew:"
  echo "  brew install --cask docker"
  echo "  open -a Docker"
  exit 127
fi

# Ensure Docker engine is running (Docker Desktop)
if ! docker info >/dev/null 2>&1; then
  echo "[INFO] Starting Docker Desktop..."
  open -a Docker || true
  echo "Waiting for Docker to be ready..."
  # Wait up to ~90s
  for i in {1..90}; do
    if docker info >/dev/null 2>&1; then
      break
    fi
    sleep 1
    if [[ "$i" == "90" ]]; then
      echo "[ERROR] Docker engine not ready. Please open Docker Desktop and retry."
      exit 1
    fi
  done
fi

# Choose docker compose command variant
if docker compose version >/dev/null 2>&1; then
  DCMD=(docker compose)
elif command -v docker-compose >/dev/null 2>&1; then
  DCMD=(docker-compose)
else
  echo "[ERROR] Neither 'docker compose' nor 'docker-compose' is available."
  exit 127
fi

echo "[INFO] Building and starting containers..."
"${DCMD[@]}" up -d --build

echo "[INFO] Services started:"
echo "- Frontend: http://localhost (Nginx serving Angular app)"
echo "- Backend API: http://localhost:8080"
echo "- API (via frontend proxy): http://localhost/api/..."
