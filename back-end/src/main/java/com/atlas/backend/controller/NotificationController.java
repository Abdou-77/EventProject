package com.atlas.backend.controller;

import com.atlas.backend.model.Notification;
import com.atlas.backend.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notifications")
@CrossOrigin(origins = "*")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    // GET all notifications
    @GetMapping
    public ResponseEntity<List<Notification>> getAllNotifications() {
        return ResponseEntity.ok(notificationService.getAllNotifications());
    }

    // GET notification by ID
    @GetMapping("/{id}")
    public ResponseEntity<Notification> getNotificationById(@PathVariable Long id) {
        Optional<Notification> notification = notificationService.getNotificationById(id);
        return notification.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET notifications by user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Notification>> getNotificationsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(notificationService.getNotificationsByUser(userId));
    }

    // GET notifications by event
    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<Notification>> getNotificationsByEvent(@PathVariable Long eventId) {
        return ResponseEntity.ok(notificationService.getNotificationsByEvent(eventId));
    }

    // GET unseen notifications
    @GetMapping("/user/{userId}/unseen")
    public ResponseEntity<List<Notification>> getUnseenNotifications(@PathVariable Long userId) {
        return ResponseEntity.ok(notificationService.getUnseenNotifications(userId));
    }

    // GET seen notifications
    @GetMapping("/user/{userId}/seen")
    public ResponseEntity<List<Notification>> getSeenNotifications(@PathVariable Long userId) {
        return ResponseEntity.ok(notificationService.getSeenNotifications(userId));
    }

    // GET count unseen notifications
    @GetMapping("/user/{userId}/unseen/count")
    public ResponseEntity<Long> countUnseenNotifications(@PathVariable Long userId) {
        long count = notificationService.countUnseenNotifications(userId);
        return ResponseEntity.ok(count);
    }

    // POST create notification
    @PostMapping
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {
        Notification savedNotification = notificationService.saveNotification(notification);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedNotification);
    }

    // PUT mark notification as seen
    @PutMapping("/{id}/seen")
    public ResponseEntity<Void> markAsSeen(@PathVariable Long id) {
        notificationService.markAsSeen(id);
        return ResponseEntity.ok().build();
    }

    // PUT mark all notifications as seen for user
    @PutMapping("/user/{userId}/seen-all")
    public ResponseEntity<Void> markAllAsSeen(@PathVariable Long userId) {
        notificationService.markAllAsSeen(userId);
        return ResponseEntity.ok().build();
    }

    // DELETE notification
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
        return ResponseEntity.noContent().build();
    }
}

