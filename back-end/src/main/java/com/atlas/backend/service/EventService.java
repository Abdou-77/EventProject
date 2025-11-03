package com.atlas.backend.service;

import com.atlas.backend.model.Event;
import com.atlas.backend.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    // Create or update event
    public Event saveEvent(Event event) {
        if (event.getId() == null) {
            event.setCreatedAt(LocalDateTime.now());
        }
        event.setUpdatedAt(LocalDateTime.now());
        return eventRepository.save(event);
    }

    // Get all events
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // Get event by ID
    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    // Get published events
    public List<Event> getPublishedEvents() {
        return eventRepository.findByPublishedTrue();
    }

    // Get events by category
    public List<Event> getEventsByCategory(Long categoryId) {
        return eventRepository.findByCategoryId(categoryId);
    }

    // Get events by location
    public List<Event> getEventsByLocation(Long locationId) {
        return eventRepository.findByLocationId(locationId);
    }

    // Get events by date
    public List<Event> getEventsByDate(LocalDate date) {
        return eventRepository.findByDate(date);
    }

    // Search events by title
    public List<Event> searchEventsByTitle(String title) {
        return eventRepository.findByTitleContainingIgnoreCase(title);
    }

    // Delete event
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    // Check if event exists
    public boolean eventExists(Long id) {
        return eventRepository.existsById(id);
    }

    // Increment view count
    public void incrementViewCount(Long id) {
        Optional<Event> eventOpt = eventRepository.findById(id);
        if (eventOpt.isPresent()) {
            Event event = eventOpt.get();
            event.setViewCount(event.getViewCount() == null ? 1 : event.getViewCount() + 1);
            eventRepository.save(event);
        }
    }

    // Get events by period (this weekend, next week, etc.)
    public List<Event> getEventsByPeriod(LocalDate startDate, LocalDate endDate) {
        return eventRepository.findByPublishedTrueAndDateBetweenOrderByDateAsc(startDate, endDate);
    }

    // Get events this weekend
    public List<Event> getEventsThisWeekend() {
        LocalDate today = LocalDate.now();
        LocalDate saturday = today.with(java.time.DayOfWeek.SATURDAY);
        LocalDate sunday = saturday.plusDays(1);
        return eventRepository.findByPublishedTrueAndDateBetweenOrderByDateAsc(saturday, sunday);
    }

    // Get events next week
    public List<Event> getEventsNextWeek() {
        LocalDate today = LocalDate.now();
        LocalDate nextMonday = today.with(java.time.DayOfWeek.MONDAY).plusWeeks(1);
        LocalDate nextSunday = nextMonday.plusDays(6);
        return eventRepository.findByPublishedTrueAndDateBetweenOrderByDateAsc(nextMonday, nextSunday);
    }

    // Get upcoming events
    public List<Event> getUpcomingEvents() {
        return eventRepository.findByPublishedTrueAndDateGreaterThanEqualOrderByDateAsc(LocalDate.now());
    }

    // Get popular events (top 10 by views)
    public List<Event> getPopularEvents() {
        return eventRepository.findTop10ByPublishedTrueOrderByViewCountDesc();
    }

    // Get events by city (published and sorted by date)
    public List<Event> getEventsByCity(Long locationId) {
        return eventRepository.findByPublishedTrueAndLocationIdOrderByDateAsc(locationId);
    }

    // Get events by city and period
    public List<Event> getEventsByCityAndPeriod(Long locationId, LocalDate startDate, LocalDate endDate) {
        return eventRepository.findByPublishedTrueAndLocationIdAndDateBetweenOrderByDateAsc(locationId, startDate, endDate);
    }

    // Get events by category and period
    public List<Event> getEventsByCategoryAndPeriod(Long categoryId, LocalDate startDate, LocalDate endDate) {
        return eventRepository.findByPublishedTrueAndCategoryIdAndDateBetweenOrderByDateAsc(categoryId, startDate, endDate);
    }

    // Get events by city and category
    public List<Event> getEventsByCityAndCategory(Long locationId, Long categoryId) {
        return eventRepository.findByPublishedTrueAndLocationIdAndCategoryIdOrderByDateAsc(locationId, categoryId);
    }

    // Get recommended events (similar category, different event)
    public List<Event> getRecommendedEvents(Long eventId) {
        Optional<Event> eventOpt = eventRepository.findById(eventId);
        if (eventOpt.isPresent()) {
            Event event = eventOpt.get();
            List<Event> recommendations = eventRepository.findByPublishedTrueAndCategoryIdOrderByDateAsc(event.getCategoryId());
            // Remove current event from recommendations
            recommendations.removeIf(e -> e.getId().equals(eventId));
            // Return max 5 recommendations
            return recommendations.stream().limit(5).toList();
        }
        return List.of();
    }
}

