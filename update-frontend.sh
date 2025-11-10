#!/bin/bash

echo "🔄 Updating frontend without Docker rebuild..."

# Rebuild Angular app locally
cd /Users/abdallahsofi/Downloads/EventProject/front-end
echo "📦 Building Angular app..."
npm run build

# Copy built files to running container
echo "📋 Copying files to container..."
docker cp dist/front-end/browser/. event_frontend:/usr/share/nginx/html/

# Restart nginx in container
echo "🔄 Reloading nginx..."
docker exec event_frontend nginx -s reload

echo "✅ Frontend updated!"
echo "🌐 Open: http://localhost:8000"
