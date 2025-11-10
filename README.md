# 🎉 EventApp – Plateforme de Gestion d'Événements# 🎉 EventApp – Plateforme de Gestion d'Événements



> Application full-stack moderne pour créer, découvrir et gérer des événements culturels et sportifs.> Application full-stack moderne pour créer, découvrir et gérer des événements culturels et sportifs.

> > 

> **Stack**: Angular 20 · Spring Boot 3 · MySQL 8.4 · Docker> **Stack**: Angular 20 · Spring Boot 3 · MySQL 8.4 · Docker

> > 

> **Projet académique** – Version 1.0 (Novembre 2025)> **Projet académique** – Version 1.0 (Novembre 2025)



------



## 🧭 Aperçu Technique## 🧭 Aperçu Technique



| Élément | Stack || Élément | Stack |

|---------|-------||---------|-------|

| **Frontend** | Angular 20 (TypeScript, Standalone Components, Nginx) || **Frontend** | Angular 20 (TypeScript, Standalone Components, Nginx) |

| **Backend** | Spring Boot 3 (Java 21, JPA/Hibernate, Spring Security) || **Backend** | Spring Boot 3 (Java 21, JPA/Hibernate, Spring Security) |

| **Base de données** | MySQL 8.4 (seed automatique au démarrage) || **Base de données** | MySQL 8.4 (seed automatique au démarrage) |

| **Infra / DevOps** | Docker & Docker Compose || **Infra / DevOps** | Docker & Docker Compose |

| **Objectif** | Démonstration complète : authentification, favoris, CRUD, responsive design || **Objectif** | Démonstration complète : authentification, favoris, CRUD, responsive design |



------



## ✨ Fonctionnalités✨ Fonctionnalités



### 👥 Utilisateurs👥 Utilisateurs

- 🔎 **Catalogue d'événements** filtrable (catégorie, ville, date, prix)	•	🔎 Catalogue d’événements filtrable (catégorie, ville, date, prix)

- ❤️ **Système de favoris** persistants	•	❤️ Système de favoris persistants

- 👤 **Gestion de profil** utilisateur personnalisé	•	👤 Gestion de profil utilisateur

- 🎟️ **Lien billetterie** externe	•	🎟️ Lien vers billetteries externes

- 📱 **Interface responsive** (mobile, tablette, desktop)	•	📱 Interface responsive (mobile, tablette, desktop)



### 🧑‍💼 Administrateurs🧑‍💼 Administrateurs

- ➕ **Création d'événements** avec formulaire complet	•	➕ Création d’événements

- ✏️ **Modification / suppression** avec confirmation de sécurité	•	✏️ Modification / suppression avec confirmation

- 📊 **Vue synthétique** (statistiques de vues et favoris)	•	📊 Vue synthétique (statistiques de vues et favoris)

- 🖼️ **Gestion des images** et métadonnées	•	🖼️ Gestion des images et métadonnées



---⸻



## 🏗️ Architecture🏗️ Architecture



```[Browser]

[Browser]   ↓

   ↓Angular (Frontend - port 8000, Nginx)

Angular (Frontend - port 8000, Nginx)   ↳ /api → Backend

   ↳ /api → Backend   ↓

   ↓Spring Boot (Backend - port 8081)

Spring Boot (Backend - port 8081)   ↳ Services (Auth, Events, Favorites, Categories, Locations)

   ↳ Services (Auth, Events, Favorites, Categories, Locations)   ↓

   ↓MySQL (Database - port 3306)

MySQL (Database - port 3306)

```

⸻

---

📦 Structure du Projet

## 🚀 Démarrage Rapide

EventProject/

### Prérequis├── back-end/              # API REST (Spring Boot)

- ✅ Docker Desktop ou Docker Engine + Compose│   ├── src/main/java/com/atlas/backend/

- ✅ Ports libres : 8000 (frontend), 8081 (backend), 3306 (MySQL)│   │   ├── controller/    # REST Controllers

│   │   ├── service/       # Logique métier

### 1️⃣ Lancer l'application│   │   ├── repository/    # Spring Data JPA

│   │   ├── model/         # Entités JPA

```bash│   │   └── config/        # CORS, sécurité, seeders

docker compose up -d│   ├── Dockerfile

```│   └── pom.xml

│

⏳ **Attendre ~60 secondes** : la base de données, le backend et le frontend démarrent automatiquement.├── front-end/             # Application Angular

│   ├── src/app/

### 2️⃣ Accéder à l'application│   │   ├── components/    # UI Components (auth, events, admin…)

- 🌐 **Frontend** : http://localhost:8000│   │   ├── services/      # Services HTTP

- ⚙️ **API REST** : http://localhost:8081/api│   │   ├── models/        # Interfaces TypeScript

│   │   └── app.routes.ts  # Routing

