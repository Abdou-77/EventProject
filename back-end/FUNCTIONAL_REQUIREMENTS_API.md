# 🎯 API Endpoints - Fonctionnalités Complètes pour le Cahier des Charges

## ✅ Votre Cahier des Charges Implémenté

Ce document liste tous les endpoints nécessaires pour répondre à **100%** de vos besoins fonctionnels.

---

## 📍 **PARTIE PUBLIQUE - Recherche d'Événements**

### 🔍 **1. Recherche par Ville**

#### Obtenir toutes les villes disponibles
```bash
GET /api/locations/cities
```
**Réponse :** `["Paris", "Lyon", "Marseille", "Bordeaux", "Nice"]`

#### Événements d'une ville spécifique (publiés et triés par date)
```bash
GET /api/events/city/{locationId}
```
**Exemple :**
```bash
curl http://localhost:8080/api/events/city/1
```

#### Événements par nom de ville
```bash
GET /api/locations/city/{cityName}
```
**Exemple :**
```bash
curl http://localhost:8080/api/locations/city/Paris
```

---

### 📅 **2. Recherche par Période**

#### Événements de ce week-end
```bash
GET /api/events/this-weekend
```
**Retourne :** Événements du samedi et dimanche actuels

#### Événements de la semaine prochaine
```bash
GET /api/events/next-week
```
**Retourne :** Événements du lundi au dimanche de la semaine prochaine

#### Événements par période personnalisée
```bash
GET /api/events/period?startDate=2025-12-01&endDate=2025-12-31
```
**Exemple :**
```bash
curl "http://localhost:8080/api/events/period?startDate=2025-12-01&endDate=2025-12-31"
```

#### Tous les événements à venir (triés par date)
```bash
GET /api/events/upcoming
```

---

### 🎭 **3. Recherche par Catégorie**

#### Événements d'une catégorie (publiés et triés par date)
```bash
GET /api/events/category/{categoryId}
```
**Exemple :**
```bash
curl http://localhost:8080/api/events/category/1
```

#### Toutes les catégories disponibles
```bash
GET /api/categories
```

---

### 🔀 **4. Recherches Combinées**

#### Ville + Catégorie
```bash
GET /api/events/city/{locationId}/category/{categoryId}
```
**Exemple :** Concerts à Paris
```bash
curl http://localhost:8080/api/events/city/1/category/1
```

#### Ville + Période
```bash
GET /api/events/city/{locationId}/period?startDate=2025-12-01&endDate=2025-12-31
```
**Exemple :** Événements à Lyon en décembre
```bash
curl "http://localhost:8080/api/events/city/6/period?startDate=2025-12-01&endDate=2025-12-31"
```

#### Catégorie + Période
```bash
GET /api/events/category/{categoryId}/period?startDate=2025-12-01&endDate=2025-12-31
```
**Exemple :** Concerts en décembre
```bash
curl "http://localhost:8080/api/events/category/1/period?startDate=2025-12-01&endDate=2025-12-31"
```

---

### 📝 **5. Recherche par Texte**

```bash
GET /api/events/search?title={keyword}
```
**Exemple :**
```bash
curl "http://localhost:8080/api/events/search?title=concert"
```

---

### 📄 **6. Fiche Détaillée d'un Événement**

```bash
GET /api/events/{id}
```
**Retourne :** Tous les détails (titre, description, date, heure, lieu, prix, image, lien)

**Exemple :**
```bash
curl http://localhost:8080/api/events/1
```

#### Incrémenter le compteur de vues
```bash
POST /api/events/{id}/view
```
**Usage :** À appeler quand l'utilisateur ouvre la fiche détaillée

---

### 🌟 **7. Événements Populaires**

```bash
GET /api/events/popular
```
**Retourne :** Top 10 des événements les plus consultés

---

### 💡 **8. Recommandations (Événements Similaires)**

