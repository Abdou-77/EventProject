package com.atlas.backend.repository;

import com.atlas.backend.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    // Find all favorites by user
    List<Favorite> findByUserId(Long userId);

    // Find all favorites by event
    List<Favorite> findByEventId(Long eventId);

    // Find specific favorite
    Optional<Favorite> findByUserIdAndEventId(Long userId, Long eventId);

    // Check if favorite exists
    boolean existsByUserIdAndEventId(Long userId, Long eventId);

    // Delete favorite by user and event
    void deleteByUserIdAndEventId(Long userId, Long eventId);
}