### 3️⃣ Arrêter l'application│   ├── Dockerfile

│   ├── nginx.conf

```bash│   └── package.json

docker compose down         # Stoppe les conteneurs│

docker compose down -v      # Stoppe + supprime les volumes (reset DB)├── database/              # Scripts SQL (optionnel)

```├── docker-compose.yml

├── COMPTES_TEST.md

---└── README.md



## 🔐 Comptes de Test

⸻

| Rôle | Email | Mot de passe |

|------|-------|--------------|🚀 Démarrage rapide (Docker recommandé)

| **Admin** | `Admin@eventapp.fr` | `pass123` |

| **User** | `sofiabdou2017@gmail.com` | `Abdou123` |Prérequis

	•	Docker Desktop ou Docker Engine + Compose

> **✅ Important** : Ces comptes sont automatiquement créés au premier démarrage via le **DataSeeder**.	•	Ports libres : 8000, 8081, 3306



### 🌱 Données pré-chargées au démarrage1️⃣ Lancer les services



| Type | Quantité | Détails |docker compose up -d

|------|----------|---------|

| **Catégories** | 8 | Musique, Théâtre, Sport, Art, Festival, Gastronomie, Cinéma, Conférence |⏳ Attendre ~60 s : la base, le backend et le frontend démarrent automatiquement.

| **Localisations** | 11 | Paris, Lyon, Marseille, Bordeaux, Nice |

| **Événements** | 36 | Concerts, festivals, expositions, matchs sportifs avec dates réelles |2️⃣ Accéder à l’application

| **Utilisateurs** | 7 | 1 admin + 6 utilisateurs standards |	•	🌐 Frontend : http://localhost:8000

	•	⚙️ API REST : http://localhost:8081/api

⚠️ **Le seeding ne s'exécute qu'une seule fois**. Pour réinitialiser : `docker compose down -v`

3️⃣ Arrêter et nettoyer

---

docker compose down         # stoppe les conteneurs

## 📦 Structure du Projetdocker compose down -v      # stoppe + supprime les volumes (reset DB)



```

EventProject/⸻

├── back-end/              # API REST (Spring Boot)

│   ├── src/main/java/com/atlas/backend/🔐 Comptes de Test

│   │   ├── controller/    # REST Controllers

│   │   ├── service/       # Logique métierRôle	Email	Mot de passe

│   │   ├── repository/    # Spring Data JPAAdmin	Admin@eventapp.fr	pass123

│   │   ├── model/         # Entités JPAUser	sofiabdou2017@gmail.com	Abdou123

│   │   └── config/        # CORS, sécurité, seeders

│   ├── Dockerfile> **✅ Important :** Ces comptes sont automatiquement créés au premier démarrage via le **DataSeeder**.

│   └── pom.xml> 

│> **🌱 Données pré-chargées au démarrage :**

├── front-end/             # Application Angular> - **8 catégories** (Musique, Théâtre, Sport, Art, Festival, Gastronomie, Cinéma, Conférence)

│   ├── src/app/> - **11 lieux** (Paris, Lyon, Marseille, Bordeaux, Nice)

│   │   ├── components/    # UI Components (auth, events, admin…)> - **36 événements** (concerts, festivals, expositions, matchs sportifs...)

│   │   ├── services/      # Services HTTP> - **7 utilisateurs** (1 admin + 6 utilisateurs standards)

│   │   ├── models/        # Interfaces TypeScript> 

│   │   └── app.routes.ts  # Routing> ⚠️ Le seeding ne s'exécute qu'une seule fois. Pour réinitialiser : `docker compose down -v`

│   ├── Dockerfile

│   ├── nginx.conf

│   └── package.json⸻

│

├── database/              # Scripts SQL (optionnel)🔌 Endpoints Principaux (API)

├── docker-compose.yml

└── README.mdÉvénements

```

GET    /api/events              → Tous les événements

---GET    /api/events/{id}         → Détail d’un événement

POST   /api/events              → Créer un événement (ADMIN)

## 🔌 Endpoints API (principaux)PUT    /api/events/{id}         → Modifier un événement (ADMIN)

DELETE /api/events/{id}         → Supprimer un événement (ADMIN)

### Événements

```Favoris

GET    /api/events              → Tous les événements

GET    /api/events/{id}         → Détail d'un événementGET    /api/favorites/user/{id} → Favoris d’un utilisateur

POST   /api/events              → Créer un événement (ADMIN)POST   /api/favorites/toggle    → Ajouter / retirer un favori

PUT    /api/events/{id}         → Modifier un événement (ADMIN)

DELETE /api/events/{id}         → Supprimer un événement (ADMIN)Authentification

```

POST   /api/auth/signup          → Inscription

### FavorisPOST   /api/auth/login           → Connexion

