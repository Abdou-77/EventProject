package com.atlas.backend.controller;

import com.atlas.backend.model.Event;
import com.atlas.backend.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/events")
@CrossOrigin(origins = "*")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        Optional<Event> event = eventService.getEventById(id);
        return event.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/published")
    public ResponseEntity<List<Event>> getPublishedEvents() {
        return ResponseEntity.ok(eventService.getPublishedEvents());
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Event>> getEventsByCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(eventService.getEventsByCategory(categoryId));
    }

    @GetMapping("/location/{locationId}")
    public ResponseEntity<List<Event>> getEventsByLocation(@PathVariable Long locationId) {
        return ResponseEntity.ok(eventService.getEventsByLocation(locationId));
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<Event>> getEventsByDate(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        return ResponseEntity.ok(eventService.getEventsByDate(localDate));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Event>> searchEvents(@RequestParam String title) {
        return ResponseEntity.ok(eventService.searchEventsByTitle(title));
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        Event savedEvent = eventService.saveEvent(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEvent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event event) {
        if (!eventService.eventExists(id)) {
            return ResponseEntity.notFound().build();
        }
        event.setId(id);
        Event updatedEvent = eventService.saveEvent(event);
        return ResponseEntity.ok(updatedEvent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        if (!eventService.eventExists(id)) {
            return ResponseEntity.notFound().build();
        }
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/view")
    public ResponseEntity<Void> incrementViewCount(@PathVariable Long id) {
        eventService.incrementViewCount(id);
        return ResponseEntity.ok().build();
    }

    // GET upcoming events (sorted by date)
    @GetMapping("/upcoming")
    public ResponseEntity<List<Event>> getUpcomingEvents() {
        return ResponseEntity.ok(eventService.getUpcomingEvents());
    }

    // GET events by period (custom date range)
    @GetMapping("/period")
    public ResponseEntity<List<Event>> getEventsByPeriod(
            @RequestParam String startDate,
            @RequestParam String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return ResponseEntity.ok(eventService.getEventsByPeriod(start, end));
    }

    // GET events this weekend
    @GetMapping("/this-weekend")
    public ResponseEntity<List<Event>> getEventsThisWeekend() {
        return ResponseEntity.ok(eventService.getEventsThisWeekend());
    }

    // GET events next week
    @GetMapping("/next-week")
    public ResponseEntity<List<Event>> getEventsNextWeek() {
        return ResponseEntity.ok(eventService.getEventsNextWeek());
    }

    // GET popular events (top 10 by views)
    @GetMapping("/popular")
    public ResponseEntity<List<Event>> getPopularEvents() {
        return ResponseEntity.ok(eventService.getPopularEvents());
    }

    // GET featured events (high view count or promoted)
    @GetMapping("/featured")
    public ResponseEntity<List<Event>> getFeaturedEvents() {
        return ResponseEntity.ok(eventService.getPopularEvents());
    }

    // GET events by city (published and sorted)
    @GetMapping("/city/{locationId}")
    public ResponseEntity<List<Event>> getEventsByCity(@PathVariable Long locationId) {
        return ResponseEntity.ok(eventService.getEventsByCity(locationId));
    }

    // GET events by city and period
    @GetMapping("/city/{locationId}/period")
    public ResponseEntity<List<Event>> getEventsByCityAndPeriod(
            @PathVariable Long locationId,
            @RequestParam String startDate,
            @RequestParam String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return ResponseEntity.ok(eventService.getEventsByCityAndPeriod(locationId, start, end));
    }

    // GET events by category and period
    @GetMapping("/category/{categoryId}/period")
    public ResponseEntity<List<Event>> getEventsByCategoryAndPeriod(
            @PathVariable Long categoryId,
            @RequestParam String startDate,
            @RequestParam String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return ResponseEntity.ok(eventService.getEventsByCategoryAndPeriod(categoryId, start, end));
    }

    // GET events by city and category
    @GetMapping("/city/{locationId}/category/{categoryId}")
    public ResponseEntity<List<Event>> getEventsByCityAndCategory(
            @PathVariable Long locationId,
            @PathVariable Long categoryId) {
        return ResponseEntity.ok(eventService.getEventsByCityAndCategory(locationId, categoryId));
    }

    // GET recommended events (similar to a specific event)
    @GetMapping("/{id}/recommendations")
    public ResponseEntity<List<Event>> getRecommendedEvents(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.getRecommendedEvents(id));
    }
}

