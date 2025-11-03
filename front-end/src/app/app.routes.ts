import { Routes } from '@angular/router';
import { EventList } from './components/event-list/event-list';
import { EventDetail } from './components/event-detail/event-detail';
import { EventForm } from './components/event-form/event-form';

export const routes: Routes = [
  { path: '', redirectTo: '/events', pathMatch: 'full' },
  { path: 'events', component: EventList },
  { path: 'events/create', component: EventForm },
  { path: 'events/:id', component: EventDetail },
];
