# 🎬 Guide d'implémentation - Design Cinématique v3.0

## 🚀 Plan d'action pour Angular

### Phase 1 : Configuration de base (30 min)

#### 1.1 Importer les polices Google Fonts
Mettre à jour `src/index.html` :
```html
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@400;500;600;700;900&family=Inter:wght@300;400;500;600;700;800&family=Bodoni+Moda:wght@400;500;600;700&display=swap" rel="stylesheet">
```

#### 1.2 Remplacer styles.css
```bash
# Sauvegarder l'ancien
mv src/styles.css src/styles-v2.css.bak

# Copier le nouveau
cp src/styles-cinematic.css src/styles.css
```

#### 1.3 Configuration Tailwind (optionnel)
Si vous voulez utiliser Tailwind avec le système de design :
```bash
npm install -D tailwindcss postcss autoprefixer
npx tailwindcss init
```

Puis configurer `tailwind.config.js` avec les couleurs custom.

---

### Phase 2 : Navbar Cinématique (45 min)

#### Mettre à jour `navbar.html`
```html
<nav class="navbar-cinematic" [class.scrolled]="isScrolled">
  <a routerLink="/" class="logo">
    Event<span class="text-gold">App</span>
  </a>
  
  <ul class="nav-menu">
    <li><a routerLink="/events" routerLinkActive="active">Explorer</a></li>
    <li *ngIf="currentUser"><a routerLink="/events/create">Créer</a></li>
  </ul>
  
  <div class="nav-actions">
    <div *ngIf="!currentUser" class="auth-buttons">
      <a routerLink="/login" class="btn-cinematic btn-ghost-sm">Connexion</a>
      <a routerLink="/signup" class="btn-cinematic btn-gold-sm">Inscription</a>
    </div>
    
    <div *ngIf="currentUser" class="user-menu-wrapper">
      <button (click)="toggleUserMenu()" class="user-button-luxury">
        <div class="user-avatar-gold">{{ currentUser.name.charAt(0) }}</div>
        <span class="user-name-luxury">{{ currentUser.name }}</span>
      </button>
      
      <div *ngIf="showUserMenu" class="dropdown-luxury glass">
        <a routerLink="/profile" class="dropdown-item-luxury">
          <span class="icon-gold">👤</span>
          Mon Profil
        </a>
        <button (click)="logout()" class="dropdown-item-luxury logout">
          <span class="icon-gold">🚪</span>
          Déconnexion
        </button>
      </div>
    </div>
  </div>
</nav>
```

#### Mettre à jour `navbar.ts`
```typescript
export class Navbar implements OnInit {
  // ...existing code...
  isScrolled = false;

  ngOnInit(): void {
    // ...existing code...
    this.setupScrollListener();
  }

  private setupScrollListener(): void {
    window.addEventListener('scroll', () => {
      this.isScrolled = window.scrollY > 100;
    });
  }
}
```

