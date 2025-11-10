import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { EventService } from '../../../services/event.service';
import { CategoryService } from '../../../services/category.service';
import { Event, Category } from '../../../models';
import { getEventPlaceholder, handleImageError } from '../../../utils/image-utils';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  featuredEvents: Event[] = [];
  categories: Category[] = [];
  upcomingEvents: Event[] = [];
  loading = true;
  
  get displayEvents(): Event[] {
    // Prefer upcoming events; fallback to featured events
    const base = this.upcomingEvents && this.upcomingEvents.length > 0
      ? this.upcomingEvents
      : this.featuredEvents;
    return base.slice(0, 9);
  }

  constructor(
    private eventService: EventService,
    private categoryService: CategoryService
  ) {}

  ngOnInit(): void {
    this.loadData();
  }

  private loadData(): void {
    this.loading = true;

    // Load featured events
    this.eventService.getFeaturedEvents().subscribe({
      next: (events: Event[]) => {
        this.featuredEvents = events.slice(0, 3);
      },
      error: (error: any) => console.error('Error loading featured events:', error)
    });

    // Load categories
    this.categoryService.getAllCategories().subscribe({
      next: (categories: Category[]) => {
        this.categories = categories.slice(0, 6);
      },
      error: (error: any) => console.error('Error loading categories:', error)
    });

    // Load upcoming events
    this.eventService.getUpcomingEvents(6).subscribe({
      next: (events: Event[]) => {
        this.upcomingEvents = events;
        this.loading = false;
      },
      error: (error: any) => {
        console.error('Error loading upcoming events:', error);
        this.loading = false;
      }
    });
  }

  formatDate(dateString: string): string {
    const date = new Date(dateString);
    return date.toLocaleDateString('fr-FR', {
      weekday: 'long',
      day: 'numeric',
      month: 'long'
    });
  }

  formatPrice(price: number): string {
    return new Intl.NumberFormat('fr-FR', {
      style: 'currency',
      currency: 'EUR'
    }).format(price);
  }

  getCategoryEmoji(categoryName: string): string {
    const emojiMap: { [key: string]: string } = {
      'Musique': '🎵',
      'Festival': '🎪',
      'Concert': '🎤',
      'Théâtre': '🎭',
      'Sport': '⚽',
      'Art': '🎨',
      'Danse': '💃',
      'Humour': '😂',
      'Cinéma': '🎬',
      'Exposition': '🖼️',
      'Conférence': '🎤',
      'Spectacle': '🎪'
    };

    return emojiMap[categoryName] || '🎉';
  }

  trackByEventId(index: number, item: Event): number {
    return item?.id ?? index;
  }

  getEventImage(event: Event): string {
    return event.imageUrl || getEventPlaceholder(event.category?.name);
  }

  onImageError(event: any, categoryName?: string): void {
    handleImageError(event, categoryName);
  }
}
