#!/bin/bash

# Script de démarrage rapide pour EventApp Frontend

echo "🚀 Démarrage de EventApp Frontend..."
echo ""

# Vérifier si node_modules existe
if [ ! -d "node_modules" ]; then
    echo "📦 Installation des dépendances..."
    npm install
    echo ""
fi

# Vérifier si le backend est accessible
echo "🔍 Vérification de la disponibilité du backend..."
if curl -s http://localhost:8080/api/events > /dev/null 2>&1; then
    echo "✅ Backend accessible sur http://localhost:8080"
else
    echo "⚠️  Backend non accessible sur http://localhost:8080"
    echo "   Assurez-vous que le backend est démarré avant de continuer."
    echo ""
    read -p "Continuer quand même ? (o/n) " -n 1 -r
    echo ""
    if [[ ! $REPLY =~ ^[Oo]$ ]]; then
        exit 1
    fi
fi

echo ""
echo "🌐 Démarrage du serveur de développement..."
echo "   L'application sera accessible sur: http://localhost:4200"
echo ""
echo "   Appuyez sur Ctrl+C pour arrêter le serveur"
echo ""

ng serve --port 4200 --open

