# EventApp - Plateforme de Gestion d'Événements# 🎉 EventApp - Application complète de gestion d'événements



Une application web moderne pour découvrir, gérer et réserver des événements culturels et sportifs.Une application full-stack moderne pour gérer et découvrir des événements.



## 🎯 Aperçu du Projet---



EventApp est une plateforme complète de gestion d'événements développée avec une architecture microservices, offrant une expérience utilisateur élégante et intuitive pour la découverte et la réservation d'événements.## ✅ YOUR APP IS READY TO USE!



### Fonctionnalités Principales**Everything is configured and ready to go!** Just run:



- 🎫 **Catalogue d'événements** : Parcourir et filtrer les événements par catégorie, ville, date et prix```bash

- ❤️ **Système de favoris** : Sauvegarder vos événements préférés./start-all.sh

- 👤 **Gestion de profil** : Profil utilisateur personnalisé avec avatar et bio```

- 🔐 **Authentification** : Système de connexion et inscription sécurisé

- 🎨 **Interface luxueuse** : Design moderne avec palette noir et orThen open: **http://localhost:4200**

- 📱 **Responsive** : Interface adaptée à tous les écrans

- 🗺️ **Carte interactive** : Visualisation géographique des événements� **Read `START_HERE.md` for complete instructions!**

- 🎟️ **Billetterie externe** : Redirection vers les plateformes de vente de billets

- 👨‍💼 **Panel Admin** : Création et gestion d'événements (rôle ADMIN)---



## 🏗️ Architecture Technique## �📦 Structure du projet



### Stack Technologique```

EventProject/

#### Frontend├── back-end/          # API REST Spring Boot

- **Framework** : Angular 20 (Standalone Components)│   ├── src/

- **Langage** : TypeScript│   ├── pom.xml

- **Styling** : CSS Custom Properties, Design System│   └── start-with-seeder.sh

- **Routing** : Angular Router│

- **HTTP Client** : Angular HttpClient├── front-end/         # Application Angular

- **Build** : Node.js 20, npm│   ├── src/

│   ├── package.json

#### Backend│   └── start.sh

- **Framework** : Spring Boot 3.x│

- **Langage** : Java 21└── database/          # Configuration MySQL

- **ORM** : Hibernate/JPA```

- **Base de données** : MySQL 8.4

- **API** : RESTful endpoints avec CORS---



#### DevOps## 🚀 Démarrage rapide

- **Conteneurisation** : Docker & Docker Compose

- **Proxy** : Nginx### Option Docker (recommandée)

- **Gestion des volumes** : Persistance des données MySQL

**📖 Voir [DOCKER_GUIDE.md](DOCKER_GUIDE.md) pour le guide complet**

### Structure du Projet

Conteneurisez tout (MySQL + Backend + Frontend) avec une seule commande.

```

EventProject/1) Construire et lancer

├── front-end/               # Application Angular

│   ├── src/```bash

│   │   ├── app/./start-docker.sh

│   │   │   ├── components/  # Composants UI```

│   │   │   ├── services/    # Services Angular

│   │   │   ├── models/      # Interfaces TypeScript2) Ouvrir l'application

│   │   │   └── utils/       # Utilitaires

│   │   ├── styles.css       # Styles globaux- Frontend: http://localhost:8000

│   │   └── index.html- Backend (API): http://localhost:8081

│   ├── Dockerfile- API via Frontend Proxy: http://localhost:8000/api/...

