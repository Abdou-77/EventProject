# Comptes Administrateurs

## Compte Admin Principal

- **Email**: `Admin@eventapp.fr`
- **Mot de passe**: `pass123`
- **Rôle**: ADMIN
- **ID**: 8
- **Créé le**: 10 novembre 2025

## Compte Test Utilisateur

- **Email**: `sofiabdou2017@gmail.com`
- **Mot de passe**: `Abdou123`
- **Rôle**: USER
- **ID**: 7
- **Créé le**: 10 novembre 2025

---

## Privilèges Admin

Les utilisateurs avec le rôle `ADMIN` ont accès à:
- ✅ Bouton "Créer un événement" dans le menu
- ✅ Badge "ADMIN" sur leur profil
- ✅ Toutes les fonctionnalités utilisateur standard

## Connexion

Pour se connecter, allez sur:
```
http://localhost:8000/login
```

Utilisez l'un des emails et mots de passe ci-dessus.

## Base de données

Les utilisateurs sont stockés dans la table `users` avec:
- `role` VARCHAR(20) DEFAULT 'USER'
- Valeurs possibles: 'USER', 'ADMIN', 'ORGANIZER'

## Hasher un nouveau mot de passe

Si vous devez créer un nouveau compte avec un mot de passe hashé, utilisez BCrypt avec strength 10:

```bash
# Exemple de hash BCrypt pour "pass123"
$2a$10$N9qo8uLOickgx2ZMRZoMye1lXzWNsHILHNLOIJXJo3qLlLWBKYCdC
```

## Modifier le rôle d'un utilisateur

```sql
UPDATE users SET role = 'ADMIN' WHERE email = 'email@example.com';
```
