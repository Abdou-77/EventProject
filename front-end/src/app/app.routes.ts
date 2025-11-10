import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home/home.component';
import { EventsListComponent } from './components/events/events-list/events-list.component';
import { EventDetailComponent } from './components/events/event-detail/event-detail.component';
<<<<<<< Updated upstream
import { Login } from './components/auth/login/login';
import { Signup } from './components/auth/signup/signup';
import { MapsComponent } from './components/maps/maps.component';
import { AboutComponent } from './components/about/about.component';
=======
import { LoginComponent } from './components/auth/login/login.component';
import { SignupComponent } from './components/auth/signup/signup.component';
import { ProfileComponent } from './components/user/profile/profile.component';
import { FavoritesComponent } from './components/user/favorites/favorites.component';
>>>>>>> Stashed changes

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'events', component: EventsListComponent },
  { path: 'events/:id', component: EventDetailComponent },
  { path: 'maps', component: MapsComponent },
  { path: 'about', component: AboutComponent },
  { path: 'categories', redirectTo: 'events', pathMatch: 'full' },
<<<<<<< Updated upstream
  { path: 'profile', redirectTo: '', pathMatch: 'full' },
  { path: 'favorites', redirectTo: '', pathMatch: 'full' },
  { path: 'login', component: Login },
  { path: 'signup', component: Signup },
=======
  { path: 'about', redirectTo: '', pathMatch: 'full' },
  { path: 'profile', component: ProfileComponent },
  { path: 'favorites', component: FavoritesComponent },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
>>>>>>> Stashed changes
  { path: '**', redirectTo: '', pathMatch: 'full' }
];