```

GET    /api/favorites/user/{id} → Favoris d'un utilisateurMétadonnées

POST   /api/favorites/toggle    → Ajouter / retirer un favori

```GET /api/categories              → Liste des catégories

GET /api/locations               → Liste des villes

### Authentification

```

POST   /api/auth/signup         → Inscription⸻

POST   /api/auth/login          → Connexion

```🧱 Technologies Utilisées



### MétadonnéesDomaine	Technologies

```Frontend	Angular 20, TypeScript 5.6, RxJS, Nginx

GET    /api/categories          → Liste des catégoriesBackend	Spring Boot 3, Java 21, JPA/Hibernate, Spring Security

GET    /api/locations           → Liste des villesDatabase	MySQL 8.4

```DevOps	Docker & Docker Compose

Tests	JUnit 5, Karma + Jasmine

---Design	CSS Custom Properties (thème noir & or)



## 🧱 Technologies Utilisées

⸻

| Domaine | Technologies |

|---------|--------------|🎨 Design System

| **Frontend** | Angular 20, TypeScript 5.6, RxJS, Nginx |	•	🎨 Couleurs

| **Backend** | Spring Boot 3, Java 21, JPA/Hibernate, Spring Security |	•	Primaire : #f0d45e (or)

| **Database** | MySQL 8.4 |	•	Secondaire : #000000 (noir)

| **DevOps** | Docker & Docker Compose |	•	Texte : #ffffff (blanc)

| **Tests** | JUnit 5, Karma + Jasmine |	•	🔠 Typographie

| **Design** | CSS Custom Properties (thème noir & or) |	•	Titres : majuscules espacées

	•	Corps : sans-serif lisible

---	•	📱 Responsive : Layout flexible (grid + media queries)



## 🌱 Base de Données & Seeding⸻



### Initialisation Automatique🌱 Base de Données & Seeding



Au premier démarrage (`docker compose up -d`), le backend exécute automatiquement le **DataSeeder** qui peuple la base de données.### Initialisation Automatique



### Comment ça fonctionne ?Au premier démarrage (`docker compose up -d`), le backend exécute automatiquement le **DataSeeder** qui peuple la base de données avec :



```java| Type de données | Quantité | Détails |

// Le DataSeeder vérifie si des données existent déjà|----------------|----------|---------|

if (categoryRepository.count() > 0) {| **Catégories** | 8 | Musique, Théâtre, Sport, Art & Exposition, Festival, Gastronomie, Cinéma, Conférence |

    System.out.println("✅ Database already populated. Skipping seed.");| **Localisations** | 11 | Stade de France, Accor Arena, Philharmonie, Musée du Louvre, Parc des Princes, etc. |

    return;| **Événements** | 36 | Concerts, festivals, matchs, expositions, conférences avec dates réelles |

}| **Utilisateurs** | 7 | 1 admin (`Admin@eventapp.fr`) + 6 utilisateurs standards |

// Sinon, il crée toutes les données (catégories, lieux, événements, utilisateurs)

```### Comment ça fonctionne ?



### Réinitialiser la base de données```java

// Le DataSeeder vérifie si des données existent déjà

```bashif (categoryRepository.count() > 0) {

# Supprimer les conteneurs ET les volumes (reset complet)    System.out.println("✅ Database already populated. Skipping seed.");

docker compose down -v    return;

}

# Redémarrer (le seeding s'exécutera à nouveau)// Sinon, il crée toutes les données...

docker compose up -d```

```

### Réinitialiser la base

> **💡 Astuce** : Si vous voyez "✅ Database already populated" dans les logs, c'est normal !

```bash

---# Supprimer les conteneurs ET les volumes (reset complet)

docker compose down -v

## 🧪 Tests et Qualité

# Redémarrer (le seeding s'exécutera à nouveau)

```bashdocker compose up -d

# Backend```

cd back-end

./mvnw test> **💡 Astuce :** Le seeding ne s'exécute qu'une seule fois. Si vous voyez "✅ Database already populated" dans les logs, c'est normal !



# Frontend⸻

cd front-end

npm run test🧪 Tests et Qualité

npm run lint

```# Backend

cd back-end

---./mvnw test



## 🐛 Dépannage Rapide# Frontend

cd front-end

| Problème | Solution |npm run test

|----------|----------|npm run lint

| **Frontend blanc** | Hard refresh (Ctrl+Shift+R), puis `docker compose logs frontend` |

| **Backend 502/503** | Attendre 40-60s (init DB), puis `docker compose logs backend` |

| **Port déjà utilisé** | `lsof -ti:8000,8081,3306 \| xargs kill -9` |⸻

| **Erreur CORS** | Vérifier configuration proxy Angular ou CORS backend |

🐛 Dépannage rapide

---

Problème	Solution

## 📋 Référence RapideFrontend blanc	Hard refresh (Ctrl+Shift+R), puis docker compose logs frontend

Backend 502/503	Attendre 40 s ou docker compose logs backend

### Commandes EssentiellesPort déjà utilisé	`lsof -ti:8000,8081,3306

