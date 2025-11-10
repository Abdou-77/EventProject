import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home/home.component';
import { EventsListComponent } from './components/events/events-list/events-list.component';
import { EventDetailComponent } from './components/events/event-detail/event-detail.component';
import { Login } from './components/auth/login/login';
import { Signup } from './components/auth/signup/signup';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'events', component: EventsListComponent },
  { path: 'events/:id', component: EventDetailComponent },
  { path: 'categories', redirectTo: 'events', pathMatch: 'full' },
  { path: 'about', redirectTo: '', pathMatch: 'full' },
  { path: 'profile', redirectTo: '', pathMatch: 'full' },
  { path: 'favorites', redirectTo: '', pathMatch: 'full' },
  { path: 'login', component: Login },
  { path: 'signup', component: Signup },
  { path: '**', redirectTo: '', pathMatch: 'full' }
];