│   └── package.json- MySQL (interne au réseau docker): `db:3306` (pas exposé sur l'hôte)

│

├── back-end/                # API Spring Boot3) Arrêter

│   ├── src/

│   │   └── main/```bash

│   │       ├── java/docker compose down

│   │       │   └── com/atlas/backend/```

│   │       │       ├── controller/  # Controllers REST

│   │       │       ├── service/     # Logique métierNotes:

│   │       │       ├── model/       # Entités JPA- Les services Angular appellent désormais l'API en chemin relatif (`/api/...`). Nginx route `/api` vers le backend.

│   │       │       ├── repository/  # Repositories- Les variables de connexion MySQL pour le backend sont injectées via `docker-compose.yml`.

│   │       │       └── config/      # Configuration- Les données MySQL sont persistées dans le volume `db_data`.

│   │       └── resources/

│   │           └── application.properties### Option 1: One Command (Easiest!)

│   ├── Dockerfile```bash

│   └── pom.xml./start-all.sh

│```

├── database/                # Scripts SQL

│   ├── init.sql            # Schéma de base de données### Option 2: Separate Terminals

│   ├── seed.sql            # Données de test

│   └── create_admin_user.sql### 1️⃣ Démarrer la base de données

│```bash

├── docker-compose.yml       # Configuration Docker# Assurez-vous que MySQL est installé et en cours d'exécution

└── README.md# Base de données: eventdb

```# User: root

# Password: (vide)

## 🚀 Installation et Démarrage```



### Prérequis### 2️⃣ Démarrer le backend

```bash

- Docker Desktop (ou Docker Engine + Docker Compose)cd back-end

- Git./start-with-seeder.sh

# ou

### Démarrage Rapide./mvnw spring-boot:run

```

1. **Cloner le projet**✅ Backend accessible sur: http://localhost:8080

```bash

git clone <url-du-repo>### 3️⃣ Démarrer le frontend

cd EventProject```bash

```cd front-end

./start.sh

2. **Lancer l'application avec Docker**# ou

```bashng serve

docker-compose up -d```

```✅ Frontend accessible sur: http://localhost:4200



3. **Accéder à l'application**---

- Frontend : http://localhost:8000

- Backend API : http://localhost:8081## 🎯 Fonctionnalités



### Temps de Démarrage### Backend (Spring Boot)

- ✅ API REST complète

- Base de données : ~15 secondes- ✅ Base de données MySQL

- Backend : ~30-40 secondes- ✅ CRUD pour Events, Categories, Locations, Users

- Frontend : ~10 secondes- ✅ Recherche et filtrage

- ✅ Seeder de données

⏳ Attendez environ **1 minute** après `docker-compose up` pour que tous les services soient prêts.- ✅ CORS configuré



### Vérification de l'État### Frontend (Angular)

- ✅ Liste des événements avec recherche

```bash- ✅ Filtrage par catégorie

# Vérifier que les conteneurs sont en cours d'exécution- ✅ Détails d'événement

docker-compose ps- ✅ Création d'événement

- ✅ Design responsive

# Voir les logs- ✅ Interface moderne

docker-compose logs -f

```---



## 👥 Comptes de Test## 📚 Documentation



### Utilisateur Admin### Backend

- **Email** : Admin@eventapp.fr- `back-end/API_DOCUMENTATION.md` - Documentation de l'API

- **Mot de passe** : pass123- `back-end/DATABASE_SEEDING.md` - Guide du seeder

- **Privilèges** : Création d'événements, accès panel admin- `back-end/IMPLEMENTATION_COMPLETE.md` - Guide complet



### Utilisateur Standard### Frontend

- **Email** : sofiabdou2017@gmail.com- `front-end/README_MVP.md` - Guide de démarrage

- **Mot de passe** : Abdou123- `front-end/MVP_COMPLETE.md` - Fonctionnalités complètes

- **Privilèges** : Navigation, favoris, réservations- `front-end/TESTING_GUIDE.md` - Guide de tests

- `front-end/PROJET_FINAL.md` - Résumé final

## 📊 Base de Données

---

### Tables Principales

## 🔧 Technologies utilisées

- **users** : Utilisateurs (role: USER/ADMIN/ORGANIZER)

- **events** : Événements (titre, description, date, prix, lien billetterie)### Backend

- **categories** : Catégories d'événements (Concert, Sport, Théâtre, etc.)- Spring Boot 3.x

- **locations** : Lieux (nom, adresse, ville, coordonnées GPS)- Spring Data JPA

- **favorites** : Relations user-event pour les favoris- MySQL

- Maven

### Schéma des Relations

### Frontend

```- Angular 20

users (1) ----< (N) favorites (N) >---- (1) events- TypeScript

events (N) ---- (1) categories- RxJS

events (N) ---- (1) locations- Angular Router

```

---

## 🎨 Design System

## 📱 Captures d'écran

### Palette de Couleurs

### Liste des événements

- **Primaire** : Or (#f0d45e) - Boutons, accents- Grille responsive

- **Secondaire** : Noir (#000000) - Fond principal- Recherche en temps réel

- **Texte** : Blanc (#ffffff) - Texte principal- Filtres par catégorie

- **Gris clair** : (#cccccc) - Texte secondaire

### Détails d'événement

### Typographie- Affichage complet

- Informations de localisation

- **Display** : Titres principaux, lettres espacées- Compteur de vues

- **Body** : Texte courant, police sans-serif

- **Accent** : Petits textes, uppercase### Création d'événement

- Formulaire validé

### Composants Réutilisables- Sélection catégorie/lieu

- Feedback utilisateur

- Boutons (primaire, secondaire, outline)

- Cartes d'événements (petite, moyenne, large)---

- Formulaires avec validation

- Modales et overlays## ✅ Statut du projet

- Navigation responsive

**Backend:** ✅ Complet et fonctionnel  

## 🔌 API Endpoints**Frontend:** ✅ MVP complet et fonctionnel  

**Integration:** ✅ Backend et Frontend connectés  

### Événements**Documentation:** ✅ Complète

```

GET    /api/events              # Tous les événements---

GET    /api/events/{id}         # Détail événement

GET    /api/events/published    # Événements publiés## 🆘 Troubleshooting

POST   /api/events              # Créer événement (ADMIN)

PUT    /api/events/{id}         # Modifier événement (ADMIN)### Le backend ne démarre pas

DELETE /api/events/{id}         # Supprimer événement (ADMIN)- Vérifier que MySQL est en cours d'exécution

GET    /api/events/category/{id} # Par catégorie- Vérifier les credentials dans `application.properties`

GET    /api/events/location/{id} # Par lieu- Vérifier que le port 8080 est libre

```

### Le frontend ne se connecte pas au backend

### Favoris- Vérifier que le backend est démarré

```- En Docker, l'URL est relative (`/api`). En dev local, configurez un proxy Angular si besoin (voir ci-dessous)

GET    /api/favorites/user/{id}     # Favoris d'un utilisateur- Vérifier la console du navigateur pour les erreurs CORS

POST   /api/favorites/toggle        # Ajouter/Retirer favori

DELETE /api/favorites/{id}          # Supprimer favori### Dev local Angular avec proxy `/api`

```

Créez `front-end/proxy.conf.json` (optionnel):

### Utilisateurs

``````json

GET    /api/users/email/{email}     # Récupérer user par email{

```	"/api": {

		"target": "http://localhost:8080",

### Catégories		"secure": false,

```		"changeOrigin": true,

GET    /api/categories              # Toutes les catégories		"logLevel": "debug"

```	}

}

### Lieux```

```

GET    /api/locations               # Tous les lieuxPuis démarrez:

GET    /api/locations/cities        # Liste des villes

``````bash

cd front-end

## 🛠️ Commandes Utilesnpm run start:proxy

```

### Docker

### Erreur de compilation

```bash```bash

# Démarrer les servicescd front-end

docker-compose up -drm -rf node_modules package-lock.json

npm install

# Arrêter les servicesng serve

docker-compose down```



# Rebuild après modifications---

docker-compose build

docker-compose up -d## 🎓 Commandes utiles



# Voir les logs d'un service### Backend

docker-compose logs frontend```bash

docker-compose logs backend# Compiler

docker-compose logs db./mvnw clean install



# Accéder au conteneur MySQL# Démarrer

docker-compose exec db mysql -u eventuser -peventpass eventdb./mvnw spring-boot:run

```

# Tests

### Frontend (développement local)./mvnw test

```

```bash

cd front-end### Frontend

npm install```bash

npm start              # Serveur de développement# Installer les dépendances

npm run build          # Build de productionnpm install

```

# Développement

### Backend (développement local)ng serve



```bash# Build production

cd back-endng build

./mvnw clean install   # Compiler

./mvnw spring-boot:run # Lancer l'application# Tests

```ng test

```

## 📝 Notes de Développement

---

### Variables d'Environnement

## 👥 Pour les développeurs

Backend (`application.properties`) :

```properties### Ajouter un nouvel endpoint

spring.datasource.url=jdbc:mysql://db:3306/eventdb1. Créer le modèle dans `back-end/src/main/java/.../model/`

spring.datasource.username=eventuser2. Créer le repository dans `repository/`

spring.datasource.password=eventpass3. Créer le service dans `service/`

```4. Créer le controller dans `controller/`

5. Mettre à jour le frontend si nécessaire

Frontend : Les appels API utilisent `/api/*` grâce au proxy Nginx configuré dans Docker.

### Ajouter un nouveau composant Angular

### Proxy Nginx```bash

cd front-end

Le frontend Nginx est configuré pour proxyfier les requêtes `/api/*` vers le backend sur le port 8080, évitant ainsi les problèmes CORS.ng generate component components/mon-composant

```

### Persistence des Données

### Ajouter un nouveau service Angular

Les données MySQL sont persistées dans un volume Docker nommé `mysql_data`. Pour réinitialiser :```bash

```bashcd front-end

docker-compose down -v  # Supprime les volumesng generate service services/mon-service

docker-compose up -d```

```

---

## 🐛 Résolution de Problèmes

## 📈 Prochaines étapes possibles

### Le frontend ne charge pas

```bash- [ ] Authentification JWT

# Vérifier que le bundle est déployé- [ ] Gestion des favoris utilisateur

curl -s http://localhost:8000/ | grep "main-.*\.js"- [ ] Upload d'images

- [ ] Pagination

# Rebuild du frontend- [ ] Filtres avancés

docker-compose restart frontend- [ ] Carte interactive

```- [ ] Notifications

- [ ] Tests E2E

### Erreurs de connexion à la base de données- [ ] Déploiement (Docker)

```bash

# Vérifier que MySQL est ready---

docker-compose logs db | grep "ready for connections"

## 📄 Licence

# Attendre 15-20 secondes après le démarrage

```Ce projet a été créé à des fins éducatives.



### Port déjà utilisé---

```bash

# Vérifier les ports utilisés## ✨ Remerciements

lsof -i :8000  # Frontend

lsof -i :8081  # BackendProjet EventApp - Full Stack Application  

lsof -i :3306  # MySQLBackend: Spring Boot + MySQL  

Frontend: Angular 20  

# Arrêter les services conflictuels ou modifier docker-compose.yml

```**Status: Production Ready ✅**



## 📦 Build de Production---



Pour créer une version de production :**Dernière mise à jour:** 2 novembre 2025



1. **Frontend** : Le Dockerfile multi-stage build Angular en production
2. **Backend** : Le Dockerfile compile le JAR avec Maven
3. **Docker Compose** : Lance tous les services en mode production

```bash
docker-compose build
docker-compose up -d
```

## 🎓 Informations Académiques

### Technologies Utilisées

- **Frontend** : Angular 20, TypeScript, CSS3, HTML5
- **Backend** : Spring Boot 3, Java 21, JPA/Hibernate
- **Base de données** : MySQL 8.4
- **Conteneurisation** : Docker, Docker Compose
- **Architecture** : REST API, Microservices, SPA

### Concepts Implémentés

- ✅ Architecture MVC/MVVM
- ✅ API RESTful avec CRUD complet
- ✅ Authentification et autorisation (rôles)
- ✅ Système de relations many-to-one, many-to-many
- ✅ Validation des données (frontend et backend)
- ✅ Gestion d'état côté client
- ✅ Responsive design
- ✅ Conteneurisation avec Docker
- ✅ Proxy inverse avec Nginx

## 📄 Licence

Ce projet est développé dans un cadre académique.

## 👨‍💻 Auteur

Développé par Abdallah Sofi

---

**Note** : Ce projet utilise Docker pour simplifier le déploiement. Assurez-vous que Docker Desktop est installé et en cours d'exécution avant de lancer l'application.
