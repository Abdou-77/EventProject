# 🌱 Database Seeding - French Events Data

## 📊 Overview

Le fichier `DataSeeder.java` peuple automatiquement la base de données avec des données réalistes d'événements en France.

---

## 🎯 Données Créées

### 📁 **8 Catégories**
- 🎵 Musique
- 🎭 Théâtre
- ⚽ Sport
- 🎨 Art & Exposition
- 🎪 Festival
- 🍷 Gastronomie
- 🎬 Cinéma
- 📚 Conférence

### 📍 **11 Lieux en France**
- **Paris** : Stade de France, Accor Arena, Philharmonie, Musée du Louvre, Parc des Princes
- **Lyon** : Halle Tony Garnier, Musée des Confluences
- **Marseille** : Stade Vélodrome, Le Dôme
- **Bordeaux** : Matmut Atlantique
- **Nice** : Allianz Riviera

### 🎪 **36 Événements Réalistes**
1. **Concert de David Guetta** - Accor Arena Paris (75€)
2. **Festival Jazz à Vienne 2025** - Philharmonie Paris (55€)
3. **Concert Symphonique** - Orchestre de Paris (45€)
4. **PSG vs OM** - Le Classique au Parc des Princes (120€)
5. **Finale Top 14 Rugby** - Stade de France (95€)
6. **Roland-Garros Finale** - Paris (250€)
7. **Tour de France Arrivée** - Champs-Élysées (Gratuit)
8. **Marathon de Paris** - Paris (120€)
9. **Le Misanthrope** - Comédie Française (38€)
10. **Cyrano de Bergerac** - Paris (42€)
11. **Les Liaisons Dangereuses** - Paris (55€)
12. **Roméo et Juliette Ballet** - Opéra de Paris (78€)
13. **Exposition Monet** - Musée du Louvre (18€)
14. **Van Gogh Immersif** - Paris (24€)
15. **Picasso et les Maîtres** - Paris (16€)
16. **Trésors de l'Égypte Antique** - Lyon (22€)
17. **Les Nuits de Fourvière** - Lyon (42€)
18. **Festival d'Avignon** - Lyon area (38€)
19. **Nuit Blanche Paris** - Paris (Gratuit)
20. **Fête de la Musique** - Paris (Gratuit)
21. **Fête des Lumières Lyon** - Lyon (Gratuit)
22. **Festival Électro Lyon** - Lyon (45€)
23. **Salon du Chocolat** - Paris (15€)
24. **Bordeaux Fête le Vin** - Bordeaux (25€)
25. **Bocuse d'Or Finale** - Lyon (150€)
26. **Foire aux Vins Colmar** - Paris area (10€)
27. **Festival de Cannes** - Nice (50€)
28. **Festival Lumière Lyon** - Lyon (28€)
29. **Nuit des Oscars** - Paris (35€)
30. **TedX Paris** - Innovation & Futur (35€)
31. **Salon du Livre de Paris** - Paris (12€)
32. **VivaTech Paris 2025** - Stade de France (99€)
33. **Stromae - Tournée Multitude** - Marseille (85€)
34. **Christine and the Queens** - Lyon (68€)
35. **Daft Punk Tribute** - Paris (90€)
36. **... et plus encore !**

### 👥 **5 Utilisateurs de Test**
- Sophie Martin (Paris)
- Thomas Dubois (Paris)
- Marie Lambert (Lyon)
- Pierre Rousseau (Marseille)
- Emma Leroy (Bordeaux)

---

## 🚀 Utilisation

### Démarrage Automatique

Le seeder s'exécute **automatiquement** au démarrage de l'application :

```bash
mvn spring-boot:run
```

Vous verrez dans la console :
```
🌱 Starting database seeding with French events data...
✅ Created 8 categories
✅ Created 11 locations
✅ Created 16 events
✅ Created 5 users
🎉 Database seeding completed successfully!
```

### Vérification Anti-Doublon

Le seeder vérifie si des données existent déjà :
```
✅ Database already populated. Skipping seed.
```

---

## 🔧 Configuration

