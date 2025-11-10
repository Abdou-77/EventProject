# 🎬 EventApp v3.0 - Cinematic Luxury Design System

## 🎨 Design Philosophy

**Inspiration**: Drake's OVO brand × Nike campaigns × Premium Festival Sites
**Mood**: Dark, Elegant, Immersive, Bold, Moody, Smooth
**Target**: Luxury event discovery platform for France

---

## 🌙 Color Palette

### Primary Colors
```css
/* Deep Blacks & Grays */
--noir-primary: #0A0A0A;
--noir-secondary: #1A1A1A;
--noir-tertiary: #2A2A2A;
--charcoal: #161616;

/* Gold Accents */
--gold-primary: #D4AF37;
--gold-light: #F4E4B7;
--gold-dark: #B8941F;
--champagne: #F7E7CE;

/* Violet Gradients */
--violet-deep: #2D1B4E;
--violet-mid: #4A2C6B;
--violet-light: #6B3FA0;
--violet-glow: #8B5FBF;

/* Accent Colors */
--neon-violet: #B794F6;
--midnight-blue: #0F0F23;
--smoke: rgba(255, 255, 255, 0.05);
```

### Gradients
```css
/* Signature Gradients */
--gradient-hero: linear-gradient(
  135deg,
  #0A0A0A 0%,
  #2D1B4E 50%,
  #1A1A1A 100%
);

--gradient-gold: linear-gradient(
  90deg,
  #B8941F 0%,
  #D4AF37 50%,
  #F4E4B7 100%
);

--gradient-violet: linear-gradient(
  180deg,
  rgba(45, 27, 78, 0.8) 0%,
  rgba(107, 63, 160, 0.4) 100%
);

--gradient-glow: radial-gradient(
  circle at center,
  rgba(183, 148, 246, 0.3) 0%,
  transparent 70%
);

/* Glassmorphism */
--glass-dark: rgba(26, 26, 26, 0.7);
--glass-violet: rgba(107, 63, 160, 0.15);
--glass-gold: rgba(212, 175, 55, 0.1);
```

---

## 📐 Typography System

### Font Families
```css
/* Editorial Headlines */
--font-display: 'Playfair Display', serif;

/* Modern Body */
--font-primary: 'Inter', -apple-system, sans-serif;

/* Accent Text */
--font-accent: 'Bodoni Moda', serif;

/* Mono Code */
--font-mono: 'JetBrains Mono', monospace;
```

### Type Scale
```css
/* Desktop */
--text-hero: 8rem;        /* 128px */
--text-display: 6rem;     /* 96px */
--text-h1: 4.5rem;        /* 72px */
--text-h2: 3.5rem;        /* 56px */
--text-h3: 2.5rem;        /* 40px */
--text-h4: 1.875rem;      /* 30px */
--text-body-xl: 1.5rem;   /* 24px */
--text-body-lg: 1.25rem;  /* 20px */
--text-body: 1rem;        /* 16px */
--text-small: 0.875rem;   /* 14px */
--text-tiny: 0.75rem;     /* 12px */

/* Mobile (scaled down 30%) */
--text-hero-mobile: 5.6rem;
--text-display-mobile: 4.2rem;
--text-h1-mobile: 3.15rem;
```

### Font Weights
```css
--weight-thin: 100;
--weight-light: 300;
--weight-regular: 400;
--weight-medium: 500;
--weight-semibold: 600;
--weight-bold: 700;
--weight-black: 900;
```

---

## 🎭 Visual Effects

### Glassmorphism
```css
.glass-card {
  background: rgba(26, 26, 26, 0.7);
  backdrop-filter: blur(20px) saturate(180%);
  -webkit-backdrop-filter: blur(20px) saturate(180%);
  border: 1px solid rgba(255, 255, 255, 0.1);
  box-shadow: 
    0 8px 32px 0 rgba(0, 0, 0, 0.37),
    inset 0 1px 1px 0 rgba(255, 255, 255, 0.05);
}
```

### Glow Effects
```css
.glow-gold {
  box-shadow: 
    0 0 20px rgba(212, 175, 55, 0.3),
    0 0 40px rgba(212, 175, 55, 0.2),
    0 0 60px rgba(212, 175, 55, 0.1);
}

.glow-violet {
  box-shadow: 
    0 0 30px rgba(183, 148, 246, 0.4),
    0 0 60px rgba(183, 148, 246, 0.2);
}

.text-glow-gold {
  text-shadow: 
    0 0 10px rgba(212, 175, 55, 0.8),
    0 0 20px rgba(212, 175, 55, 0.4);
}
```

### Animations
```css
/* Slow Fade In */
@keyframes cinematic-fade {
  from { 
    opacity: 0; 
    transform: translateY(40px);
  }
  to { 
    opacity: 1; 
    transform: translateY(0);
  }
}

/* Parallax Float */
@keyframes float-slow {
  0%, 100% { transform: translateY(0px); }
  50% { transform: translateY(-20px); }
}

/* Glow Pulse */
@keyframes glow-pulse {
  0%, 100% { opacity: 0.6; }
  50% { opacity: 1; }
}

/* Smooth Scale */
@keyframes scale-smooth {
  from { transform: scale(1); }
  to { transform: scale(1.05); }
}
```

