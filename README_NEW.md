# 🎉 EventApp - Gestion d'Événements

Application full-stack moderne pour gérer et découvrir des événements.

---

## 🐳 Docker Setup - Fonctionne sur N'IMPORTE QUEL Ordinateur!

**Ce projet est entièrement conteneurisé et portable!**

### ⚡ Démarrage Rapide (3 Étapes)

```bash
# 1. Installer Docker Desktop (une seule fois)
# Télécharger: https://www.docker.com/products/docker-desktop

# 2. Naviguer vers le projet
cd EventProject

# 3. Tout démarrer
docker compose up -d
```

**C'est tout!** Ouvrir: **http://localhost:8000**

### ✅ Ce que Vous Obtenez

- ✅ **MySQL 8.4** - Base de données (auto-configurée)
- ✅ **Spring Boot** - Backend API sur le port 8081
- ✅ **Angular** - Frontend sur le port 8000
- ✅ **Aucune installation locale nécessaire** (pas de Java, Node, Maven, ou MySQL)

### 🎯 Commandes Essentielles

```bash
# Démarrer l'application
docker compose up -d

# Arrêter l'application
docker compose down

# Voir les logs
docker compose logs -f

# Vérifier le statut
docker compose ps

# Vérifier que tout fonctionne
./verify-setup.sh

# Redémarrer après changement de code
docker compose up -d --build
```

### 📖 Documentation Détaillée

| Document | Description |
|----------|-------------|
| **[NEW_LAPTOP_SETUP.md](NEW_LAPTOP_SETUP.md)** | 🎯 Guide rapide pour nouvel ordinateur |
| **[PORTABLE_SETUP.md](PORTABLE_SETUP.md)** | 📚 Guide complet de portabilité |
| **[DOCKER_QUICK_START.md](DOCKER_QUICK_START.md)** | 🚀 Référence des commandes |
| **[DOCKER_GUIDE.md](DOCKER_GUIDE.md)** | 📘 Documentation complète |

---

## 🌐 Points d'Accès

Une fois démarré:

| Service | URL | Description |
|---------|-----|-------------|
| **Application** | http://localhost:8000 | Interface Angular |
| **API Backend** | http://localhost:8081 | API REST Spring Boot |
| **API (via proxy)** | http://localhost:8000/api | API via Nginx |
| **Base de données** | `db:3306` | MySQL (interne) |

---

## 💻 Compatibilité Multi-Plateforme

✅ **macOS** (Intel & Apple Silicon)  
✅ **Windows** 10/11 avec WSL2  
✅ **Linux** (Ubuntu, Fedora, Debian)  

**Une seule exigence: Docker Desktop installé!**

---

## 📦 Architecture

```
EventProject/
├── docker-compose.yml          ← Orchestration de tous les services
├── .env.example                ← Variables d'environnement
├── verify-setup.sh             ← Script de vérification
│
├── back-end/
│   ├── Dockerfile              ← Build backend
│   ├── src/                    ← Code source Java
│   └── pom.xml                 ← Dépendances Maven
│
├── front-end/
│   ├── Dockerfile              ← Build frontend
│   ├── nginx.conf              ← Configuration Nginx
│   ├── src/                    ← Code source Angular
│   └── package.json            ← Dépendances NPM
│
└── database/
    └── (Scripts SQL optionnels)
```

---

## 🔧 Configuration

### Ports Utilisés

- **8000** → Frontend (Nginx + Angular)
- **8081** → Backend (Spring Boot)
- **3306** → MySQL (interne uniquement)

**En conflit?** Changez les ports dans `docker-compose.yml`:

```yaml
ports:
  - "8001:80"   # Frontend sur 8001
  - "8082:8080" # Backend sur 8082
```

### Variables d'Environnement

Toute la configuration est dans `docker-compose.yml`:

```yaml
environment:
  DB_HOST: db
  DB_PORT: 3306
  DB_NAME: eventdb
  DB_USER: root
  DB_PASSWORD: rootpassword
```

**Pour la production:** Copier `.env.example` vers `.env` et modifier les valeurs.

---

