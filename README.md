🎉 EventApp – Plateforme de Gestion d’Événements

Application full-stack moderne (Angular 20 + Spring Boot 3 + MySQL 8.4) pour créer, découvrir et gérer des événements culturels et sportifs.
Projet académique – version 1.0 (Novembre 2025)

⸻

🧭 Aperçu

Élément	Stack
Frontend	Angular 20 (TypeScript, Standalone Components, Nginx)
Backend	Spring Boot 3 (Java 21, JPA/Hibernate, Spring Security JWT)
Base de données	MySQL 8.4 (seed automatique au démarrage)
Infra / DevOps	Docker & Docker Compose
Objectif	Démonstration complète : authentification, favoris, CRUD, responsive design


⸻

✨ Fonctionnalités

👥 Utilisateurs
	•	🔎 Catalogue d’événements filtrable (catégorie, ville, date, prix)
	•	❤️ Système de favoris persistants
	•	👤 Gestion de profil utilisateur
	•	🎟️ Lien vers billetteries externes
	•	📱 Interface responsive (mobile, tablette, desktop)

🧑‍💼 Administrateurs
	•	➕ Création d’événements
	•	✏️ Modification / suppression avec confirmation
	•	📊 Vue synthétique (statistiques de vues et favoris)
	•	🖼️ Gestion des images et métadonnées

⸻

🏗️ Architecture

[Browser]
   ↓
Angular (Frontend - port 8000, Nginx)
   ↳ /api → Backend
   ↓
Spring Boot (Backend - port 8081)
   ↳ Services (Auth, Events, Favorites, Categories, Locations)
   ↓
MySQL (Database - port 3306)


⸻

📦 Structure du Projet

EventProject/
├── back-end/              # API REST (Spring Boot)
│   ├── src/main/java/com/atlas/backend/
│   │   ├── controller/    # REST Controllers
│   │   ├── service/       # Logique métier
│   │   ├── repository/    # Spring Data JPA
│   │   ├── model/         # Entités JPA
│   │   └── config/        # CORS, sécurité, seeders
│   ├── Dockerfile
│   └── pom.xml
│
├── front-end/             # Application Angular
│   ├── src/app/
│   │   ├── components/    # UI Components (auth, events, admin…)
│   │   ├── services/      # Services HTTP
│   │   ├── models/        # Interfaces TypeScript
│   │   └── app.routes.ts  # Routing
│   ├── Dockerfile
│   ├── nginx.conf
│   └── package.json
│
├── database/              # Scripts SQL (optionnel)
├── docker-compose.yml
├── COMPTES_TEST.md
└── README.md


⸻

🚀 Démarrage rapide (Docker recommandé)

Prérequis
	•	Docker Desktop ou Docker Engine + Compose
	•	Ports libres : 8000, 8081, 3306

1️⃣ Lancer les services

docker compose up -d

⏳ Attendre ~60 s : la base, le backend et le frontend démarrent automatiquement.

2️⃣ Accéder à l’application
	•	🌐 Frontend : http://localhost:8000
	•	⚙️ API REST : http://localhost:8081/api

3️⃣ Arrêter et nettoyer

docker compose down         # stoppe les conteneurs
docker compose down -v      # stoppe + supprime les volumes (reset DB)


⸻

🔐 Comptes de Test

Rôle	Email	Mot de passe
Admin	Admin@eventapp.fr	pass123
User	sofiabdou2017@gmail.com	Abdou123

> **✅ Important :** Ces comptes sont automatiquement créés au premier démarrage via le **DataSeeder**.
> 
> **🌱 Données pré-chargées au démarrage :**
> - **8 catégories** (Musique, Théâtre, Sport, Art, Festival, Gastronomie, Cinéma, Conférence)
> - **11 lieux** (Paris, Lyon, Marseille, Bordeaux, Nice)
> - **36 événements** (concerts, festivals, expositions, matchs sportifs...)
> - **7 utilisateurs** (1 admin + 6 utilisateurs standards)
> 
> ⚠️ Le seeding ne s'exécute qu'une seule fois. Pour réinitialiser : `docker compose down -v`


⸻

🔌 Endpoints Principaux (API)

Événements

GET    /api/events              → Tous les événements
GET    /api/events/{id}         → Détail d’un événement
POST   /api/events              → Créer un événement (ADMIN)
PUT    /api/events/{id}         → Modifier un événement (ADMIN)
DELETE /api/events/{id}         → Supprimer un événement (ADMIN)

Favoris

GET    /api/favorites/user/{id} → Favoris d’un utilisateur
POST   /api/favorites/toggle    → Ajouter / retirer un favori

Authentification

POST   /api/auth/signup          → Inscription
POST   /api/auth/login           → Connexion

Métadonnées

GET /api/categories              → Liste des catégories
GET /api/locations               → Liste des villes