---

## 📏 Spacing System

```css
--space-xs: 0.5rem;     /* 8px */
--space-sm: 1rem;       /* 16px */
--space-md: 1.5rem;     /* 24px */
--space-lg: 2rem;       /* 32px */
--space-xl: 3rem;       /* 48px */
--space-2xl: 4rem;      /* 64px */
--space-3xl: 6rem;      /* 96px */
--space-4xl: 8rem;      /* 128px */
--space-hero: 12rem;    /* 192px */
```

---

## 🎯 Component Styles

### Buttons
```css
/* Primary CTA */
.btn-gold {
  background: linear-gradient(90deg, #B8941F 0%, #D4AF37 100%);
  color: #0A0A0A;
  padding: 1.25rem 3rem;
  font-weight: 700;
  letter-spacing: 0.1em;
  text-transform: uppercase;
  border: none;
  cursor: pointer;
  transition: all 0.6s cubic-bezier(0.16, 1, 0.3, 1);
}

.btn-gold:hover {
  transform: translateY(-4px);
  box-shadow: 
    0 20px 40px rgba(212, 175, 55, 0.3),
    0 0 60px rgba(212, 175, 55, 0.2);
}

/* Ghost Button */
.btn-ghost {
  background: transparent;
  border: 2px solid rgba(212, 175, 55, 0.5);
  color: #D4AF37;
  padding: 1rem 2.5rem;
  backdrop-filter: blur(10px);
  transition: all 0.4s ease;
}

.btn-ghost:hover {
  background: rgba(212, 175, 55, 0.1);
  border-color: #D4AF37;
  box-shadow: 0 0 30px rgba(212, 175, 55, 0.3);
}
```

### Cards
```css
.event-card-luxury {
  position: relative;
  background: linear-gradient(
    135deg,
    rgba(26, 26, 26, 0.9) 0%,
    rgba(45, 27, 78, 0.6) 100%
  );
  backdrop-filter: blur(20px);
  border: 1px solid rgba(255, 255, 255, 0.05);
  border-radius: 24px;
  overflow: hidden;
  transition: all 0.6s cubic-bezier(0.16, 1, 0.3, 1);
}

.event-card-luxury:hover {
  transform: translateY(-12px) scale(1.02);
  border-color: rgba(212, 175, 55, 0.3);
  box-shadow: 
    0 30px 60px rgba(0, 0, 0, 0.5),
    0 0 80px rgba(183, 148, 246, 0.2);
}

.event-card-luxury::before {
  content: '';
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: radial-gradient(
    circle at top right,
    rgba(212, 175, 55, 0.1) 0%,
    transparent 60%
  );
  opacity: 0;
  transition: opacity 0.6s ease;
}

.event-card-luxury:hover::before {
  opacity: 1;
}
```

### Navigation
```css
.navbar-cinematic {
  position: fixed;
  top: 0;
  width: 100%;
  background: rgba(10, 10, 10, 0.8);
  backdrop-filter: blur(30px);
  border-bottom: 1px solid rgba(255, 255, 255, 0.05);
  z-index: 1000;
  transition: all 0.4s ease;
}

.navbar-cinematic.scrolled {
  background: rgba(10, 10, 10, 0.95);
  box-shadow: 0 10px 40px rgba(0, 0, 0, 0.5);
}
```

---

## 🖼️ Layout Components

### Hero Section
```css
.hero-cinematic {
  height: 100vh;
  position: relative;
  overflow: hidden;
  display: flex;
  align-items: center;
  justify-content: center;
}

.hero-bg {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  object-fit: cover;
  filter: brightness(0.4) contrast(1.2);
  transform: scale(1.1);
  animation: slow-zoom 20s ease infinite alternate;
}

@keyframes slow-zoom {
  from { transform: scale(1.1); }
  to { transform: scale(1.15); }
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
```

### Grid System
```css
.grid-luxury {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(400px, 1fr));
  gap: 3rem;
  padding: 4rem 0;
}

@media (max-width: 768px) {
  .grid-luxury {
    grid-template-columns: 1fr;
    gap: 2rem;
  }
}
```

---

## 🎬 Page Layouts

### 1. Home Page Structure
```
┌─────────────────────────────────────────┐
│  Navbar (fixed, glass)                  │
├─────────────────────────────────────────┤
│                                         │
│  Hero Section (full viewport)          │
│  - Large background image               │
│  - "DÉCOUVREZ L'ÉVÉNEMENT"             │
│  - Gold CTA button                      │
│  - Scroll indicator                     │
│                                         │
├─────────────────────────────────────────┤
│  Featured Events (parallax grid)        │
│  - 3 large cards                        │
│  - Glassmorphism + glow                 │
│                                         │
├─────────────────────────────────────────┤
│  Categories (horizontal scroll)         │
│  - Music, Art, Sport, etc.              │
│  - Gold accents                         │
│                                         │
├─────────────────────────────────────────┤
│  Upcoming Events (masonry grid)         │
│  - Mixed sizes                          │
│  - Hover effects                        │
│                                         │
├─────────────────────────────────────────┤
│  Footer (minimal, dark)                 │
└─────────────────────────────────────────┘
```

