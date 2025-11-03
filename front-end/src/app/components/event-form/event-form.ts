import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { EventService } from '../../services/event.service';
import { CategoryService } from '../../services/category.service';
import { LocationService } from '../../services/location.service';
import { Event, Category, EventLocation } from '../../models/event.model';

@Component({
  selector: 'app-event-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './event-form.html',
  styleUrl: './event-form.css',
})
export class EventForm implements OnInit {
  event: Event = {
    title: '',
    description: '',
    date: '',
    time: '',
    price: 0,
    imageUrl: '',
    link: '',
    categoryId: undefined,
    locationId: undefined,
    published: true
  };

  categories: Category[] = [];
  locations: EventLocation[] = [];
  loading: boolean = false;
  error: string | null = null;
  success: boolean = false;

  constructor(
    private eventService: EventService,
    private categoryService: CategoryService,
    private locationService: LocationService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadCategories();
    this.loadLocations();
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

  loadLocations(): void {
    this.locationService.getAllLocations().subscribe({
      next: (data) => {
        this.locations = data;
      },
      error: (error) => {
        console.error('Error loading locations:', error);
      }
    });
  }

  onSubmit(): void {
    this.loading = true;
    this.error = null;

    this.eventService.createEvent(this.event).subscribe({
      next: (data) => {
        this.success = true;
        this.loading = false;
        setTimeout(() => {
          this.router.navigate(['/events', data.id]);
        }, 1500);
      },
      error: (error) => {
        console.error('Error creating event:', error);
        this.error = 'Erreur lors de la création de l\'événement.';
        this.loading = false;
      }
    });
  }

  resetForm(): void {
    this.event = {
      title: '',
      description: '',
      date: '',
      time: '',
      price: 0,
      imageUrl: '',
      link: '',
      categoryId: undefined,
      locationId: undefined,
      published: true
    };
    this.error = null;
    this.success = false;
  }
}