## 🚀 Déploiement sur Nouveau Laptop

### Méthode 1: Git Clone

```bash
# Cloner le repository
git clone <votre-repo-url>
cd EventProject

# Démarrer
docker compose up -d
```

### Méthode 2: Copie Directe

```bash
# Copier le dossier EventProject entier
# Via USB, réseau, ou autre

# Naviguer et démarrer
cd EventProject
docker compose up -d
```

**Temps de premier démarrage:** 2-5 minutes (téléchargement des dépendances)  
**Démarrages suivants:** 30-60 secondes

---

## 🐛 Dépannage Rapide

### Port déjà utilisé
```bash
# Trouver ce qui utilise le port
lsof -i :8000

# Ou changer le port dans docker-compose.yml
```

### Base de données ne démarre pas
```bash
# Supprimer les volumes et redémarrer
docker compose down -v
docker compose up -d
```

### Docker commande introuvable (macOS)
```bash
# S'assurer que Docker Desktop est lancé
open -a Docker

# Ajouter au PATH
export PATH="/usr/local/bin:$PATH"
```

### Build échoue
```bash
# Nettoyage complet
docker compose down -v
docker system prune -a
docker compose up -d --build
```

---

## 📊 Ressources Requises

### Configuration Minimale
- **RAM**: 4 GB (8 GB recommandé)
- **Disque**: 5 GB d'espace libre
- **CPU**: 2 cœurs (4 cœurs recommandé)

### Utilisation Typique
- **MySQL**: ~200 MB RAM
- **Backend**: ~512 MB RAM  
- **Frontend**: ~10 MB RAM
- **Total**: ~750 MB RAM + ~1 GB disque

---

## ✅ Vérification de l'Installation

Après `docker compose up -d`:

```bash
# 1. Vérifier les conteneurs
docker compose ps
# Tous doivent être "Up" ou "healthy"

# 2. Tester l'API backend
curl http://localhost:8081/api/events

# 3. Tester le proxy frontend
curl http://localhost:8000/api/events

# 4. Tester l'application
curl http://localhost:8000

# 5. Script automatique
./verify-setup.sh
```

---

## 📚 Ressources Supplémentaires

### Documentation Technique
- [API_DOCUMENTATION.md](back-end/API_DOCUMENTATION.md) - Documentation de l'API
- [FUNCTIONAL_REQUIREMENTS_API.md](back-end/FUNCTIONAL_REQUIREMENTS_API.md) - Exigences fonctionnelles

### Guides de Développement
- [IMPLEMENTATION_COMPLETE.md](back-end/IMPLEMENTATION_COMPLETE.md) - Backend complet
- [MVP_COMPLETE.md](front-end/MVP_COMPLETE.md) - Frontend MVP

---

## 🤝 Contribution

1. Fork le projet
2. Créer une branche (`git checkout -b feature/AmazingFeature`)
3. Commit les changements (`git commit -m 'Add AmazingFeature'`)
4. Push vers la branche (`git push origin feature/AmazingFeature`)
5. Ouvrir une Pull Request

---

## 📝 Notes de Version

### v2.0 - Docker Containerization
- ✅ Docker Compose pour orchestration complète
- ✅ Multi-stage builds pour optimisation
- ✅ Configuration basée sur variables d'environnement
- ✅ Portabilité complète multi-plateforme
- ✅ Scripts de vérification et démarrage

### v1.0 - Initial Release
- ✅ Backend Spring Boot
- ✅ Frontend Angular
- ✅ Base de données MySQL

---

## 📄 Licence

Ce projet est sous licence [Choisir une licence].

---

## 🎉 C'est Parti!

**Pour commencer sur un nouvel ordinateur:**

1. Installer Docker Desktop
2. Cloner/Copier le projet
3. Exécuter `docker compose up -d`
4. Ouvrir http://localhost:8000

**Besoin d'aide?** Consulter [NEW_LAPTOP_SETUP.md](NEW_LAPTOP_SETUP.md)

---

**Dernière mise à jour:** 10 Novembre 2025  
**Version Docker:** 27.x+  
**Version Compose:** 2.x+
