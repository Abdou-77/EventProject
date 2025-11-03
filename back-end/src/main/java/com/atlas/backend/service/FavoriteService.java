package com.atlas.backend.service;

import com.atlas.backend.model.Favorite;
import com.atlas.backend.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    // Add favorite
    public Favorite addFavorite(Favorite favorite) {
        favorite.setCreatedAt(LocalDateTime.now());
        return favoriteRepository.save(favorite);
    }

    // Get all favorites
    public List<Favorite> getAllFavorites() {
        return favoriteRepository.findAll();
    }

    // Get favorite by ID
    public Optional<Favorite> getFavoriteById(Long id) {
        return favoriteRepository.findById(id);
    }

    // Get favorites by user
    public List<Favorite> getFavoritesByUser(Long userId) {
        return favoriteRepository.findByUserId(userId);
    }

    // Get favorites by event
    public List<Favorite> getFavoritesByEvent(Long eventId) {
        return favoriteRepository.findByEventId(eventId);
    }

    // Get specific favorite
    public Optional<Favorite> getFavoriteByUserAndEvent(Long userId, Long eventId) {
        return favoriteRepository.findByUserIdAndEventId(userId, eventId);
    }

    // Check if favorite exists
    public boolean favoriteExists(Long userId, Long eventId) {
        return favoriteRepository.existsByUserIdAndEventId(userId, eventId);
    }

    // Delete favorite
    public void deleteFavorite(Long id) {
        favoriteRepository.deleteById(id);
    }

    // Delete favorite by user and event
    @Transactional
    public void deleteFavoriteByUserAndEvent(Long userId, Long eventId) {
        favoriteRepository.deleteByUserIdAndEventId(userId, eventId);
    }
}

