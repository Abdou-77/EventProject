package com.atlas.backend.controller;

import com.atlas.backend.model.Favorite;
import com.atlas.backend.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/favorites")
@CrossOrigin(origins = "*")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    // GET all favorites
    @GetMapping
    public ResponseEntity<List<Favorite>> getAllFavorites() {
        return ResponseEntity.ok(favoriteService.getAllFavorites());
    }

    // GET favorite by ID
    @GetMapping("/{id}")
    public ResponseEntity<Favorite> getFavoriteById(@PathVariable Long id) {
        Optional<Favorite> favorite = favoriteService.getFavoriteById(id);
        return favorite.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET favorites by user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Favorite>> getFavoritesByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(favoriteService.getFavoritesByUser(userId));
    }

    // GET favorites by event
    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<Favorite>> getFavoritesByEvent(@PathVariable Long eventId) {
        return ResponseEntity.ok(favoriteService.getFavoritesByEvent(eventId));
    }

    // GET check if favorite exists
    @GetMapping("/exists")
    public ResponseEntity<Boolean> favoriteExists(@RequestParam Long userId, @RequestParam Long eventId) {
        boolean exists = favoriteService.favoriteExists(userId, eventId);
        return ResponseEntity.ok(exists);
    }

    // POST add favorite
    @PostMapping
    public ResponseEntity<Favorite> addFavorite(@RequestBody Favorite favorite) {
        if (favoriteService.favoriteExists(favorite.getUserId(), favorite.getEventId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        Favorite savedFavorite = favoriteService.addFavorite(favorite);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFavorite);
    }

    // DELETE favorite by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFavorite(@PathVariable Long id) {
        favoriteService.deleteFavorite(id);
        return ResponseEntity.noContent().build();
    }

    // DELETE favorite by user and event
    @DeleteMapping("/user/{userId}/event/{eventId}")
    public ResponseEntity<Void> deleteFavoriteByUserAndEvent(@PathVariable Long userId, @PathVariable Long eventId) {
        favoriteService.deleteFavoriteByUserAndEvent(userId, eventId);
        return ResponseEntity.noContent().build();
    }
}

