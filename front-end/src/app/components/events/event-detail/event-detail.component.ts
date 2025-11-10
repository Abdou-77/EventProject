import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { EventService } from '../../../services/event.service';
import { Event } from '../../../models';

@Component({
  selector: 'app-event-detail',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './event-detail.component.html',
  styleUrl: './event-detail.component.css'
})
export class EventDetailComponent implements OnInit {
  event: Event | null = null;
  loading = true;
  error = false;
  recommendedEvents: Event[] = [];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private eventService: EventService
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      const id = +params['id'];
      if (id) {
        this.loadEvent(id);
      }
    });
  }

  private loadEvent(id: number): void {
    this.loading = true;
    this.error = false;

    this.eventService.getEventById(id).subscribe({
      next: (event: Event) => {
        this.event = event;
        this.loading = false;
        
        // Increment view count
        this.eventService.incrementViewCount(id).subscribe();
        
        // Load recommended events
        if (event.categoryId) {
          this.eventService.getEventsByCategory(event.categoryId).subscribe({
            next: (events: Event[]) => {
              this.recommendedEvents = events
                .filter(e => e.id !== id)
                .slice(0, 3);
            }
          });
        }
      },
      error: () => {
        this.loading = false;
        this.error = true;
      }
    });
  }

  formatDate(dateString: string): string {
    const date = new Date(dateString);
    return date.toLocaleDateString('fr-FR', {
      weekday: 'long',
      day: 'numeric',
      month: 'long',
      year: 'numeric'
    });
  }

  formatPrice(price: number): string {
    if (price === 0) return 'Gratuit';
    return new Intl.NumberFormat('fr-FR', {
      style: 'currency',
      currency: 'EUR'
    }).format(price);
  }

  goToEvents(): void {
    this.router.navigate(['/events']);
  }

  shareEvent(): void {
    if (navigator.share && this.event) {
      navigator.share({
        title: this.event.title,
        text: this.event.description,
        url: window.location.href
      }).catch(() => {
        // Fallback: copy to clipboard
        this.copyToClipboard(window.location.href);
      });
    } else {
      this.copyToClipboard(window.location.href);
    }
  }

  private copyToClipboard(text: string): void {
    navigator.clipboard.writeText(text).then(() => {
      alert('Lien copié dans le presse-papiers!');
    });
  }

  buyTicket(): void {
    if (this.event?.link) {
      window.open(this.event.link, '_blank');
    }
  }
}