#### Ajouter `navbar-cinematic.css`
```css
.navbar-cinematic {
  position: fixed;
  top: 0;
  width: 100%;
  padding: 2rem 4rem;
  display: flex;
  justify-content: space-between;
  align-items: center;
  z-index: 1000;
  transition: all 0.4s ease;
}

.navbar-cinematic.scrolled {
  background: rgba(10, 10, 10, 0.95);
  backdrop-filter: blur(30px);
  padding: 1.5rem 4rem;
  border-bottom: 1px solid rgba(255, 255, 255, 0.05);
  box-shadow: 0 10px 40px rgba(0, 0, 0, 0.5);
}

.logo {
  font-family: var(--font-display);
  font-size: 1.5rem;
  font-weight: 700;
  color: #FFF;
  text-decoration: none;
  letter-spacing: -0.02em;
  transition: transform 0.3s ease;
}

.logo:hover {
  transform: scale(1.05);
}

.text-gold {
  color: var(--gold-primary);
}

.nav-menu {
  display: flex;
  gap: 3rem;
  list-style: none;
  margin: 0;
  padding: 0;
}

.nav-menu a {
  color: rgba(255, 255, 255, 0.8);
  text-decoration: none;
  font-weight: 500;
  font-size: 0.9rem;
  letter-spacing: 0.1em;
  text-transform: uppercase;
  transition: color 0.3s ease;
  position: relative;
}

.nav-menu a::after {
  content: '';
  position: absolute;
  bottom: -5px;
  left: 0;
  width: 0;
  height: 2px;
  background: var(--gradient-gold);
  transition: width 0.3s ease;
}

.nav-menu a:hover,
.nav-menu a.active {
  color: var(--gold-primary);
}

.nav-menu a:hover::after,
.nav-menu a.active::after {
  width: 100%;
}

.nav-actions {
  display: flex;
  align-items: center;
  gap: 1.5rem;
}

.auth-buttons {
  display: flex;
  gap: 1rem;
}

.btn-ghost-sm,
.btn-gold-sm {
  padding: 0.75rem 1.5rem;
  font-size: 0.85rem;
  letter-spacing: 0.08em;
  text-transform: uppercase;
  font-weight: 600;
  border-radius: 8px;
  transition: var(--transition-smooth);
}

.btn-ghost-sm {
  background: transparent;
  border: 2px solid rgba(212, 175, 55, 0.5);
  color: var(--gold-primary);
}

.btn-ghost-sm:hover {
  background: rgba(212, 175, 55, 0.1);
  border-color: var(--gold-primary);
  transform: translateY(-2px);
}

.btn-gold-sm {
  background: var(--gradient-gold);
  color: var(--noir-primary);
  border: none;
}

.btn-gold-sm:hover {
  transform: translateY(-2px);
  box-shadow: 0 10px 30px rgba(212, 175, 55, 0.4);
}

.user-button-luxury {
  display: flex;
  align-items: center;
  gap: 1rem;
  background: transparent;
  border: 2px solid rgba(212, 175, 55, 0.3);
  padding: 0.5rem 1.5rem 0.5rem 0.5rem;
  border-radius: 50px;
  cursor: pointer;
  transition: all 0.3s ease;
}

.user-button-luxury:hover {
  border-color: var(--gold-primary);
  background: rgba(212, 175, 55, 0.05);
}

.user-avatar-gold {
  width: 40px;
  height: 40px;
  border-radius: 50%;
  background: var(--gradient-gold);
  color: var(--noir-primary);
  display: flex;
  align-items: center;
  justify-content: center;
  font-weight: 700;
  font-size: 1.1rem;
}

.user-name-luxury {
  color: rgba(255, 255, 255, 0.9);
  font-weight: 500;
  font-size: 0.9rem;
}

.dropdown-luxury {
  position: absolute;
  top: calc(100% + 1rem);
  right: 0;
  min-width: 220px;
  border-radius: 16px;
  overflow: hidden;
  animation: cinematic-fade 0.3s ease-out;
}

.dropdown-item-luxury {
  display: flex;
  align-items: center;
  gap: 1rem;
  padding: 1rem 1.5rem;
  color: rgba(255, 255, 255, 0.9);
  text-decoration: none;
  border: none;
  background: none;
  width: 100%;
  text-align: left;
  cursor: pointer;
  transition: background 0.3s ease;
  font-weight: 500;
}

.dropdown-item-luxury:hover {
  background: rgba(212, 175, 55, 0.1);
}

.dropdown-item-luxury.logout {
  border-top: 1px solid rgba(255, 255, 255, 0.05);
  color: rgba(255, 100, 100, 0.9);
}

.icon-gold {
  font-size: 1.2rem;
  filter: drop-shadow(0 0 8px rgba(212, 175, 55, 0.5));
}

@media (max-width: 768px) {
  .navbar-cinematic {
    padding: 1.5rem 1.5rem;
  }
  
  .nav-menu {
    display: none;
  }
  
  .logo {
    font-size: 1.25rem;
  }
}
```

---

### Phase 3 : Page d'accueil Hero Section (1h)

#### Créer `home.component.ts`
```bash
ng generate component components/home --skip-tests
```

