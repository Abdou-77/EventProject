import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { EventLocation } from '../models/event.model';

@Injectable({
  providedIn: 'root'
})
export class LocationService {
  private apiUrl = 'http://localhost:8080/api/locations';

  constructor(private http: HttpClient) { }

  getAllLocations(): Observable<EventLocation[]> {
    return this.http.get<EventLocation[]>(this.apiUrl);
  }

  getLocationById(id: number): Observable<EventLocation> {
    return this.http.get<EventLocation>(`${this.apiUrl}/${id}`);
  }

  getLocationsByCity(city: string): Observable<EventLocation[]> {
    return this.http.get<EventLocation[]>(`${this.apiUrl}/city/${city}`);
  }

  searchLocations(name: string): Observable<EventLocation[]> {
    const params = new HttpParams().set('name', name);
    return this.http.get<EventLocation[]>(`${this.apiUrl}/search`, { params });
  }

  createLocation(location: EventLocation): Observable<EventLocation> {
    return this.http.post<EventLocation>(this.apiUrl, location);
  }

  updateLocation(id: number, location: EventLocation): Observable<EventLocation> {
    return this.http.put<EventLocation>(`${this.apiUrl}/${id}`, location);
  }

  deleteLocation(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}

