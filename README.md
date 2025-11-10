# 🎉 EventApp - Application complète de gestion d'événements

Une application full-stack moderne pour gérer et découvrir des événements.

---

## ✅ YOUR APP IS READY TO USE!

**Everything is configured and ready to go!** Just run:

```bash
./start-all.sh
```

Then open: **http://localhost:4200**

� **Read `START_HERE.md` for complete instructions!**

---

## �📦 Structure du projet

```
EventProject/
├── back-end/          # API REST Spring Boot
│   ├── src/
│   ├── pom.xml
│   └── start-with-seeder.sh
│
├── front-end/         # Application Angular
│   ├── src/
│   ├── package.json
│   └── start.sh
│
└── database/          # Configuration MySQL
```

---

## 🚀 Démarrage rapide

### Option Docker (recommandée)

**📖 Voir [DOCKER_GUIDE.md](DOCKER_GUIDE.md) pour le guide complet**

Conteneurisez tout (MySQL + Backend + Frontend) avec une seule commande.

1) Construire et lancer

```bash
./start-docker.sh
```

2) Ouvrir l'application

- Frontend: http://localhost:8000
- Backend (API): http://localhost:8081
- API via Frontend Proxy: http://localhost:8000/api/...
- MySQL (interne au réseau docker): `db:3306` (pas exposé sur l'hôte)

3) Arrêter

```bash
docker compose down
```

Notes:
- Les services Angular appellent désormais l'API en chemin relatif (`/api/...`). Nginx route `/api` vers le backend.
- Les variables de connexion MySQL pour le backend sont injectées via `docker-compose.yml`.
- Les données MySQL sont persistées dans le volume `db_data`.

### Option 1: One Command (Easiest!)
```bash
./start-all.sh
```

### Option 2: Separate Terminals

### 1️⃣ Démarrer la base de données
```bash
# Assurez-vous que MySQL est installé et en cours d'exécution
# Base de données: eventdb
# User: root
# Password: (vide)
```

### 2️⃣ Démarrer le backend
```bash
cd back-end
./start-with-seeder.sh
# ou
./mvnw spring-boot:run
```
✅ Backend accessible sur: http://localhost:8080

### 3️⃣ Démarrer le frontend
```bash
cd front-end
./start.sh
# ou
ng serve
```
✅ Frontend accessible sur: http://localhost:4200

---

## 🎯 Fonctionnalités

### Backend (Spring Boot)
- ✅ API REST complète
- ✅ Base de données MySQL
- ✅ CRUD pour Events, Categories, Locations, Users
- ✅ Recherche et filtrage
- ✅ Seeder de données
- ✅ CORS configuré

### Frontend (Angular)
- ✅ Liste des événements avec recherche
- ✅ Filtrage par catégorie
- ✅ Détails d'événement
- ✅ Création d'événement
- ✅ Design responsive
- ✅ Interface moderne

---

## 📚 Documentation

### Backend
- `back-end/API_DOCUMENTATION.md` - Documentation de l'API
- `back-end/DATABASE_SEEDING.md` - Guide du seeder
- `back-end/IMPLEMENTATION_COMPLETE.md` - Guide complet

### Frontend
- `front-end/README_MVP.md` - Guide de démarrage
- `front-end/MVP_COMPLETE.md` - Fonctionnalités complètes
- `front-end/TESTING_GUIDE.md` - Guide de tests
- `front-end/PROJET_FINAL.md` - Résumé final

---

## 🔧 Technologies utilisées

### Backend
- Spring Boot 3.x
- Spring Data JPA
- MySQL
- Maven

### Frontend
- Angular 20
- TypeScript
- RxJS
- Angular Router

---

## 📱 Captures d'écran

### Liste des événements
- Grille responsive
- Recherche en temps réel
- Filtres par catégorie

### Détails d'événement
- Affichage complet
- Informations de localisation
- Compteur de vues

### Création d'événement
- Formulaire validé
- Sélection catégorie/lieu
- Feedback utilisateur

---

## ✅ Statut du projet

**Backend:** ✅ Complet et fonctionnel  
**Frontend:** ✅ MVP complet et fonctionnel  
**Integration:** ✅ Backend et Frontend connectés  
**Documentation:** ✅ Complète

---

## 🆘 Troubleshooting

### Le backend ne démarre pas
- Vérifier que MySQL est en cours d'exécution
- Vérifier les credentials dans `application.properties`
- Vérifier que le port 8080 est libre

### Le frontend ne se connecte pas au backend
- Vérifier que le backend est démarré
- En Docker, l'URL est relative (`/api`). En dev local, configurez un proxy Angular si besoin (voir ci-dessous)
- Vérifier la console du navigateur pour les erreurs CORS

### Dev local Angular avec proxy `/api`

Créez `front-end/proxy.conf.json` (optionnel):

```json
{
	"/api": {
		"target": "http://localhost:8080",
		"secure": false,
		"changeOrigin": true,
		"logLevel": "debug"
	}
}
```

Puis démarrez:

```bash
cd front-end
npm run start:proxy
```

### Erreur de compilation
```bash
cd front-end
rm -rf node_modules package-lock.json
npm install
ng serve
```

---

## 🎓 Commandes utiles

### Backend
```bash
# Compiler
./mvnw clean install

# Démarrer
./mvnw spring-boot:run

# Tests
./mvnw test
```

### Frontend
```bash
# Installer les dépendances
npm install

# Développement
ng serve

# Build production
ng build

# Tests
ng test
```

---

## 👥 Pour les développeurs

### Ajouter un nouvel endpoint
1. Créer le modèle dans `back-end/src/main/java/.../model/`
2. Créer le repository dans `repository/`
3. Créer le service dans `service/`
4. Créer le controller dans `controller/`
5. Mettre à jour le frontend si nécessaire

### Ajouter un nouveau composant Angular
```bash
cd front-end
ng generate component components/mon-composant
```

### Ajouter un nouveau service Angular
```bash
cd front-end
ng generate service services/mon-service
```

---

## 📈 Prochaines étapes possibles

- [ ] Authentification JWT
- [ ] Gestion des favoris utilisateur
- [ ] Upload d'images
- [ ] Pagination
- [ ] Filtres avancés
- [ ] Carte interactive
- [ ] Notifications
- [ ] Tests E2E
- [ ] Déploiement (Docker)

---

## 📄 Licence

Ce projet a été créé à des fins éducatives.

---

## ✨ Remerciements

Projet EventApp - Full Stack Application  
Backend: Spring Boot + MySQL  
Frontend: Angular 20  

**Status: Production Ready ✅**

---

**Dernière mise à jour:** 2 novembre 2025