```bash
GET /api/events/{id}/recommendations
```
**Retourne :** 5 événements de la même catégorie (excluant l'événement actuel)

**Exemple :**
```bash
curl http://localhost:8080/api/events/1/recommendations
```

---

## ⭐ **FONCTIONNALITÉS BONUS - Favoris**

### Ajouter aux favoris
```bash
POST /api/favorites
Content-Type: application/json

{
  "userId": 1,
  "eventId": 5
}
```

### Voir les favoris d'un utilisateur
```bash
GET /api/favorites/user/{userId}
```

### Supprimer un favori
```bash
DELETE /api/favorites/user/{userId}/event/{eventId}
```

### Vérifier si un événement est en favori
```bash
GET /api/favorites/exists?userId=1&eventId=5
```

---

## 🔐 **PARTIE ADMIN - Gestion des Événements**

### Créer un événement
```bash
POST /api/events
Content-Type: application/json

{
  "title": "Concert Jazz",
  "description": "Soirée jazz exceptionnelle",
  "date": "2025-12-15",
  "time": "20:30:00",
  "price": 45.00,
  "imageUrl": "https://...",
  "link": "https://...",
  "categoryId": 1,
  "locationId": 2,
  "published": true
}
```

### Modifier un événement
```bash
PUT /api/events/{id}
Content-Type: application/json

{...}
```

### Supprimer un événement
```bash
DELETE /api/events/{id}
```

### Publier/Masquer un événement
Modifier le champ `"published": true/false` via PUT

---

### Gestion des Lieux

#### Créer un lieu
```bash
POST /api/locations
Content-Type: application/json

{
  "name": "Zénith de Paris",
  "address": "211 Avenue Jean Jaurès",
  "city": "Paris",
  "latitude": 48.8938,
  "longitude": 2.3936
}
```

#### Modifier/Supprimer
```bash
PUT /api/locations/{id}
DELETE /api/locations/{id}
```

---

### Gestion des Catégories

#### Créer une catégorie
```bash
POST /api/categories
Content-Type: application/json

{
  "name": "Rock",
  "iconUrl": "🎸"
}
```

#### Modifier/Supprimer
```bash
PUT /api/categories/{id}
DELETE /api/categories/{id}
```

---

## 🗺️ **FONCTIONNALITÉ CARTE INTERACTIVE**

### Obtenir tous les événements avec coordonnées GPS
```bash
GET /api/events/upcoming
```
Chaque événement a une `locationId` → récupérer les coordonnées via :
```bash
GET /api/locations/{locationId}
```
Retourne : `latitude`, `longitude`

**Usage Frontend :**
1. Récupérer les événements
2. Pour chaque événement, récupérer le lieu associé
3. Afficher sur une carte (Google Maps, Leaflet, Mapbox)

---

## 📊 **EXEMPLES D'UTILISATION PRATIQUES**

### Scénario 1 : "Je veux voir des concerts à Paris ce week-end"

```bash
# 1. Obtenir l'ID de Paris
curl http://localhost:8080/api/locations/city/Paris
# → locationId = 1

# 2. Obtenir les concerts (categoryId = 1) à Paris ce week-end
# Option A : This weekend
curl http://localhost:8080/api/events/this-weekend | jq '.[] | select(.locationId == 1 and .categoryId == 1)'

# Option B : Combiné ville + catégorie
curl http://localhost:8080/api/events/city/1/category/1
```

---

### Scénario 2 : "Quels sont les événements populaires en France ?"

```bash
curl http://localhost:8080/api/events/popular
```

---

### Scénario 3 : "Je veux voir tous les événements de décembre à Lyon"

```bash
# 1. Trouver l'ID de Lyon
curl http://localhost:8080/api/locations/city/Lyon
# → locationId = 6

# 2. Événements de décembre à Lyon
curl "http://localhost:8080/api/events/city/6/period?startDate=2025-12-01&endDate=2025-12-31"
```

---

### Scénario 4 : "Recommandations similaires à un événement"

```bash
# Utilisateur regarde "Concert David Guetta" (ID = 1)
# Afficher des événements similaires (même catégorie)
curl http://localhost:8080/api/events/1/recommendations
```

---

## 🎯 **RÉSUMÉ DES ENDPOINTS PAR FONCTIONNALITÉ**

### Recherche d'événements : **11 endpoints**
- ✅ Par ville
- ✅ Par période (ce week-end, semaine prochaine, personnalisée)
- ✅ Par catégorie
- ✅ Combinaisons (ville + catégorie, ville + période, etc.)
- ✅ Recherche textuelle
- ✅ Événements à venir
- ✅ Événements populaires

### Détails et interactions : **3 endpoints**
- ✅ Fiche détaillée
- ✅ Recommandations
- ✅ Incrémenter vues

### Favoris : **4 endpoints**
- ✅ Ajouter/Supprimer
- ✅ Liste des favoris
- ✅ Vérifier existence

### Administration : **15 endpoints**
- ✅ CRUD événements
- ✅ CRUD lieux
- ✅ CRUD catégories

### Utilitaires : **2 endpoints**
- ✅ Liste des villes
- ✅ Liste des catégories

---

## 📚 **TOTAL : 35+ ENDPOINTS FONCTIONNELS**

✅ Toutes les fonctionnalités de votre cahier des charges sont implémentées !

---

## 🧪 **TEST RAPIDE**

```bash
# Démarrer le serveur
mvn spring-boot:run

# Tester quelques endpoints
curl http://localhost:8080/api/events/upcoming
curl http://localhost:8080/api/events/this-weekend
curl http://localhost:8080/api/events/popular
curl http://localhost:8080/api/locations/cities
curl "http://localhost:8080/api/events/search?title=concert"
```

---

## 🎉 **PRÊT POUR LE DÉVELOPPEMENT FRONTEND !**

Vous avez maintenant une API REST complète qui couvre :
- ✅ Recherche par ville, date, catégorie
- ✅ Filtres combinés
- ✅ Événements populaires
- ✅ Recommandations
- ✅ Gestion des favoris
- ✅ Administration complète
- ✅ Support carte interactive (coordonnées GPS)

**L'API est prête pour votre frontend ! 🚀**

---

Généré le : 2 novembre 2025  
Événements en base : 36  
Villes : 5 (Paris, Lyon, Marseille, Bordeaux, Nice)  
Catégories : 8

