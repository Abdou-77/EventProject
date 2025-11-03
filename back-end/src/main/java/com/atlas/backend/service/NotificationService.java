package com.atlas.backend.service;

import com.atlas.backend.model.Notification;
import com.atlas.backend.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    // Create notification
    public Notification saveNotification(Notification notification) {
        notification.setSentAt(LocalDateTime.now());
        if (notification.getSeen() == null) {
            notification.setSeen(false);
        }
        return notificationRepository.save(notification);
    }

    // Get all notifications
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    // Get notification by ID
    public Optional<Notification> getNotificationById(Long id) {
        return notificationRepository.findById(id);
    }

    // Get notifications by user
    public List<Notification> getNotificationsByUser(Long userId) {
        return notificationRepository.findByUserId(userId);
    }

    // Get notifications by event
    public List<Notification> getNotificationsByEvent(Long eventId) {
        return notificationRepository.findByEventId(eventId);
    }

    // Get unseen notifications
    public List<Notification> getUnseenNotifications(Long userId) {
        return notificationRepository.findByUserIdAndSeenFalse(userId);
    }

    // Get seen notifications
    public List<Notification> getSeenNotifications(Long userId) {
        return notificationRepository.findByUserIdAndSeenTrue(userId);
    }

    // Count unseen notifications
    public long countUnseenNotifications(Long userId) {
        return notificationRepository.countByUserIdAndSeenFalse(userId);
    }

    // Mark notification as seen
    public void markAsSeen(Long id) {
        Optional<Notification> notificationOpt = notificationRepository.findById(id);
        if (notificationOpt.isPresent()) {
            Notification notification = notificationOpt.get();
            notification.setSeen(true);
            notificationRepository.save(notification);
        }
    }

    // Mark all notifications as seen for a user
    public void markAllAsSeen(Long userId) {
        List<Notification> notifications = notificationRepository.findByUserIdAndSeenFalse(userId);
        notifications.forEach(n -> n.setSeen(true));
        notificationRepository.saveAll(notifications);
    }

    // Delete notification
    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }
}