### 2. Explore Page Structure
```
┌─────────────────────────────────────────┐
│  Navbar                                 │
├─────────────────────────────────────────┤
│  Filter Bar (glass, sticky)             │
│  - Search, Category, Date, City         │
├─────────────────────────────────────────┤
│                                         │
│  Event Grid                             │
│  - Large cards                          │
│  - Infinite scroll                      │
│  - Smooth transitions                   │
│                                         │
└─────────────────────────────────────────┘
```

### 3. Event Detail Page Structure
```
┌─────────────────────────────────────────┐
│  Navbar (transparent)                   │
├─────────────────────────────────────────┤
│                                         │
│  Hero Image (parallax, full width)      │
│  - Gradient overlay                     │
│  - Event title (huge)                   │
│                                         │
├─────────────────────────────────────────┤
│  Content Section                        │
│  ├─ Left: Details (glass card)          │
│  │  - Date, time, location              │
│  │  - Price, category                   │
│  │  - Book button (gold)                │
│  │                                      │
│  └─ Right: Description                  │
│     - Editorial text                    │
│     - Gallery                           │
│                                         │
├─────────────────────────────────────────┤
│  Related Events (carousel)              │
└─────────────────────────────────────────┘
```

---

## 📱 Mobile Adaptations

### Breakpoints
```css
--mobile: 640px;
--tablet: 768px;
--desktop: 1024px;
--wide: 1280px;
--ultra-wide: 1536px;
```

### Mobile Specific
```css
@media (max-width: 768px) {
  /* Reduce hero text */
  --text-hero: 3.5rem;
  
  /* Stack navigation */
  .navbar-cinematic {
    padding: 1rem;
  }
  
  /* Single column grid */
  .grid-luxury {
    grid-template-columns: 1fr;
  }
  
  /* Larger tap targets */
  .btn-gold, .btn-ghost {
    padding: 1rem 2rem;
    font-size: 1rem;
  }
  
  /* Reduce glassmorphism blur (performance) */
  .glass-card {
    backdrop-filter: blur(10px);
  }
}
```

---

## ⚡ Performance Optimizations

```css
/* GPU Acceleration */
.accelerated {
  transform: translateZ(0);
  will-change: transform;
}

/* Smooth Scrolling */
html {
  scroll-behavior: smooth;
}

/* Reduce Motion for Accessibility */
@media (prefers-reduced-motion: reduce) {
  * {
    animation-duration: 0.01ms !important;
    animation-iteration-count: 1 !important;
    transition-duration: 0.01ms !important;
  }
}
```

---

## 🎨 Tailwind CSS Configuration

```javascript
// tailwind.config.js
module.exports = {
  theme: {
    extend: {
      colors: {
        'noir': {
          primary: '#0A0A0A',
          secondary: '#1A1A1A',
          tertiary: '#2A2A2A',
        },
        'gold': {
          primary: '#D4AF37',
          light: '#F4E4B7',
          dark: '#B8941F',
        },
        'violet': {
          deep: '#2D1B4E',
          mid: '#4A2C6B',
          light: '#6B3FA0',
          glow: '#8B5FBF',
        },
      },
      fontFamily: {
        'display': ['Playfair Display', 'serif'],
        'body': ['Inter', 'sans-serif'],
        'accent': ['Bodoni Moda', 'serif'],
      },
      backdropBlur: {
        'luxury': '30px',
      },
      animation: {
        'float-slow': 'float-slow 6s ease-in-out infinite',
        'glow-pulse': 'glow-pulse 3s ease-in-out infinite',
        'cinematic-fade': 'cinematic-fade 1s ease-out',
      },
    },
  },
}
```

---

## 📋 Component Checklist

### Navigation
- [ ] Fixed transparent navbar with glass
- [ ] Logo with gold accent
- [ ] Minimal menu items
- [ ] User avatar dropdown
- [ ] Mobile hamburger menu

### Buttons & CTAs
- [ ] Primary gold gradient button
- [ ] Ghost outlined button
- [ ] Icon buttons with glow
- [ ] Loading states with shimmer

### Cards
- [ ] Event card with glass
- [ ] Hover scale + glow
- [ ] Image with gradient overlay
- [ ] Badge for category

### Forms
- [ ] Glass input fields
- [ ] Gold focus states
- [ ] Validation with glow
- [ ] Animated labels

### Modals
- [ ] Full-screen dark overlay
- [ ] Glass centered content
- [ ] Smooth slide-in animation
- [ ] Close with fade-out

---

**Version**: 3.0 Cinematic  
**Design System**: Complete  
**Status**: Ready for implementation ✨

