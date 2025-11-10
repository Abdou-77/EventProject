# EventApp

Application full-stack de gestion d'événements culturels et sportifs.

## Technologies

- Frontend: Angular 20, TypeScript, Nginx
- Backend: Spring Boot 3, Java 21, JPA/Hibernate
- Database: MySQL 8.4
- DevOps: Docker & Docker Compose

## Installation

```bash
docker compose up -d
```

L'application sera accessible sur http://localhost:8000

## Comptes de test

- **Admin**: Admin@eventapp.fr / pass123

## Fonctionnalités

### Utilisateurs
- Catalogue d'événements avec filtres (catégorie, ville, date, prix)
- Système de favoris
- Gestion de profil
- Liens vers billetteries externes

### Administrateurs
- Création et modification d'événements
- Suppression d'événements avec confirmation
- Statistiques (vues, favoris)
- Gestion des images

## Base de données

La base de données est automatiquement peuplée au premier démarrage avec:
- 8 catégories (Musique, Théâtre, Sport, Art, Festival, etc.)
- 11 lieux (Paris, Lyon, Marseille, Bordeaux, Nice)
- 36 événements
- 7 utilisateurs (1 admin + 6 utilisateurs)

Pour réinitialiser:
```bash
docker compose down -v
docker compose up -d
```

## API Endpoints

### Événements
- `GET /api/events` - Liste des événements
- `POST /api/events` - Créer un événement (Admin)
- `PUT /api/events/{id}` - Modifier un événement (Admin)
- `DELETE /api/events/{id}` - Supprimer un événement (Admin)

### Favoris
- `GET /api/favorites/user/{id}` - Favoris d'un utilisateur
- `POST /api/favorites/toggle` - Ajouter/Retirer un favori

### Authentification
- `POST /api/auth/signup` - Inscription
- `POST /api/auth/login` - Connexion

### Métadonnées
- `GET /api/categories` - Liste des catégories
- `GET /api/locations` - Liste des villes

## Commandes

```bash
# Démarrer
docker compose up -d

# Arrêter
docker compose down

# Réinitialiser
docker compose down -v

# Voir les logs
docker compose logs -f
```

## Auteur

Abdellah Sofi - Ali Fassy Fehry
- Projet académique 2025 -
