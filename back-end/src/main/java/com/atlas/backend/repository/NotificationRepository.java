package com.atlas.backend.repository;

import com.atlas.backend.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    // Find all notifications by user
    List<Notification> findByUserId(Long userId);

    // Find all notifications by event
    List<Notification> findByEventId(Long eventId);

    // Find unseen notifications by user
    List<Notification> findByUserIdAndSeenFalse(Long userId);

    // Find seen notifications by user
    List<Notification> findByUserIdAndSeenTrue(Long userId);

    // Count unseen notifications
    long countByUserIdAndSeenFalse(Long userId);
}

