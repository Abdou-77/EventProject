# EventApp - Frontend Angular

Application Angular MVP pour gérer et afficher des événements.

## 🚀 Fonctionnalités

- **Liste des événements** : Affichage de tous les événements publiés
- **Recherche** : Rechercher des événements par titre
- **Filtrage** : Filtrer les événements par catégorie
- **Détails d'événement** : Voir tous les détails d'un événement
- **Création d'événement** : Formulaire pour créer de nouveaux événements
- **Design responsive** : Optimisé pour mobile et desktop

## 📋 Prérequis

- Node.js (v18+)
- Angular CLI (v20+)
- Back-end API fonctionnel sur `http://localhost:8080`

## 🛠️ Installation

1. Installer les dépendances :
```bash
npm install
```

## 🏃 Démarrage

Lancer le serveur de développement :
```bash
ng serve
```

L'application sera accessible sur `http://localhost:4200`

## 📁 Structure du projet

```
src/app/
├── components/
│   ├── navbar/           # Barre de navigation
│   ├── event-list/       # Liste des événements
│   ├── event-detail/     # Détails d'un événement
│   └── event-form/       # Formulaire de création
├── services/
│   ├── event.service.ts      # Service pour les événements
│   ├── category.service.ts   # Service pour les catégories
│   └── location.service.ts   # Service pour les localisations
├── models/
│   └── event.model.ts    # Interfaces TypeScript
└── app.routes.ts         # Configuration des routes
```

## 🌐 Routes

- `/` - Redirection vers /events
- `/events` - Liste de tous les événements
- `/events/create` - Formulaire de création d'événement
- `/events/:id` - Détails d'un événement spécifique

## 🔌 API

L'application se connecte au back-end sur `http://localhost:8080/api`

Endpoints utilisés :
- `GET /events` - Liste des événements
- `GET /events/{id}` - Détail d'un événement
- `GET /events/published` - Événements publiés
- `POST /events` - Créer un événement
- `GET /categories` - Liste des catégories
- `GET /locations` - Liste des localisations

## 🎨 Technologies

- **Angular 20** - Framework principal
- **TypeScript** - Langage de programmation
- **RxJS** - Gestion asynchrone
- **HttpClient** - Communication avec l'API
- **Router** - Navigation
- **FormsModule** - Gestion des formulaires

## 🔧 Build

Pour créer une version de production :
```bash
ng build
```

Les fichiers de build seront dans le dossier `dist/`.

## 📝 Notes

- Assurez-vous que le back-end est démarré avant de lancer l'application
- Le CORS est configuré sur le back-end pour accepter les requêtes depuis `http://localhost:4200`