#### Mettre à jour `home.html`
```html
<section class="hero-cinematic">
  <img src="https://images.unsplash.com/photo-1540039155733-5bb30b53aa14?w=1920" 
       alt="Concert background" 
       class="hero-bg">
  <div class="hero-overlay"></div>
  
  <div class="hero-content cinematic-fade">
    <div class="hero-subtitle">Paris — Lyon — Marseille</div>
    <h1 class="text-hero hero-title text-glow-gold">
      DÉCOUVREZ<br>L'ÉVÉNEMENT
    </h1>
    <p class="hero-description">
      L'expérience ultime des événements live en France.
      Concerts, festivals, arts & culture.
    </p>
    <div class="hero-cta">
      <a routerLink="/events" class="btn-cinematic btn-gold">
        Explorer les événements
      </a>
      <a routerLink="/about" class="btn-cinematic btn-ghost">
        En savoir plus
      </a>
    </div>
  </div>
  
  <div class="scroll-indicator float-slow">
    Défiler pour découvrir
    <br>↓
  </div>
</section>

<!-- Featured Events -->
<section class="featured-section section-padding">
  <div class="section-header">
    <h2 class="section-title gradient-text">
      Événements à la Une
    </h2>
    <p class="section-subtitle text-editorial">
      Les expériences les plus attendues de la saison
    </p>
  </div>

  <div class="events-grid-luxury">
    <div *ngFor="let event of featuredEvents" 
         class="card-luxury event-card-cinematic"
         [routerLink]="['/events', event.id]">
      <div class="event-image-wrapper">
        <img [src]="event.imageUrl || 'https://images.unsplash.com/photo-1470229722913-7c0e2dbbafd3?w=800'" 
             [alt]="event.title" 
             class="event-image-cinematic">
        <div class="event-overlay-cinematic">
          <span class="event-category-badge">{{ event.category?.name }}</span>
          <h3 class="event-title-cinematic">{{ event.title }}</h3>
          <div class="event-meta-cinematic">
            <span>📅 {{ event.date }}</span>
            <span>📍 {{ event.location?.city }}</span>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
```

#### Ajouter les styles dans `home.css`
```css
.hero-cinematic {
  height: 100vh;
  position: relative;
  display: flex;
  align-items: center;
  justify-content: center;
  overflow: hidden;
}

.hero-bg {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  object-fit: cover;
  filter: brightness(0.3) contrast(1.2);
  animation: slow-zoom 20s ease infinite alternate;
}

.hero-overlay {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: linear-gradient(
    180deg,
    rgba(10, 10, 10, 0.3) 0%,
    rgba(45, 27, 78, 0.6) 50%,
    rgba(10, 10, 10, 0.9) 100%
  );
}

.hero-content {
  position: relative;
  z-index: 2;
  text-align: center;
  max-width: 1200px;
  padding: 0 2rem;
}

.hero-subtitle {
  font-family: var(--font-body);
  font-size: 1.25rem;
  letter-spacing: 0.3em;
  text-transform: uppercase;
  color: var(--gold-primary);
  margin-bottom: 2rem;
  opacity: 0.9;
}

.hero-title {
  margin-bottom: 2rem;
}

.hero-description {
  font-size: 1.5rem;
  color: rgba(255, 255, 255, 0.7);
  max-width: 700px;
  margin: 0 auto 3rem;
  line-height: 1.8;
}

.hero-cta {
  display: flex;
  gap: 1.5rem;
  justify-content: center;
  flex-wrap: wrap;
}

.scroll-indicator {
  position: absolute;
  bottom: 3rem;
  left: 50%;
  transform: translateX(-50%);
  color: rgba(255, 255, 255, 0.5);
  font-size: 0.875rem;
  letter-spacing: 0.2em;
  text-transform: uppercase;
  text-align: center;
}

.featured-section {
  background: linear-gradient(
    180deg,
    var(--noir-primary) 0%,
    var(--noir-secondary) 100%
  );
}

.section-header {
  text-align: center;
  margin-bottom: 5rem;
}

.section-title {
  font-size: clamp(2.5rem, 5vw, 4rem);
  margin-bottom: 1.5rem;
}

.section-subtitle {
  font-size: 1.25rem;
  color: rgba(255, 255, 255, 0.6);
  max-width: 600px;
  margin: 0 auto;
}

.events-grid-luxury {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(350px, 1fr));
  gap: 3rem;
  max-width: 1400px;
  margin: 0 auto;
}

.event-card-cinematic {
  height: 500px;
  cursor: pointer;
}

.event-image-wrapper {
  position: relative;
  width: 100%;
  height: 100%;
  border-radius: 24px;
  overflow: hidden;
}

.event-image-cinematic {
  width: 100%;
  height: 100%;
  object-fit: cover;
  transition: transform 0.6s ease;
}

.card-luxury:hover .event-image-cinematic {
  transform: scale(1.05);
}

.event-overlay-cinematic {
  position: absolute;
  bottom: 0;
  left: 0;
  right: 0;
  padding: 2rem;
  background: linear-gradient(
    to top,
    rgba(10, 10, 10, 0.95) 0%,
    transparent 100%
  );
}

.event-category-badge {
  display: inline-block;
  padding: 0.5rem 1rem;
  background: rgba(212, 175, 55, 0.2);
  color: var(--gold-primary);
  border-radius: 20px;
  font-size: 0.75rem;
  letter-spacing: 0.1em;
  text-transform: uppercase;
  margin-bottom: 1rem;
  backdrop-filter: blur(10px);
}

.event-title-cinematic {
  font-size: 1.75rem;
  margin-bottom: 0.5rem;
  color: #FFF;
  font-family: var(--font-display);
}

.event-meta-cinematic {
  display: flex;
  gap: 1.5rem;
  color: rgba(255, 255, 255, 0.6);
  font-size: 0.875rem;
}

@media (max-width: 768px) {
  .events-grid-luxury {
    grid-template-columns: 1fr;
    gap: 2rem;
  }
  
  .hero-description {
    font-size: 1.25rem;
  }
}
```

