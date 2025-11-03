package com.atlas.backend.service;

import com.atlas.backend.model.EventView;
import com.atlas.backend.repository.EventViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventViewService {

    @Autowired
    private EventViewRepository eventViewRepository;

    // Create event view
    public EventView saveEventView(EventView eventView) {
        eventView.setViewedAt(LocalDateTime.now());
        return eventViewRepository.save(eventView);
    }

    // Get all event views
    public List<EventView> getAllEventViews() {
        return eventViewRepository.findAll();
    }

    // Get event view by ID
    public Optional<EventView> getEventViewById(Long id) {
        return eventViewRepository.findById(id);
    }

    // Get views by user
    public List<EventView> getViewsByUser(Long userId) {
        return eventViewRepository.findByUserId(userId);
    }

    // Get views by event
    public List<EventView> getViewsByEvent(Long eventId) {
        return eventViewRepository.findByEventId(eventId);
    }

    // Get recent views by user
    public List<EventView> getRecentViewsByUser(Long userId) {
        return eventViewRepository.findRecentViewsByUserId(userId);
    }

    // Count views for event
    public long countViewsForEvent(Long eventId) {
        return eventViewRepository.countByEventId(eventId);
    }

    // Delete event view
    public void deleteEventView(Long id) {
        eventViewRepository.deleteById(id);
    }
}