Erreur CORS (en local)	Configurer proxy Angular (proxy.conf.json) ou activer CORS côté backend

```bash

# Démarrer l'application

docker compose up -d⸻



# Voir les logs en temps réel📈 Roadmap (Évolutions futures)

docker compose logs -f backend	•	Authentification JWT avec refresh token

docker compose logs -f frontend	•	Upload d’images (Cloudinary / S3)

	•	Tableau de bord analytics

# Arrêter l'application	•	Tests E2E (Playwright ou Cypress)

docker compose down	•	CI/CD complet (Render + Netlify)

	•	Carte interactive (Leaflet / Google Maps)

# Reset complet (base de données incluse)

docker compose down -v⸻



# Vérifier l'état des conteneurs🎓 Contexte Académique

docker compose ps

Projet développé dans le cadre du cours de développement full-stack (EPF – Ingénierie Numérique 2025).

# Accéder à MySQLObjectifs :

docker compose exec db mysql -u eventuser -peventpass eventdb	•	Maîtrise de l’architecture client-serveur moderne

```	•	Conception et conteneurisation d’une application web complète

	•	Mise en œuvre d’un workflow DevOps reproductible

### URLs Importantes

⸻

| Service | URL |

|---------|-----|📄 Licence

| **Frontend** | http://localhost:8000 |

| **Backend API** | http://localhost:8081/api |Projet à usage éducatif et non commercial.

| **Swagger UI** | http://localhost:8081/swagger-ui.html (si configuré) |Libre de réutilisation et d’adaptation à des fins pédagogiques.



### Identifiants Rapides⸻



```✅ Statut du Projet

Admin     : Admin@eventapp.fr / pass123

User      : sofiabdou2017@gmail.com / Abdou123Composant	État

Database  : eventuser / eventpassBackend	✅ Complet (CRUD, Auth, Favoris, Seeding auto)

```Frontend	✅ Fonctionnel et responsive

Intégration	✅ API connectée via Nginx

---Documentation	✅ Complète

Docker	✅ Production Ready

## 🎨 Design System



- **🎨 Couleurs**⸻

  - Primaire : `#f0d45e` (or)

  - Secondaire : `#000000` (noir)📋 Référence Rapide

  - Texte : `#ffffff` (blanc)

### Commandes Essentielles

- **🔠 Typographie**

  - Titres : majuscules espacées```bash

  - Corps : sans-serif lisible# Démarrer l'application

docker compose up -d

- **📱 Responsive** : Layout flexible (grid + media queries)

# Voir les logs en temps réel

---docker compose logs -f backend

docker compose logs -f frontend

## 📈 Roadmap (Évolutions futures)

# Arrêter l'application

- [ ] Authentification JWT avec refresh tokendocker compose down

- [ ] Upload d'images (Cloudinary / S3)

- [ ] Tableau de bord analytics# Reset complet (base de données incluse)

- [ ] Tests E2E (Playwright ou Cypress)docker compose down -v

- [ ] CI/CD complet (Render + Netlify)

- [ ] Carte interactive (Leaflet / Google Maps)# Vérifier l'état des conteneurs

docker compose ps

---

# Accéder à MySQL

## 🎓 Contexte Académiquedocker compose exec db mysql -u eventuser -peventpass eventdb

```

Projet développé dans le cadre du cours de **développement full-stack** (EPF – Ingénierie Numérique 2025).

### URLs Importantes

**Objectifs pédagogiques** :

- Maîtrise de l'architecture client-serveur moderne| Service | URL |

- Conception et conteneurisation d'une application web complète|---------|-----|

- Mise en œuvre d'un workflow DevOps reproductible| Frontend | http://localhost:8000 |

| Backend API | http://localhost:8081/api |

---| Swagger UI | http://localhost:8081/swagger-ui.html (si configuré) |



## 📄 Licence### Identifiants Rapides



Projet à usage éducatif et non commercial.```

Libre de réutilisation et d'adaptation à des fins pédagogiques.Admin    : Admin@eventapp.fr / pass123

User     : sofiabdou2017@gmail.com / Abdou123

---Database : eventuser / eventpass

```

## ✅ Statut du Projet

⸻
| Composant | État |
|-----------|------|
| **Backend** | ✅ Complet (CRUD, Auth, Favoris, Seeding auto) |
| **Frontend** | ✅ Fonctionnel et responsive |
| **Intégration** | ✅ API connectée via Nginx |
| **Documentation** | ✅ Complète |
| **Docker** | ✅ Production Ready |

---

**Auteur** : Abdallah Sofi  
**Contact** : sofiabdou2017@gmail.com  
**Version** : 1.0 – Novembre 2025
