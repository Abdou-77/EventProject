# Guide de test de l'application EventApp

## 🧪 Tests manuels à effectuer

### 1. Test de la liste des événements
**URL:** `http://localhost:4200/events`

**À tester:**
- [ ] La page charge correctement
- [ ] Les événements s'affichent en grille
- [ ] Les images sont affichées (ou placeholder si non disponible)
- [ ] Les badges de catégorie et localisation sont visibles
- [ ] Le design est responsive (tester sur mobile/tablette)

### 2. Test de la recherche
**Page:** Liste des événements

**À tester:**
- [ ] Entrer un terme de recherche dans la barre
- [ ] Appuyer sur Entrée ou cliquer sur "Rechercher"
- [ ] Vérifier que les résultats sont filtrés
- [ ] Effacer la recherche avec le bouton "Effacer les filtres"

### 3. Test du filtrage par catégorie
**Page:** Liste des événements

**À tester:**
- [ ] Sélectionner une catégorie dans le menu déroulant
- [ ] Vérifier que seuls les événements de cette catégorie s'affichent
- [ ] Revenir à "Toutes les catégories"
- [ ] Utiliser le bouton "Effacer les filtres"

### 4. Test des détails d'événement
**URL:** `http://localhost:4200/events/1` (remplacer 1 par un ID valide)

**À tester:**
- [ ] La page de détails se charge
- [ ] Toutes les informations sont affichées:
  - Titre
  - Description
  - Date et heure
  - Prix
  - Catégorie
  - Lieu complet
- [ ] Le bouton "Retour" fonctionne
- [ ] Le compteur de vues s'incrémente
- [ ] Le lien externe s'ouvre dans un nouvel onglet (si disponible)

### 5. Test de création d'événement
**URL:** `http://localhost:4200/events/create`

**À tester:**
- [ ] Le formulaire s'affiche correctement
- [ ] Tous les champs sont présents
- [ ] Les listes déroulantes se remplissent avec les données du backend
- [ ] Validation du champ obligatoire "Titre"
- [ ] Créer un événement avec données minimales (juste le titre)
- [ ] Créer un événement avec toutes les données
- [ ] Vérifier le message de succès
- [ ] Vérifier la redirection vers la page de détails
- [ ] Tester le bouton "Réinitialiser"

### 6. Test de la navigation
**À tester:**
- [ ] Cliquer sur le logo "EventApp" → retour à la liste
- [ ] Cliquer sur "Événements" dans la navbar
- [ ] Cliquer sur "Créer un événement" dans la navbar
- [ ] Les liens actifs sont surlignés
- [ ] La navigation fonctionne sur mobile (menu responsive)

### 7. Test de la gestion d'erreur
**À tester:**
- [ ] Arrêter le backend
- [ ] Recharger la page de liste → vérifier le message d'erreur dans la console
- [ ] Essayer de créer un événement → vérifier le message d'erreur
- [ ] Redémarrer le backend
- [ ] Vérifier que l'application fonctionne à nouveau

### 8. Test responsive
**À tester sur différentes tailles:**
- [ ] Desktop (> 1200px) → Grille à 3-4 colonnes
- [ ] Tablette (768px - 1200px) → Grille à 2 colonnes
- [ ] Mobile (< 768px) → Grille à 1 colonne
- [ ] La navbar s'adapte sur mobile
- [ ] Les formulaires sont utilisables sur mobile
- [ ] Les boutons sont facilement cliquables

## 🔍 Points de vérification technique

### Console du navigateur
- [ ] Aucune erreur JavaScript
- [ ] Les requêtes API réussissent (200)
- [ ] Pas d'erreurs CORS

### Performance
- [ ] Le chargement initial est rapide
- [ ] Les transitions sont fluides
- [ ] Pas de latence perceptible sur les interactions

### Données
- [ ] Les événements publiés uniquement sont affichés
- [ ] Les dates sont formatées correctement
- [ ] Les prix s'affichent avec le symbole €
- [ ] Les images placeholder fonctionnent si pas d'image

## 📝 Cas de test avec données

### Créer un événement test
```
Titre: Concert Jazz au Parc
Description: Soirée jazz en plein air avec des artistes locaux
Date: 2025-12-15
Heure: 20:00
Prix: 25
Image URL: https://picsum.photos/400/300
Lien: https://example.com/concert-jazz
Catégorie: Musique
Lieu: Parc Central
Publié: Oui
```

### Rechercher
- Terme: "Jazz" → devrait trouver l'événement créé
- Terme: "XYZ123" → devrait retourner "Aucun événement trouvé"

### Filtrer
- Par catégorie "Musique" → devrait inclure le concert
- Par catégorie "Sport" → ne devrait pas inclure le concert

## ✅ Checklist finale

Avant de considérer le MVP complet:
- [ ] Tous les composants se chargent sans erreur
- [ ] Toutes les routes fonctionnent
- [ ] Les appels API réussissent
- [ ] Le formulaire de création fonctionne
- [ ] La recherche fonctionne
- [ ] Le filtrage fonctionne
- [ ] Le design est propre et professionnel
- [ ] L'application est responsive
- [ ] Pas d'erreurs dans la console
- [ ] Le backend et le frontend communiquent correctement

## 🐛 Problèmes connus potentiels

1. **CORS**: Si erreur CORS, vérifier que le backend a `@CrossOrigin(origins = "*")`
2. **Port**: S'assurer que le backend est sur 8080 et frontend sur 4200
3. **Données vides**: Vérifier que le backend a des données (utiliser le seeder)
4. **Images**: Les URLs d'images externes peuvent ne pas charger

## 💡 Conseils

- Utiliser les DevTools du navigateur (F12) pour déboguer
- Vérifier l'onglet Network pour les appels API
- Utiliser `ng serve --open` pour ouvrir automatiquement le navigateur
- Utiliser le hot-reload: les changements de code sont automatiques

