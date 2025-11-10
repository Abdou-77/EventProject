# 🏆 LUXURY EVENT PLATFORM - COMPLETE REDESIGN

## Inspired by: Drake Related & NOCTA

---

## 🎨 Design Philosophy

### **Minimal. Bold. Immersive.**

This is a complete ground-up redesign inspired by world-class luxury brands:
- **Drake Related**: Full-screen immersive experiences, room-based navigation
- **NOCTA**: Minimal aesthetic, premium typography, smooth interactions

---

## 🎯 Key Features

### 1. **Full-Screen Video Hero**
- Autoplay background video (you'll upload)
- Cinematic dark overlay
- Large display typography (Bebas Neue)
- Smooth fade-in animations
- Floating scroll indicator

### 2. **Minimal Luxury Navigation**
- Transparent floating navbar
- Becomes solid on scroll
- Uppercase minimal links
- Mobile fullscreen overlay menu
- Smooth transitions

### 3. **Custom Cursor**
- Interactive cursor that follows mouse
- Grows on hover
- Mix-blend-mode for luxury effect
- Hidden on mobile

### 4. **Masonry Events Grid**
- Large format photography
- Varying card sizes (8-col, 4-col, 6-col spans)
- Hover reveals content
- Smooth image zoom
- Gold accent highlights

### 5. **Premium Typography**
- **Display**: Bebas Neue (uppercase, bold, large)
- **Body**: Space Grotesk (clean, modern)
- **Accent**: Montserrat (uppercase labels)

### 6. **Monochrome Palette**
- Black (#000000) - Primary background
- Charcoal (#0a0a0a) - Cards
- White (#ffffff) - Text
- Gold (#d4af37) - Accents only

---

## 📁 Files Created

### **Design System**
```
/front-end/src/styles-luxury.css
```
- Complete luxury design tokens
- Custom cursor
- Smooth animations
- Utility classes
- Typography system

### **Navbar Component**
```
/front-end/src/app/components/shared/navbar/navbar-luxury.component.css
```
- Floating transparent navbar
- Minimal desktop menu
- Fullscreen mobile overlay
- Smooth scroll detection

### **Hero Section**
```
/front-end/src/app/components/home/home/hero-luxury.component.css
```
- Full-screen video background
- Cinematic overlays
- Large display typography
- Call-to-action buttons
- Scroll indicator

### **Events Section**
```
/front-end/src/app/components/events/events-luxury.component.css
```
- Masonry grid layout
- Large format cards
- Hover reveal interactions
- Category badges
- Meta information

---

## 🚀 Implementation Guide

### Step 1: Update Global Styles
Replace `styles.css` import in `angular.json`:
```json
"styles": [
  "src/styles-luxury.css"  // Changed from styles.css
]
```

### Step 2: Update Navbar Component

**HTML Template** (`navbar.component.html`):
```html
<nav class="luxury-nav" [class.scrolled]="isScrolled">
  <div class="container nav-container">
    <!-- Logo -->
    <a routerLink="/" class="nav-logo">EVENTX</a>
    
    <!-- Desktop Menu -->
    <ul class="nav-menu">
      <li><a routerLink="/events" class="nav-link">Events</a></li>
      <li><a routerLink="/experiences" class="nav-link">Experiences</a></li>
      <li><a routerLink="/about" class="nav-link">About</a></li>
      <li><a routerLink="/contact" class="nav-link">Contact</a></li>
    </ul>
    
    <!-- CTA -->
    <a routerLink="/register" class="btn nav-cta">Get Started</a>
    
    <!-- Mobile Toggle -->
    <button class="nav-toggle" [class.active]="mobileMenuOpen" (click)="toggleMobile()">
      <span></span>
      <span></span>
      <span></span>
    </button>
  </div>
  
  <!-- Mobile Overlay -->
  <div class="nav-mobile-overlay" [class.active]="mobileMenuOpen">
    <nav class="nav-mobile-menu">
      <a routerLink="/events" class="nav-mobile-link" (click)="closeMobile()">Events</a>
      <a routerLink="/experiences" class="nav-mobile-link" (click)="closeMobile()">Experiences</a>
      <a routerLink="/about" class="nav-mobile-link" (click)="closeMobile()">About</a>
      <a routerLink="/contact" class="nav-mobile-link" (click)="closeMobile()">Contact</a>
    </nav>
  </div>
</nav>
```

**TypeScript** (`navbar.component.ts`):
```typescript
import { Component, HostListener } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar-luxury.component.css']
})
export class NavbarComponent {
  isScrolled = false;
  mobileMenuOpen = false;

  @HostListener('window:scroll')
  onWindowScroll() {
    this.isScrolled = window.pageYOffset > 50;
  }

  toggleMobile() {
    this.mobileMenuOpen = !this.mobileMenuOpen;
  }

  closeMobile() {
    this.mobileMenuOpen = false;
  }
}
```

### Step 3: Create Hero Component

**HTML Template** (`home.component.html`):
```html
<section class="luxury-hero">
  <!-- Video Background -->
  <div class="hero-video-container">
    <video 
      class="hero-video" 
      autoplay 
      muted 
      loop 
      playsinline
      poster="/assets/videos/hero-poster.jpg">
      <source src="/assets/videos/hero-video.mp4" type="video/mp4">
      <source src="/assets/videos/hero-video.webm" type="video/webm">
    </video>
  </div>
  
  <!-- Dark Overlay -->
  <div class="hero-overlay"></div>
  
  <!-- Content -->
  <div class="hero-content">
    <p class="hero-subtitle">Exclusive Events</p>
    <h1 class="hero-title">
      Experience<br>
      <span class="highlight">Unforgettable</span><br>
      Moments
    </h1>
    <p class="hero-description">
      Discover curated events and experiences that redefine luxury entertainment.
      From intimate gatherings to grand celebrations.
    </p>
    <div class="hero-actions">
      <a routerLink="/events" class="btn hero-btn hero-btn-primary">
        Explore Events
      </a>
      <a routerLink="/about" class="btn hero-btn hero-btn-secondary">
        Learn More
      </a>
    </div>
  </div>
  
  <!-- Scroll Indicator -->
  <div class="hero-scroll">
    <p class="scroll-text">Scroll</p>
    <div class="scroll-line"></div>
  </div>
</section>
```

### Step 4: Update Events Section

**HTML Template** (`events-list.component.html`):
```html
<section class="luxury-events">
  <div class="container">
    <!-- Header -->
    <div class="section-header">
      <p class="section-eyebrow">Featured</p>
      <h2 class="section-title">Upcoming Events</h2>
      <p class="section-description">
        Handpicked experiences designed for those who appreciate the finer things
      </p>
    </div>
    
    <!-- Events Grid -->
    <div class="events-grid">
      <!-- Large Card -->
      <article class="event-card event-card-large">
        <div class="event-image-container">
          <img src="/assets/events/event-1.jpg" alt="Event" class="event-image">
          <div class="event-overlay"></div>
        </div>
        <div class="event-content">
          <span class="event-category">Music</span>
          <h3 class="event-title">Summer Jazz Night</h3>
          <div class="event-meta">
            <span class="event-meta-item">
              <svg><!-- Calendar icon --></svg>
              Jun 15, 2025
            </span>
            <span class="event-meta-item">
              <svg><!-- Location icon --></svg>
              New York
            </span>
          </div>
          <p class="event-description">
            An intimate evening featuring world-renowned jazz musicians
          </p>
          <a href="#" class="event-action">
            View Details
            <svg><!-- Arrow icon --></svg>
          </a>
        </div>
      </article>
      
      <!-- Medium Cards -->
      <article class="event-card event-card-medium">
        <!-- Same structure -->
      </article>
      
      <!-- Small Cards -->
      <article class="event-card event-card-small">
        <!-- Same structure -->
      </article>
    </div>
    
    <!-- View All -->
    <div class="view-all-container">
      <a routerLink="/events" class="btn view-all-btn">View All Events</a>
    </div>
  </div>
</section>
```

### Step 5: Add Custom Cursor

**In `app.component.html`** (root):
```html
<!-- Custom Cursor -->
<div class="cursor" #cursor></div>

<router-outlet></router-outlet>
```

**In `app.component.ts`**:
```typescript
import { Component, ElementRef, ViewChild, AfterViewInit, HostListener } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements AfterViewInit {
  @ViewChild('cursor') cursor!: ElementRef;
  
  ngAfterViewInit() {
    // Cursor will be initialized
  }
  
  @HostListener('document:mousemove', ['$event'])
  onMouseMove(event: MouseEvent) {
    if (this.cursor) {
      const x = event.clientX;
      const y = event.clientY;
      this.cursor.nativeElement.style.left = `${x}px`;
      this.cursor.nativeElement.style.top = `${y}px`;
    }
  }
  
  @HostListener('document:mouseenter', ['$event'])
  onMouseEnter(event: MouseEvent) {
    const target = event.target as HTMLElement;
    if (target.tagName === 'A' || target.tagName === 'BUTTON') {
      this.cursor.nativeElement.classList.add('hover');
    }
  }
  
  @HostListener('document:mouseleave', ['$event'])
  onMouseLeave() {
    this.cursor.nativeElement.classList.remove('hover');
  }
}
```

---

## 📹 Video Requirements

### Upload these videos to `/assets/videos/`:

1. **hero-video.mp4** (Main hero background)
   - Resolution: 1920x1080 or higher
   - Duration: 10-30 seconds (loops)
   - Style: Cinematic, slow-motion, events/experiences
   - Examples: Crowd reactions, venue shots, atmospheric b-roll

2. **hero-video.webm** (Backup format)
   - Same content, optimized for web

3. **hero-poster.jpg** (Fallback image)
   - High-quality still from video
   - Shows while video loads

### Video Optimization:
- Compress to < 5MB if possible
- Use H.264 codec for MP4
- 30fps is fine
- Mute audio track

---

## 🎨 Design Specifications

### Colors
```css
Primary Background: #000000 (Pure Black)
Cards: #0a0a0a (Charcoal)
Text: #ffffff (White)
Secondary Text: #a0a0a0 (Light Gray)
Accent: #d4af37 (Gold)
```

### Typography
```css
Display Headings: Bebas Neue, 64-160px, Uppercase
Body Text: Space Grotesk, 14-18px, Normal
Labels: Montserrat, 10-14px, Uppercase, Letter-spacing
```

### Spacing
```css
Section Padding: 128px vertical
Card Gaps: 24-32px
Content Padding: 32-64px
Button Padding: 16px 48px
```

### Animations
```css
Transitions: 0.6-1s cubic-bezier(0.4, 0, 0.2, 1)
Hover Lift: translateY(-12px)
Image Zoom: scale(1.08)
Fade Duration: 1s
```

---

## 🖼️ Image Requirements

### Event Images:
- **Minimum**: 1920x1280px (3:2 ratio)
- **Format**: JPEG or WebP
- **Quality**: High (80-90%)
- **Style**: Professional, high-contrast, dramatic lighting

### Hero Images:
- **Minimum**: 2560x1440px (16:9)
- **Style**: Cinematic, dark, atmospheric

---

## ✨ Interactions

### Hover Effects:
- ✅ Cards lift on hover (-12px)
- ✅ Images zoom smoothly (1.08x)
- ✅ Text reveals fade in
- ✅ Category badges fill with gold
- ✅ Custom cursor grows
- ✅ Buttons fill with color

### Scroll Effects:
- ✅ Navbar becomes solid
- ✅ Fade-in animations trigger
- ✅ Parallax on hero video

### Mobile:
- ✅ Fullscreen menu overlay
- ✅ Large touch targets
- ✅ Swipe gestures ready
- ✅ No custom cursor

---

## 🚦 Next Steps

### Immediate:
1. ✅ Upload hero video to `/assets/videos/`
2. ✅ Upload logo to `/assets/images/`
3. ✅ Update `angular.json` to use new styles
4. ✅ Update navbar component HTML/TS
5. ✅ Update home component with hero

### Phase 2:
6. Create event detail page (full-screen gallery)
7. Add filtering/sorting to events
8. Create about page
9. Add contact form
10. Implement authentication (minimal modals)

### Phase 3:
11. Add page transitions
12. Implement scroll animations library
13. Add loading states
14. Performance optimization
15. SEO optimization

---

## 🎯 Performance Targets

- First Contentful Paint: < 1.5s
- Largest Contentful Paint: < 2.5s
- Time to Interactive: < 3.5s
- Lighthouse Score: > 90

---

## 📱 Browser Support

- Chrome/Edge: Latest 2 versions
- Firefox: Latest 2 versions
- Safari: Latest 2 versions
- Mobile Safari: iOS 14+
- Chrome Mobile: Latest

---

## 🏆 Design References

### Inspiration Sites:
1. **Drake Related**: https://drakerelated.com/rooms/front
   - Immersive room experiences
   - Full-screen visuals
   - Minimal UI

2. **NOCTA**: https://www.nocta.com/en-fr
   - Clean minimal aesthetic
   - Large typography
   - Grid layouts

3. **Apple**: https://www.apple.com
   - Product storytelling
   - Smooth animations
   - Premium feel

---

**This is a complete luxury redesign. Professional. Minimal. Bold.**

Ready to compete with million-dollar brands. 🚀
