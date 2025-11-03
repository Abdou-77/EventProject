import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Event } from '../models/event.model';

@Injectable({
  providedIn: 'root'
})
export class EventService {
  private apiUrl = 'http://localhost:8080/api/events';

  constructor(private http: HttpClient) { }

  getAllEvents(): Observable<Event[]> {
    return this.http.get<Event[]>(this.apiUrl);
  }

  getEventById(id: number): Observable<Event> {
    return this.http.get<Event>(`${this.apiUrl}/${id}`);
  }

  getPublishedEvents(): Observable<Event[]> {
    return this.http.get<Event[]>(`${this.apiUrl}/published`);
  }

  getUpcomingEvents(): Observable<Event[]> {
    return this.http.get<Event[]>(`${this.apiUrl}/upcoming`);
  }

  getEventsByCategory(categoryId: number): Observable<Event[]> {
    return this.http.get<Event[]>(`${this.apiUrl}/category/${categoryId}`);
  }

  getEventsByLocation(locationId: number): Observable<Event[]> {
    return this.http.get<Event[]>(`${this.apiUrl}/location/${locationId}`);
  }

  searchEvents(title: string): Observable<Event[]> {
    const params = new HttpParams().set('title', title);
    return this.http.get<Event[]>(`${this.apiUrl}/search`, { params });
  }

  createEvent(event: Event): Observable<Event> {
    return this.http.post<Event>(this.apiUrl, event);
  }

  updateEvent(id: number, event: Event): Observable<Event> {
    return this.http.put<Event>(`${this.apiUrl}/${id}`, event);
  }

  deleteEvent(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

  incrementViewCount(id: number): Observable<void> {
    return this.http.post<void>(`${this.apiUrl}/${id}/view`, {});
  }
}

