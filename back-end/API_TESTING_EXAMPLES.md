# 📡 API Testing Examples - French Events Data

Après avoir démarré l'application avec `mvn spring-boot:run`, testez ces endpoints :

---

## 🎯 Test Basiques

### 1. Voir toutes les catégories
```bash
curl http://localhost:8080/api/categories
```

**Réponse attendue :** 8 catégories (Musique, Théâtre, Sport, etc.)

---

### 2. Voir tous les événements
```bash
curl http://localhost:8080/api/events
```

**Réponse attendue :** 36 événements en France

---

### 3. Voir tous les lieux
```bash
curl http://localhost:8080/api/locations
```

**Réponse attendue :** 11 lieux (Paris, Lyon, Marseille, etc.)

---

## 🔍 Recherches & Filtres

### 4. Événements par catégorie (Musique = ID 1)
```bash
curl http://localhost:8080/api/events/category/1
```

**Résultat :** Concerts de David Guetta, Stromae, Jazz, etc.

---

### 5. Événements par ville (Paris)
```bash
curl "http://localhost:8080/api/locations/city/Paris"
```

**Résultat :** 6 lieux à Paris

---

### 6. Rechercher un événement par titre
```bash
curl "http://localhost:8080/api/events/search?title=concert"
```

**Résultat :** Tous les concerts

---

### 7. Rechercher "chocolat"
```bash
curl "http://localhost:8080/api/events/search?title=chocolat"
```

**Résultat :** Salon du Chocolat Paris

---

### 8. Événements publiés uniquement
```bash
curl http://localhost:8080/api/events/published
```

**Résultat :** Tous les 36 événements (tous sont publiés)

---

### 9. Événement spécifique (ID 1 = David Guetta)
```bash
curl http://localhost:8080/api/events/1
```

---

### 10. Catégorie par nom
```bash
curl http://localhost:8080/api/categories/name/Musique
```

---

## 📊 Statistiques

### 11. Compter les vues d'un événement
```bash
curl http://localhost:8080/api/event-views/event/1/count
```

---

## 👥 Utilisateurs

### 12. Voir tous les utilisateurs
```bash
curl http://localhost:8080/api/users
```

**Résultat :** 5 utilisateurs français

---

### 13. Utilisateur par email
```bash
curl http://localhost:8080/api/users/email/sophie.martin@email.fr
```

---

## ✏️ Créer des Données (POST)

### 14. Créer un nouvel événement
```bash
curl -X POST http://localhost:8080/api/events \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Concert Test",
    "description": "Mon événement de test",
    "date": "2025-12-31",
    "time": "20:00:00",
    "price": 50.00,
    "categoryId": 1,
    "locationId": 1,
    "published": true
  }'
```

---

### 15. Créer une nouvelle catégorie
```bash
curl -X POST http://localhost:8080/api/categories \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Danse",
    "iconUrl": "💃"
  }'
```

---

### 16. Ajouter un favori
```bash
curl -X POST http://localhost:8080/api/favorites \
  -H "Content-Type: application/json" \
  -d '{
    "userId": 1,
    "eventId": 1
  }'
```

---

## 🔄 Modifier des Données (PUT)

### 17. Modifier un événement
```bash
curl -X PUT http://localhost:8080/api/events/1 \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Concert David Guetta - COMPLET",
    "description": "Événement complet!",
    "date": "2025-12-15",
    "time": "20:30:00",
    "price": 75.00,
    "categoryId": 1,
    "locationId": 2,
    "published": true
  }'
```

---

## 🗑️ Supprimer des Données (DELETE)

### 18. Supprimer un événement
```bash
curl -X DELETE http://localhost:8080/api/events/16
```

---

### 19. Supprimer un favori
```bash
curl -X DELETE http://localhost:8080/api/favorites/user/1/event/1
```

---

## 📅 Filtres Avancés

### 20. Événements par date
```bash
curl http://localhost:8080/api/events/date/2025-12-15
```

---

### 21. Événements par lieu (Accor Arena = ID 2)
```bash
curl http://localhost:8080/api/events/location/2
```

---

## 🔔 Notifications

### 22. Notifications non lues d'un utilisateur
```bash
curl http://localhost:8080/api/notifications/user/1/unseen
```

---

### 23. Compter les notifications non lues
```bash
curl http://localhost:8080/api/notifications/user/1/unseen/count
```

---

## 📈 Analytics

### 24. Incrémenter le compteur de vues
```bash
curl -X POST http://localhost:8080/api/events/1/view
```

---

### 25. Voir l'historique des vues d'un utilisateur
```bash
curl http://localhost:8080/api/event-views/user/1/recent
```

---

## 🎯 Cas d'Usage Réels

### Scénario 1 : Rechercher des concerts à Paris

```bash
# 1. Trouver Paris dans les locations
curl "http://localhost:8080/api/locations/city/Paris"

# 2. Prendre l'ID d'un lieu (ex: Accor Arena = 2)
curl http://localhost:8080/api/events/location/2

# 3. Filtrer par catégorie Musique (ID 1)
curl http://localhost:8080/api/events/category/1
```

---

### Scénario 2 : Événements gratuits

```bash
# Récupérer tous les événements et filtrer price = 0
curl http://localhost:8080/api/events | jq '.[] | select(.price == 0)'
```

---

### Scénario 3 : Top événements par vues

```bash
# Récupérer et trier par viewCount
curl http://localhost:8080/api/events | jq 'sort_by(.viewCount) | reverse | .[0:5]'
```

---

## 🛠️ Outils Recommandés

### Postman
1. Créer une nouvelle collection "French Events API"
2. Importer ces exemples
3. Configurer l'environnement : `baseUrl = http://localhost:8080`

### Insomnia
1. Créer un nouveau workspace
2. Ajouter les requêtes une par une
3. Organiser par dossiers (Events, Categories, etc.)

### HTTPie (Alternative à curl)
```bash
# Installation
brew install httpie

# Utilisation
http GET localhost:8080/api/events
http POST localhost:8080/api/categories name=Danse iconUrl=💃
```

---

## 📊 Vérification des Données

### Compter les enregistrements
```bash
echo "Categories:" && curl -s http://localhost:8080/api/categories | jq 'length'
echo "Locations:" && curl -s http://localhost:8080/api/locations | jq 'length'
echo "Events:" && curl -s http://localhost:8080/api/events | jq 'length'
echo "Users:" && curl -s http://localhost:8080/api/users | jq 'length'
```

**Résultat attendu :**
```
Categories: 8
Locations: 11
Events: 36
Users: 5
```

---

## 🎉 Données Complètes

**Total d'objets créés :** 60
- 8 Catégories
- 11 Lieux
- 36 Événements
- 5 Utilisateurs

**Couverture géographique :** 5 villes françaises  
**Prix min/max :** 0€ (gratuit) - 120€  
**Période :** 2025-2026  
**Total vues simulées :** ~29,000

---

Généré le : 2 novembre 2025  
Pour : Event Management System API

