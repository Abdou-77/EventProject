package com.atlas.backend.controller;

import com.atlas.backend.model.EventView;
import com.atlas.backend.service.EventViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/event-views")
@CrossOrigin(origins = "*")
public class EventViewController {

    @Autowired
    private EventViewService eventViewService;

    // GET all event views
    @GetMapping
    public ResponseEntity<List<EventView>> getAllEventViews() {
        return ResponseEntity.ok(eventViewService.getAllEventViews());
    }

    // GET event view by ID
    @GetMapping("/{id}")
    public ResponseEntity<EventView> getEventViewById(@PathVariable Long id) {
        Optional<EventView> eventView = eventViewService.getEventViewById(id);
        return eventView.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET views by user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<EventView>> getViewsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(eventViewService.getViewsByUser(userId));
    }

    // GET views by event
    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<EventView>> getViewsByEvent(@PathVariable Long eventId) {
        return ResponseEntity.ok(eventViewService.getViewsByEvent(eventId));
    }

    // GET recent views by user
    @GetMapping("/user/{userId}/recent")
    public ResponseEntity<List<EventView>> getRecentViewsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(eventViewService.getRecentViewsByUser(userId));
    }

    // GET count views for event
    @GetMapping("/event/{eventId}/count")
    public ResponseEntity<Long> countViewsForEvent(@PathVariable Long eventId) {
        long count = eventViewService.countViewsForEvent(eventId);
        return ResponseEntity.ok(count);
    }

    // POST record event view
    @PostMapping
    public ResponseEntity<EventView> recordEventView(@RequestBody EventView eventView) {
        EventView savedEventView = eventViewService.saveEventView(eventView);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEventView);
    }

    // DELETE event view
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEventView(@PathVariable Long id) {
        eventViewService.deleteEventView(id);
        return ResponseEntity.noContent().build();
    }
}

