package com.atlas.backend.repository;

import com.atlas.backend.model.EventView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventViewRepository extends JpaRepository<EventView, Long> {

    // Find all views by user
    List<EventView> findByUserId(Long userId);

    // Find all views by event
    List<EventView> findByEventId(Long eventId);

    // Count views for an event
    long countByEventId(Long eventId);

    // Find recent views by user
    @Query("SELECT ev FROM EventView ev WHERE ev.userId = ?1 ORDER BY ev.viewedAt DESC")
    List<EventView> findRecentViewsByUserId(Long userId);
}

