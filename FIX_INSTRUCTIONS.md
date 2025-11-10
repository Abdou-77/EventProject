# 🔧 Fix Instructions - Profile & Favorites Features

## ⚠️ Issue
The backend User model was updated to include `role` and `bio` fields, but the database schema and Docker image need to be updated.

## ✅ Solution - Follow These Steps:

### 1. Make sure Docker Desktop is running
Open Docker Desktop and wait until it's fully started (green icon in menu bar).

### 2. Run the fix script

```bash
cd /Users/abdallahsofi/Downloads/EventProject
chmod +x fix-and-restart.sh
./fix-and-restart.sh
```

### 3. Alternative: Manual steps

If the script doesn't work, run these commands one by one:

```bash
# Stop containers
docker-compose down

# Start database only
docker-compose up -d db
sleep 5

# Update database schema
docker-compose exec db mysql -uroot -prootpassword eventdb < database/add_role_bio_fields.sql

# Rebuild backend
docker-compose build --no-cache backend

# Start all services
docker-compose up -d

# Check status
docker-compose ps
```

### 4. Verify it works

```bash
# Check if role and bio fields are returned
curl http://localhost:8000/api/users/1
```

You should see `"role":"ADMIN"` and `"bio":null` in the response.

## 📱 Test the New Features

1. **Login**: http://localhost:8000/login
   - Email: sophie.martin@email.fr
   - Password: password123

2. **Profile Page**: http://localhost:8000/profile
   - Should show user info with ADMIN badge
   - "Mes Favoris" button
   - "Déconnexion" button

3. **Favorites Page**: http://localhost:8000/favorites
   - Lists all favorite events
   - Click heart to remove from favorites

4. **Events List**: http://localhost:8000/events
   - Heart icon on each event card (visible when logged in)
   - Click to add/remove from favorites

5. **Admin Feature**: Check navbar dropdown
   - "Créer un événement" should be visible (ADMIN only)
   - Create a regular user to verify it's hidden for non-admins

## 🎯 What Was Added

### Backend Changes:
- ✅ Added `role` field to User model (USER/ADMIN/ORGANIZER)
- ✅ Added `bio` field to User model
- ✅ Database migration script created

### Frontend Changes:
- ✅ ProfileComponent created (shows user data)
- ✅ FavoritesComponent created (lists favorite events)
- ✅ Routes added for `/profile` and `/favorites`
- ✅ Navbar updated with admin check for "Créer un événement"
- ✅ Favorite toggle button on event cards
- ✅ User interface updated with role field

## 🐛 Troubleshooting

### If backend doesn't show role/bio:
```bash
# Rebuild backend without cache
docker-compose build --no-cache backend
docker-compose up -d
```

### If database changes didn't apply:
```bash
# Connect to database and run manually
docker-compose exec db mysql -uroot -prootpassword

USE eventdb;
ALTER TABLE users ADD COLUMN role VARCHAR(20) DEFAULT 'USER' AFTER password;
ALTER TABLE users ADD COLUMN bio TEXT AFTER role;
UPDATE users SET role = 'ADMIN' WHERE id = 1;
exit
```

### If profile/favorites pages show blank:
- Check browser console (F12) for errors
- Make sure you're logged in
- Clear browser cache and refresh

### If Docker commands don't work:
- Make sure Docker Desktop is running
- Try `docker compose` instead of `docker-compose`
- Restart your terminal to refresh PATH

## 📞 Need Help?

If issues persist, provide:
1. Output of `docker-compose ps`
2. Browser console errors (F12 → Console tab)
3. Which feature isn't working