⸻

🧱 Technologies Utilisées

Domaine	Technologies
Frontend	Angular 20, TypeScript 5.6, RxJS, Nginx
Backend	Spring Boot 3, Java 21, JPA/Hibernate, Spring Security
Database	MySQL 8.4
DevOps	Docker & Docker Compose
Tests	JUnit 5, Karma + Jasmine
Design	CSS Custom Properties (thème noir & or)


⸻

🎨 Design System
	•	🎨 Couleurs
	•	Primaire : #f0d45e (or)
	•	Secondaire : #000000 (noir)
	•	Texte : #ffffff (blanc)
	•	🔠 Typographie
	•	Titres : majuscules espacées
	•	Corps : sans-serif lisible
	•	📱 Responsive : Layout flexible (grid + media queries)

⸻

🌱 Base de Données & Seeding

### Initialisation Automatique

Au premier démarrage (`docker compose up -d`), le backend exécute automatiquement le **DataSeeder** qui peuple la base de données avec :

| Type de données | Quantité | Détails |
|----------------|----------|---------|
| **Catégories** | 8 | Musique, Théâtre, Sport, Art & Exposition, Festival, Gastronomie, Cinéma, Conférence |
| **Localisations** | 11 | Stade de France, Accor Arena, Philharmonie, Musée du Louvre, Parc des Princes, etc. |
| **Événements** | 36 | Concerts, festivals, matchs, expositions, conférences avec dates réelles |
| **Utilisateurs** | 7 | 1 admin (`Admin@eventapp.fr`) + 6 utilisateurs standards |

### Comment ça fonctionne ?

```java
// Le DataSeeder vérifie si des données existent déjà
if (categoryRepository.count() > 0) {
    System.out.println("✅ Database already populated. Skipping seed.");
    return;
}
// Sinon, il crée toutes les données...
```

### Réinitialiser la base

```bash
# Supprimer les conteneurs ET les volumes (reset complet)
docker compose down -v

# Redémarrer (le seeding s'exécutera à nouveau)
docker compose up -d
```

> **💡 Astuce :** Le seeding ne s'exécute qu'une seule fois. Si vous voyez "✅ Database already populated" dans les logs, c'est normal !

⸻

🧪 Tests et Qualité

# Backend
cd back-end
./mvnw test

# Frontend
cd front-end
npm run test
npm run lint


⸻

🐛 Dépannage rapide

Problème	Solution
Frontend blanc	Hard refresh (Ctrl+Shift+R), puis docker compose logs frontend
Backend 502/503	Attendre 40 s ou docker compose logs backend
Port déjà utilisé	`lsof -ti:8000,8081,3306
Erreur CORS (en local)	Configurer proxy Angular (proxy.conf.json) ou activer CORS côté backend


⸻

📈 Roadmap (Évolutions futures)
	•	Authentification JWT avec refresh token
	•	Upload d’images (Cloudinary / S3)
	•	Tableau de bord analytics
	•	Tests E2E (Playwright ou Cypress)
	•	CI/CD complet (Render + Netlify)
	•	Carte interactive (Leaflet / Google Maps)

⸻

🎓 Contexte Académique

Projet développé dans le cadre du cours de développement full-stack (EPF – Ingénierie Numérique 2025).
Objectifs :
	•	Maîtrise de l’architecture client-serveur moderne
	•	Conception et conteneurisation d’une application web complète
	•	Mise en œuvre d’un workflow DevOps reproductible

⸻

📄 Licence

Projet à usage éducatif et non commercial.
Libre de réutilisation et d’adaptation à des fins pédagogiques.

⸻

✅ Statut du Projet

Composant	État
Backend	✅ Complet (CRUD, Auth, Favoris, Seeding auto)
Frontend	✅ Fonctionnel et responsive
Intégration	✅ API connectée via Nginx
Documentation	✅ Complète
Docker	✅ Production Ready


⸻

📋 Référence Rapide

### Commandes Essentielles

```bash
# Démarrer l'application
docker compose up -d

# Voir les logs en temps réel
docker compose logs -f backend
docker compose logs -f frontend

# Arrêter l'application
docker compose down

# Reset complet (base de données incluse)
docker compose down -v

# Vérifier l'état des conteneurs
docker compose ps

# Accéder à MySQL
docker compose exec db mysql -u eventuser -peventpass eventdb
```

### URLs Importantes

| Service | URL |
|---------|-----|
| Frontend | http://localhost:8000 |
| Backend API | http://localhost:8081/api |
| Swagger UI | http://localhost:8081/swagger-ui.html (si configuré) |

### Identifiants Rapides

```
Admin    : Admin@eventapp.fr / pass123
User     : sofiabdou2017@gmail.com / Abdou123
Database : eventuser / eventpass
```

⸻