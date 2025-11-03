import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { EventService } from '../../services/event.service';
import { CategoryService } from '../../services/category.service';
import { Event, Category } from '../../models/event.model';

@Component({
  selector: 'app-event-list',
  standalone: true,
  imports: [CommonModule, RouterModule, FormsModule],
  templateUrl: './event-list.html',
  styleUrl: './event-list.css',
})
export class EventList implements OnInit {
  events: Event[] = [];
  categories: Category[] = [];
  filteredEvents: Event[] = [];
  searchTerm: string = '';
  selectedCategoryId: number | null = null;
  loading: boolean = false;

  constructor(
    private eventService: EventService,
    private categoryService: CategoryService
  ) {}

  ngOnInit(): void {
    this.loadEvents();
    this.loadCategories();
  }

  loadEvents(): void {
    this.loading = true;
    this.eventService.getPublishedEvents().subscribe({
      next: (data) => {
        this.events = data;
        this.filteredEvents = data;
        this.loading = false;
      },
      error: (error) => {
        console.error('Error loading events:', error);
        this.loading = false;
      }
    });
  }

  loadCategories(): void {
    this.categoryService.getAllCategories().subscribe({
      next: (data) => {
        this.categories = data;
      },
      error: (error) => {
        console.error('Error loading categories:', error);
      }
    });
  }

  onSearch(): void {
    if (this.searchTerm.trim()) {
      this.eventService.searchEvents(this.searchTerm).subscribe({
        next: (data) => {
          this.filteredEvents = data;
        },
        error: (error) => {
          console.error('Error searching events:', error);
        }
      });
    } else {
      this.filteredEvents = this.events;
    }
  }

  filterByCategory(categoryId: number | null): void {
    this.selectedCategoryId = categoryId;
    if (categoryId) {
      this.eventService.getEventsByCategory(categoryId).subscribe({
        next: (data) => {
          this.filteredEvents = data;
        },
        error: (error) => {
          console.error('Error filtering events:', error);
        }
      });
    } else {
      this.loadEvents();
    }
  }

  clearFilters(): void {
    this.searchTerm = '';
    this.selectedCategoryId = null;
    this.loadEvents();
  }
}
