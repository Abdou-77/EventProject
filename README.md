# EventApp - Plateforme de Gestion d'Événements<div align="center"># 🎉 EventApp – Plateforme de Gestion d'Événements# 🎉 EventApp – Plateforme de Gestion d'Événements



Application full-stack pour créer, découvrir et gérer des événements culturels et sportifs.



**Stack:** Angular 20, Spring Boot 3, MySQL 8.4, Docker# 🎭 EventApp



---



## Démarrage rapide### *Modern Event Management Platform*> Application full-stack moderne pour créer, découvrir et gérer des événements culturels et sportifs.> Application full-stack moderne pour créer, découvrir et gérer des événements culturels et sportifs.



```bash

docker compose up -d

```[![Angular](https://img.shields.io/badge/Angular-20-DD0031?style=flat&logo=angular)](https://angular.io/)> > 



Ouvrir http://localhost:8000[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3-6DB33F?style=flat&logo=springboot)](https://spring.io/projects/spring-boot)



### Comptes de test[![MySQL](https://img.shields.io/badge/MySQL-8.4-4479A1?style=flat&logo=mysql&logoColor=white)](https://www.mysql.com/)> **Stack**: Angular 20 · Spring Boot 3 · MySQL 8.4 · Docker> **Stack**: Angular 20 · Spring Boot 3 · MySQL 8.4 · Docker



- **Admin:** Admin@eventapp.fr / pass123[![Docker](https://img.shields.io/badge/Docker-Ready-2496ED?style=flat&logo=docker&logoColor=white)](https://www.docker.com/)

- **User:** sofiabdou2017@gmail.com / Abdou123

> > 

---

*Full-stack application for discovering and managing cultural events*

## Fonctionnalités

> **Projet académique** – Version 1.0 (Novembre 2025)> **Projet académique** – Version 1.0 (Novembre 2025)

### Utilisateurs

- Catalogue d'événements avec filtres (catégorie, ville, date, prix)[Quick Start](#-quick-start) • [Features](#-features) • [API](#-api) • [Tech Stack](#-tech-stack)

- Système de favoris

- Gestion de profil

- Liens vers billetteries externes

- Interface responsive</div>



### Administrateurs------

- Création d'événements

- Modification et suppression d'événements---

- Statistiques (vues, favoris)

- Gestion des images



---## ⚡ Quick Start



## Architecture## 🧭 Aperçu Technique## 🧭 Aperçu Technique



``````bash

Browser → Nginx (port 8000) → Angular 20

                            → Spring Boot API (port 8081) → MySQL (port 3306)# Start everything

```

docker compose up -d

**Services:**

- Frontend: Angular 20 avec Nginx| Élément | Stack || Élément | Stack |

- Backend: Spring Boot 3 avec Java 21

- Database: MySQL 8.4# Open the app



---open http://localhost:8000|---------|-------||---------|-------|



## Structure du projet```



```| **Frontend** | Angular 20 (TypeScript, Standalone Components, Nginx) || **Frontend** | Angular 20 (TypeScript, Standalone Components, Nginx) |

EventProject/

├── back-end/              # API Spring Boot**That's it.** The database will auto-populate with sample data.

│   ├── src/main/java/

│   │   └── com/atlas/backend/| **Backend** | Spring Boot 3 (Java 21, JPA/Hibernate, Spring Security) || **Backend** | Spring Boot 3 (Java 21, JPA/Hibernate, Spring Security) |

│   │       ├── controller/

│   │       ├── service/### 🔑 Test Accounts

│   │       ├── repository/

│   │       ├── model/| **Base de données** | MySQL 8.4 (seed automatique au démarrage) || **Base de données** | MySQL 8.4 (seed automatique au démarrage) |

│   │       └── config/

│   └── Dockerfile| Role  | Email | Password |

├── front-end/             # Application Angular

│   ├── src/app/|-------|-------|----------|| **Infra / DevOps** | Docker & Docker Compose || **Infra / DevOps** | Docker & Docker Compose |

│   │   ├── components/

│   │   ├── services/| 👑 Admin | `Admin@eventapp.fr` | `pass123` |

│   │   └── models/

│   └── Dockerfile| 👤 User | `sofiabdou2017@gmail.com` | `Abdou123` || **Objectif** | Démonstration complète : authentification, favoris, CRUD, responsive design || **Objectif** | Démonstration complète : authentification, favoris, CRUD, responsive design |

└── docker-compose.yml

```



------



## Endpoints API



### Événements## ✨ Features------

- `GET /api/events` - Liste des événements

- `GET /api/events/{id}` - Détail d'un événement

- `POST /api/events` - Créer un événement (Admin)

- `PUT /api/events/{id}` - Modifier un événement (Admin)<table>

- `DELETE /api/events/{id}` - Supprimer un événement (Admin)

<tr>

### Favoris

- `GET /api/favorites/user/{id}` - Favoris d'un utilisateur<td width="50%">## ✨ Fonctionnalités✨ Fonctionnalités

- `POST /api/favorites/toggle` - Ajouter/Retirer un favori



### Authentification

- `POST /api/auth/signup` - Inscription### For Users

- `POST /api/auth/login` - Connexion

- 🔍 **Smart Search** - Filter by category, city, date, price

### Métadonnées

- `GET /api/categories` - Liste des catégories- ❤️ **Favorites** - Save events you love### 👥 Utilisateurs👥 Utilisateurs

- `GET /api/locations` - Liste des villes

- 👤 **Profile** - Personalized user experience

---

- 🎟️ **Tickets** - Direct links to booking platforms- 🔎 **Catalogue d'événements** filtrable (catégorie, ville, date, prix)	•	🔎 Catalogue d’événements filtrable (catégorie, ville, date, prix)

## Base de données

- 📱 **Responsive** - Works on any device

La base de données est automatiquement peuplée au premier démarrage avec:

- 8 catégories (Musique, Théâtre, Sport, Art, Festival, Gastronomie, Cinéma, Conférence)- ❤️ **Système de favoris** persistants	•	❤️ Système de favoris persistants

- 11 lieux (Paris, Lyon, Marseille, Bordeaux, Nice)

- 36 événements</td>

- 7 utilisateurs (1 admin + 6 utilisateurs)

<td width="50%">- 👤 **Gestion de profil** utilisateur personnalisé	•	👤 Gestion de profil utilisateur

**Réinitialiser la base:**

```bash

docker compose down -v

docker compose up -d### For Admins- 🎟️ **Lien billetterie** externe	•	🎟️ Lien vers billetteries externes

```

- ➕ **Create Events** - Rich form with all details

---

- ✏️ **Edit Anytime** - Update events on the fly- 📱 **Interface responsive** (mobile, tablette, desktop)	•	📱 Interface responsive (mobile, tablette, desktop)

## Commandes utiles

- 🗑️ **Safe Delete** - Confirmation before removal

```bash

# Démarrer l'application- 📊 **Analytics** - View counts and favorites

docker compose up -d

- 🖼️ **Media Manager** - Handle images & metadata

# Voir les logs

docker compose logs -f### 🧑‍💼 Administrateurs🧑‍💼 Administrateurs



# Arrêter l'application</td>

docker compose down

</tr>- ➕ **Création d'événements** avec formulaire complet	•	➕ Création d’événements

# Réinitialiser (base de données incluse)

docker compose down -v</table>



# Vérifier l'état- ✏️ **Modification / suppression** avec confirmation de sécurité	•	✏️ Modification / suppression avec confirmation

docker compose ps

```---



---- 📊 **Vue synthétique** (statistiques de vues et favoris)	•	📊 Vue synthétique (statistiques de vues et favoris)



## Tests## 🏗️ Architecture



```bash- 🖼️ **Gestion des images** et métadonnées	•	🖼️ Gestion des images et métadonnées

# Backend

cd back-end```mermaid

./mvnw test

graph LR

# Frontend

cd front-end    A[Browser] --> B[Nginx:8000]

npm test

npm run lint    B --> C[Angular 20]---⸻

```

    B --> D[Spring Boot:8081]

---

    D --> E[(MySQL:3306)]

## Technologies utilisées

    

- **Frontend:** Angular 20, TypeScript, RxJS, Nginx

- **Backend:** Spring Boot 3, Java 21, JPA/Hibernate, Spring Security    style A fill:#f9f,stroke:#333,stroke-width:2px## 🏗️ Architecture🏗️ Architecture

- **Database:** MySQL 8.4

- **DevOps:** Docker, Docker Compose    style C fill:#dd0031,stroke:#333,stroke-width:2px,color:#fff



---    style D fill:#6db33f,stroke:#333,stroke-width:2px,color:#fff



## Dépannage    style E fill:#4479a1,stroke:#333,stroke-width:2px,color:#fff



- **Frontend ne charge pas:** Faire Ctrl+Shift+R puis vérifier les logs avec `docker compose logs frontend```````[Browser]

- **Backend ne répond pas:** Attendre 60 secondes pour l'initialisation

- **Port déjà utilisé:** `lsof -ti:8000 | xargs kill -9`



------[Browser]   ↓



## Contexte



Projet académique développé dans le cadre du cours de développement full-stack.## 🎨 Tech Stack   ↓Angular (Frontend - port 8000, Nginx)



**Auteur:** Abdallah Sofi  

**Version:** 1.0 - Novembre 2025

<table>Angular (Frontend - port 8000, Nginx)   ↳ /api → Backend

<tr>

<td align="center" width="33%">   ↳ /api → Backend   ↓



### Frontend   ↓Spring Boot (Backend - port 8081)

**Angular 20**

TypeScript 5.6 • RxJS • NginxSpring Boot (Backend - port 8081)   ↳ Services (Auth, Events, Favorites, Categories, Locations)

Standalone Components

CSS Custom Properties   ↳ Services (Auth, Events, Favorites, Categories, Locations)   ↓



</td>   ↓MySQL (Database - port 3306)

<td align="center" width="33%">

MySQL (Database - port 3306)

### Backend

**Spring Boot 3**```

Java 21 • JPA/Hibernate

Spring Security⸻

REST API

---

</td>

<td align="center" width="33%">📦 Structure du Projet



### Database## 🚀 Démarrage Rapide

**MySQL 8.4**

Auto-seeded dataEventProject/

Docker volumes

Persistent storage### Prérequis├── back-end/              # API REST (Spring Boot)



</td>- ✅ Docker Desktop ou Docker Engine + Compose│   ├── src/main/java/com/atlas/backend/

</tr>

</table>- ✅ Ports libres : 8000 (frontend), 8081 (backend), 3306 (MySQL)│   │   ├── controller/    # REST Controllers



---│   │   ├── service/       # Logique métier



## 🔌 API### 1️⃣ Lancer l'application│   │   ├── repository/    # Spring Data JPA



<details>│   │   ├── model/         # Entités JPA

<summary><b>📌 Events Endpoints</b></summary>

```bash│   │   └── config/        # CORS, sécurité, seeders

```http

GET    /api/events              # All eventsdocker compose up -d│   ├── Dockerfile

GET    /api/events/{id}         # Event details

POST   /api/events              # Create (Admin only)```│   └── pom.xml

PUT    /api/events/{id}         # Update (Admin only)

DELETE /api/events/{id}         # Delete (Admin only)│

```

⏳ **Attendre ~60 secondes** : la base de données, le backend et le frontend démarrent automatiquement.├── front-end/             # Application Angular

</details>

│   ├── src/app/

<details>

<summary><b>❤️ Favorites Endpoints</b></summary>### 2️⃣ Accéder à l'application│   │   ├── components/    # UI Components (auth, events, admin…)



```http- 🌐 **Frontend** : http://localhost:8000│   │   ├── services/      # Services HTTP

GET    /api/favorites/user/{id} # User's favorites

POST   /api/favorites/toggle    # Add/Remove favorite- ⚙️ **API REST** : http://localhost:8081/api│   │   ├── models/        # Interfaces TypeScript

```

│   │   └── app.routes.ts  # Routing

</details>

### 3️⃣ Arrêter l'application│   ├── Dockerfile

<details>

<summary><b>🔐 Auth Endpoints</b></summary>│   ├── nginx.conf



```http```bash│   └── package.json

POST   /api/auth/signup         # Register new user

POST   /api/auth/login          # Logindocker compose down         # Stoppe les conteneurs│

```

docker compose down -v      # Stoppe + supprime les volumes (reset DB)├── database/              # Scripts SQL (optionnel)

</details>

```├── docker-compose.yml

<details>

<summary><b>📊 Metadata Endpoints</b></summary>├── COMPTES_TEST.md



```http---└── README.md

GET    /api/categories          # All categories

GET    /api/locations           # All locations

```

## 🔐 Comptes de Test

</details>

⸻

---

| Rôle | Email | Mot de passe |

## 🌱 Database Seeding

|------|-------|--------------|🚀 Démarrage rapide (Docker recommandé)

**Auto-populated on first launch:**

| **Admin** | `Admin@eventapp.fr` | `pass123` |

| Type | Count | Examples |

|------|-------|----------|| **User** | `sofiabdou2017@gmail.com` | `Abdou123` |Prérequis

| 🎭 **Categories** | 8 | Music, Theatre, Sports, Art, Festivals... |

| 📍 **Locations** | 11 | Paris, Lyon, Marseille, Bordeaux, Nice |	•	Docker Desktop ou Docker Engine + Compose

| 🎫 **Events** | 36 | Concerts, matches, exhibitions, festivals |

| 👥 **Users** | 7 | 1 admin + 6 regular users |> **✅ Important** : Ces comptes sont automatiquement créés au premier démarrage via le **DataSeeder**.	•	Ports libres : 8000, 8081, 3306



> 💡 **Tip**: Database seeds only once. To reset: `docker compose down -v`



---### 🌱 Données pré-chargées au démarrage1️⃣ Lancer les services



## 📁 Project Structure



```| Type | Quantité | Détails |docker compose up -d

EventProject/

│|------|----------|---------|

├── 🎨 front-end/          # Angular 20 App

│   ├── src/app/| **Catégories** | 8 | Musique, Théâtre, Sport, Art, Festival, Gastronomie, Cinéma, Conférence |⏳ Attendre ~60 s : la base, le backend et le frontend démarrent automatiquement.

│   │   ├── components/    # UI Components

│   │   ├── services/      # HTTP Services| **Localisations** | 11 | Paris, Lyon, Marseille, Bordeaux, Nice |

│   │   └── models/        # TypeScript Interfaces

│   └── Dockerfile| **Événements** | 36 | Concerts, festivals, expositions, matchs sportifs avec dates réelles |2️⃣ Accéder à l’application

│

├── ⚙️ back-end/           # Spring Boot API| **Utilisateurs** | 7 | 1 admin + 6 utilisateurs standards |	•	🌐 Frontend : http://localhost:8000

│   ├── src/main/java/com/atlas/backend/

│   │   ├── controller/    # REST Controllers	•	⚙️ API REST : http://localhost:8081/api

│   │   ├── service/       # Business Logic

│   │   ├── repository/    # JPA Repositories⚠️ **Le seeding ne s'exécute qu'une seule fois**. Pour réinitialiser : `docker compose down -v`

│   │   ├── model/         # Entities

│   │   └── config/        # Security, CORS, Seeder3️⃣ Arrêter et nettoyer

│   └── Dockerfile

│---

└── 🐳 docker-compose.yml  # Orchestration

```docker compose down         # stoppe les conteneurs



---## 📦 Structure du Projetdocker compose down -v      # stoppe + supprime les volumes (reset DB)



## 🛠️ Commands



<table>```

<tr>

<td width="50%">EventProject/⸻



### Docker Commands├── back-end/              # API REST (Spring Boot)

```bash

# Start all services│   ├── src/main/java/com/atlas/backend/🔐 Comptes de Test

docker compose up -d

│   │   ├── controller/    # REST Controllers

# View logs

docker compose logs -f│   │   ├── service/       # Logique métierRôle	Email	Mot de passe



# Stop services│   │   ├── repository/    # Spring Data JPAAdmin	Admin@eventapp.fr	pass123

docker compose down

│   │   ├── model/         # Entités JPAUser	sofiabdou2017@gmail.com	Abdou123

# Reset everything

docker compose down -v│   │   └── config/        # CORS, sécurité, seeders

```

│   ├── Dockerfile> **✅ Important :** Ces comptes sont automatiquement créés au premier démarrage via le **DataSeeder**.

</td>

<td width="50%">│   └── pom.xml> 



### Development Commands│> **🌱 Données pré-chargées au démarrage :**

```bash

# Backend tests├── front-end/             # Application Angular> - **8 catégories** (Musique, Théâtre, Sport, Art, Festival, Gastronomie, Cinéma, Conférence)

cd back-end && ./mvnw test

│   ├── src/app/> - **11 lieux** (Paris, Lyon, Marseille, Bordeaux, Nice)

# Frontend tests

cd front-end && npm test│   │   ├── components/    # UI Components (auth, events, admin…)> - **36 événements** (concerts, festivals, expositions, matchs sportifs...)



# Frontend lint│   │   ├── services/      # Services HTTP> - **7 utilisateurs** (1 admin + 6 utilisateurs standards)

cd front-end && npm run lint

```│   │   ├── models/        # Interfaces TypeScript> 



</td>│   │   └── app.routes.ts  # Routing> ⚠️ Le seeding ne s'exécute qu'une seule fois. Pour réinitialiser : `docker compose down -v`

</tr>

</table>│   ├── Dockerfile



---│   ├── nginx.conf



## 🐛 Troubleshooting│   └── package.json⸻



| Issue | Solution |│

|-------|----------|

| 🤍 **Blank screen** | Hard refresh: `Ctrl+Shift+R` then check logs |├── database/              # Scripts SQL (optionnel)🔌 Endpoints Principaux (API)

| ⏳ **Backend not responding** | Wait 60s for initialization |

| 🚫 **Port already in use** | Kill process: `lsof -ti:8000 \| xargs kill -9` |├── docker-compose.yml

| 🔌 **CORS error** | Check Nginx proxy config or backend CORS |

└── README.mdÉvénements

---

```

## 🎯 Design System

GET    /api/events              → Tous les événements

<table>

<tr>---GET    /api/events/{id}         → Détail d’un événement

<td width="33%">

POST   /api/events              → Créer un événement (ADMIN)

### 🎨 Colors

- **Gold**: `#f0d45e`## 🔌 Endpoints API (principaux)PUT    /api/events/{id}         → Modifier un événement (ADMIN)

- **Black**: `#000000`

- **White**: `#ffffff`DELETE /api/events/{id}         → Supprimer un événement (ADMIN)



</td>### Événements

<td width="33%">

```Favoris

### 🔤 Typography

- **Headings**: Uppercase, spacedGET    /api/events              → Tous les événements

- **Body**: Sans-serif, readable

- **Accents**: Small, uppercaseGET    /api/events/{id}         → Détail d'un événementGET    /api/favorites/user/{id} → Favoris d’un utilisateur



</td>POST   /api/events              → Créer un événement (ADMIN)POST   /api/favorites/toggle    → Ajouter / retirer un favori

<td width="33%">

PUT    /api/events/{id}         → Modifier un événement (ADMIN)

### 📱 Responsive

- Mobile-first approachDELETE /api/events/{id}         → Supprimer un événement (ADMIN)Authentification

- Flexible grid layout

- Media queries```

- Touch-optimized

POST   /api/auth/signup          → Inscription

</td>

</tr>### FavorisPOST   /api/auth/login           → Connexion

</table>

```

---

GET    /api/favorites/user/{id} → Favoris d'un utilisateurMétadonnées

## 📚 Links

POST   /api/favorites/toggle    → Ajouter / retirer un favori

| Resource | URL |

|----------|-----|```GET /api/categories              → Liste des catégories

| 🌐 **Frontend** | http://localhost:8000 |

| 🔧 **Backend API** | http://localhost:8081/api |GET /api/locations               → Liste des villes

| 📊 **Swagger UI** | http://localhost:8081/swagger-ui.html |

| 🗄️ **MySQL** | `eventuser` / `eventpass` |### Authentification



---```



## 🎓 Academic ContextPOST   /api/auth/signup         → Inscription⸻



**EPF Engineering School** – Full-Stack Development Course 2025POST   /api/auth/login          → Connexion



**Learning Objectives:**```🧱 Technologies Utilisées

- Master modern client-server architecture

- Build & containerize complete web applications

- Implement reproducible DevOps workflows

### MétadonnéesDomaine	Technologies

---

```Frontend	Angular 20, TypeScript 5.6, RxJS, Nginx

## 📊 Project Status

GET    /api/categories          → Liste des catégoriesBackend	Spring Boot 3, Java 21, JPA/Hibernate, Spring Security

| Component | Status |

|-----------|--------|GET    /api/locations           → Liste des villesDatabase	MySQL 8.4

| Backend | ✅ Complete |

| Frontend | ✅ Complete |```DevOps	Docker & Docker Compose

| Integration | ✅ Working |

| Documentation | ✅ Complete |Tests	JUnit 5, Karma + Jasmine

| Docker | ✅ Ready |

---Design	CSS Custom Properties (thème noir & or)

---



## 📝 License

## 🧱 Technologies Utilisées

**Educational use only** • Non-commercial

⸻

---

| Domaine | Technologies |

<div align="center">

|---------|--------------|🎨 Design System

### Built with ❤️ by Abdallah Sofi

| **Frontend** | Angular 20, TypeScript 5.6, RxJS, Nginx |	•	🎨 Couleurs

**[sofiabdou2017@gmail.com](mailto:sofiabdou2017@gmail.com)**

| **Backend** | Spring Boot 3, Java 21, JPA/Hibernate, Spring Security |	•	Primaire : #f0d45e (or)

*Version 1.0 – November 2025*

| **Database** | MySQL 8.4 |	•	Secondaire : #000000 (noir)

</div>

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

**Auteur** : Abdellah Sofi  
**Contact** : sofiabdou2017@gmail.com  
**Version** : 1.0 – Novembre 2025