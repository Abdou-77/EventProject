package com.atlas.backend.repository;

import com.atlas.backend.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    // Find events by category
    List<Event> findByCategoryId(Long categoryId);

    // Find events by location
    List<Event> findByLocationId(Long locationId);

    // Find published events
    List<Event> findByPublishedTrue();

    // Find events by date
    List<Event> findByDate(LocalDate date);

    // Find events by title containing (search)
    List<Event> findByTitleContainingIgnoreCase(String title);

    // Find events by date range (for periods like "this weekend", "next week")
    List<Event> findByPublishedTrueAndDateBetweenOrderByDateAsc(LocalDate startDate, LocalDate endDate);

    // Find events by city (via location) and date range
    List<Event> findByPublishedTrueAndLocationIdAndDateBetweenOrderByDateAsc(Long locationId, LocalDate startDate, LocalDate endDate);

    // Find events by category and date range
    List<Event> findByPublishedTrueAndCategoryIdAndDateBetweenOrderByDateAsc(Long categoryId, LocalDate startDate, LocalDate endDate);

    // Find events by city and category
    List<Event> findByPublishedTrueAndLocationIdAndCategoryIdOrderByDateAsc(Long locationId, Long categoryId);

    // Find upcoming events (sorted by date)
    List<Event> findByPublishedTrueAndDateGreaterThanEqualOrderByDateAsc(LocalDate date);

    // Find popular events (sorted by view count)
    List<Event> findTop10ByPublishedTrueOrderByViewCountDesc();

    // Find events by location with published status
    List<Event> findByPublishedTrueAndLocationIdOrderByDateAsc(Long locationId);

    // Find events by category with published status
    List<Event> findByPublishedTrueAndCategoryIdOrderByDateAsc(Long categoryId);
}

