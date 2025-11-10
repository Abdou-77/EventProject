#!/bin/bash

# EventProject - Setup Verification Script
# Run this after "docker compose up -d" to verify everything works

set -e

# Change to script directory
cd "$(dirname "$0")"

echo "🔍 EventProject Setup Verification"
echo "=================================="
echo ""

# Colors
GREEN='\033[0;32m'
RED='\033[0;31m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

# Check if Docker is running
echo "1️⃣  Checking Docker..."
if ! docker info >/dev/null 2>&1; then
    echo -e "${RED}✗ Docker is not running${NC}"
    echo "   Please start Docker Desktop and try again"
    exit 1
fi
echo -e "${GREEN}✓ Docker is running${NC}"
echo ""

# Check if containers are running
echo "2️⃣  Checking containers..."
CONTAINERS=$(docker ps --filter "name=event_" --format "{{.Names}}" 2>/dev/null)

if [ -z "$CONTAINERS" ]; then
    echo -e "${RED}✗ No containers running${NC}"
    echo "   Run: docker compose up -d"
    exit 1
fi

# Check each container
for container in $CONTAINERS; do
    STATUS=$(docker inspect --format='{{.State.Status}}' $container)
    HEALTH=$(docker inspect --format='{{.State.Health.Status}}' $container 2>/dev/null || echo "none")
    
    if [ "$STATUS" = "running" ]; then
        if [ "$HEALTH" = "healthy" ]; then
            echo -e "${GREEN}✓ $container: Running and healthy${NC}"
        elif [ "$HEALTH" = "none" ]; then
            echo -e "${GREEN}✓ $container: Running${NC}"
        else
            echo -e "${YELLOW}⚠ $container: Running ($HEALTH)${NC}"
        fi
    else
        echo -e "${RED}✗ $container: $STATUS${NC}"
    fi
done
echo ""

# Wait a bit for services to be ready
echo "3️⃣  Testing endpoints (waiting 5s for startup)..."
sleep 5

# Test backend API
echo -n "   Testing backend API... "
if curl -s -f http://localhost:8081/api/events >/dev/null 2>&1; then
    EVENT_COUNT=$(curl -s http://localhost:8081/api/events | grep -o '"id"' | wc -l | tr -d ' ')
    echo -e "${GREEN}✓ OK (${EVENT_COUNT} events)${NC}"
else
    echo -e "${RED}✗ Failed${NC}"
    echo "   Check logs: docker compose logs backend"
fi

# Test frontend proxy
echo -n "   Testing frontend proxy... "
if curl -s -f http://localhost:8000/api/events >/dev/null 2>&1; then
    echo -e "${GREEN}✓ OK${NC}"
else
    echo -e "${RED}✗ Failed${NC}"
    echo "   Check logs: docker compose logs frontend"
fi

# Test frontend app
echo -n "   Testing frontend app... "
if curl -s http://localhost:8000 | grep -q "FrontEnd"; then
    echo -e "${GREEN}✓ OK${NC}"
else
    echo -e "${RED}✗ Failed${NC}"
    echo "   Check logs: docker compose logs frontend"
fi
echo ""

# Summary
echo "=================================="
echo -e "${GREEN}✅ Setup verification complete!${NC}"
echo ""
echo "🌐 Access your application:"
echo "   Frontend: http://localhost:8000"
echo "   Backend:  http://localhost:8081"
echo ""
echo "📋 Useful commands:"
echo "   View logs:    docker compose logs -f"
echo "   Stop:         docker compose down"
echo "   Restart:      docker compose restart"
echo ""