---

### Phase 4 : Liste des événements (45 min)

Mettre à jour `event-list.css` pour le style cinématique :

```css
/* Remplacer les couleurs existantes */
.container {
  background: var(--noir-primary);
  min-height: 100vh;
}

.header-top h1 {
  font-family: var(--font-display);
  background: var(--gradient-gold);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
}

.filters-card {
  background: var(--glass-dark);
  backdrop-filter: blur(20px);
  border: 1px solid rgba(255, 255, 255, 0.05);
  border-radius: 24px;
}

.filter-input,
.filter-select {
  background: rgba(26, 26, 26, 0.8);
  border: 1px solid rgba(255, 255, 255, 0.1);
  color: #FFF;
}

.filter-input:focus,
.filter-select:focus {
  border-color: var(--gold-primary);
  box-shadow: 0 0 20px rgba(212, 175, 55, 0.2);
}

.btn-clear {
  background: var(--gradient-gold);
  color: var(--noir-primary);
}

.event-card {
  /* Utiliser .card-luxury existant */
}
```

---

### Phase 5 : Pages d'authentification (30 min)

Mettre à jour `login.css` et `signup.css` :

```css
.auth-container {
  background: var(--noir-primary);
  min-height: 100vh;
}

.auth-card {
  background: var(--glass-dark);
  backdrop-filter: blur(30px);
  border: 1px solid rgba(255, 255, 255, 0.1);
  box-shadow: 0 30px 60px rgba(0, 0, 0, 0.5);
}

.auth-header h1 {
  font-family: var(--font-display);
  background: var(--gradient-gold);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
}

.form-input {
  background: rgba(26, 26, 26, 0.8);
  border: 1px solid rgba(255, 255, 255, 0.1);
  color: #FFF;
}

.form-input:focus {
  border-color: var(--gold-primary);
  box-shadow: 0 0 20px rgba(212, 175, 55, 0.2);
}

.btn-primary {
  background: var(--gradient-gold);
  color: var(--noir-primary);
}
```

---

## ✅ Checklist d'implémentation

- [ ] Importer les polices Google Fonts
- [ ] Remplacer styles.css par styles-cinematic.css
- [ ] Mettre à jour la navbar avec le design cinématique
- [ ] Créer le composant Home avec hero section
- [ ] Adapter event-list au design cinématique
- [ ] Mettre à jour les pages auth (login/signup)
- [ ] Tester le responsive mobile
- [ ] Optimiser les performances (lazy loading images)
- [ ] Ajouter les transitions et animations
- [ ] Tester l'accessibilité

---

## 🎯 Résultat attendu

Une application avec :
- ✨ Design luxueux noir/gold/violet
- 🎬 Animations cinématiques fluides
- 💎 Glassmorphism et effets de glow
- 📱 Responsive mobile optimisé
- ⚡ Performance maintenue
- 🎨 Cohérence visuelle totale

---

**Temps estimé total** : 3-4 heures  
**Niveau de difficulté** : Intermédiaire  
**Compatibilité** : Angular 20+, tous navigateurs modernes