### Désactiver le Seeding

Si vous voulez désactiver le seeding automatique, commentez l'annotation `@Component` :

```java
// @Component  // <- Commentez cette ligne
public class DataSeeder implements CommandLineRunner {
```

### Réinitialiser la Base de Données

Pour réexécuter le seeder, supprimez d'abord les données :

```sql
-- Dans votre client SQL
DELETE FROM events;
DELETE FROM categories;
DELETE FROM locations;
DELETE FROM users;
```

Ou via Spring Boot :
```properties
# application.properties
spring.jpa.hibernate.ddl-auto=create-drop  # ⚠️ Attention : supprime tout au démarrage
```

---

## 📡 Tester les Données

### Vérifier les Catégories
```bash
curl http://localhost:8080/api/categories
```

### Voir Tous les Événements
```bash
curl http://localhost:8080/api/events
```

### Événements par Catégorie (Musique)
```bash
curl http://localhost:8080/api/events/category/1
```

### Événements par Ville
```bash
curl http://localhost:8080/api/locations/city/Paris
```

### Rechercher un Événement
```bash
curl "http://localhost:8080/api/events/search?title=concert"
```

### Événements Publiés
```bash
curl http://localhost:8080/api/events/published
```

---

## 🎨 Personnalisation

### Ajouter Plus d'Événements

Éditez la méthode `createEvents()` dans `DataSeeder.java` :

```java
events.add(createEvent(
    "Votre Titre",
    "Votre Description",
    LocalDate.of(2025, 12, 31),
    LocalTime.of(20, 0),
    new BigDecimal("50.00"),
    "https://image-url.com",
    "https://ticket-link.com",
    categoryId,
    locationId,
    true,  // published
    0      // viewCount
));
```

### Ajouter de Nouvelles Villes

```java
locations.add(createLocation(
    "Nom du Lieu",
    "Adresse",
    "Ville",
    new BigDecimal("latitude"),
    new BigDecimal("longitude")
));
```

---

## 📊 Structure des Données

### Event
- ✅ Titre et description en français
- ✅ Dates futures (2025-2026)
- ✅ Prix réalistes (0€ - 120€)
- ✅ Images Unsplash
- ✅ Liens vers sites officiels
- ✅ Compteur de vues
- ✅ Status publié

### Location
- ✅ Lieux réels en France
- ✅ Adresses complètes
- ✅ Coordonnées GPS exactes
- ✅ Grandes villes : Paris, Lyon, Marseille, Bordeaux, Nice

### User
- ✅ Noms français réalistes
- ✅ Emails valides
- ✅ Avatars (pravatar.cc)
- ✅ Associés à des villes

---

## ⚠️ Notes Importantes

1. **Mots de passe** : Les mots de passe sont en clair ("password123"). En production, utilisez BCrypt !

2. **Images** : Les URLs Unsplash sont des exemples. Remplacez par vos propres images.

3. **Données de test** : Ces données sont pour le développement uniquement.

4. **Performance** : Le seeding prend ~2-3 secondes avec 16 événements.

---

## 🎉 Résultat Final

Après le seeding, votre base de données contiendra :

```
📦 Base de données peuplée :
   ├── 8 Catégories
   ├── 11 Lieux
   ├── 36 Événements
   └── 5 Utilisateurs

🌍 Couverture géographique :
   ├── Paris (6 lieux)
   ├── Lyon (2 lieux)
   ├── Marseille (2 lieux)
   ├── Bordeaux (1 lieu)
   └── Nice (1 lieu)

💰 Gamme de prix : 0€ (gratuit) à 250€
📅 Dates : 2025 - 2026
👁️ Total vues simulées : 100,000+
✨ Types : Musique, Sport, Théâtre, Art, Festivals, Gastronomie, Cinéma, Conférences
```

---

## 📚 Ressources

- [Spring Boot CommandLineRunner](https://spring.io/guides/gs/accessing-data-jpa/)
- [JPA Repository](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)

---

Généré le : 2 novembre 2025  
Auteur : Event Management System Team

