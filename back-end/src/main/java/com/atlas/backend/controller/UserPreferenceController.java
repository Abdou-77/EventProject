package com.atlas.backend.controller;

import com.atlas.backend.model.UserPreference;
import com.atlas.backend.service.UserPreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/preferences")
@CrossOrigin(origins = "*")
public class UserPreferenceController {

    @Autowired
    private UserPreferenceService userPreferenceService;

    // GET all preferences
    @GetMapping
    public ResponseEntity<List<UserPreference>> getAllPreferences() {
        return ResponseEntity.ok(userPreferenceService.getAllPreferences());
    }

    // GET preference by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserPreference> getPreferenceById(@PathVariable Long id) {
        Optional<UserPreference> preference = userPreferenceService.getPreferenceById(id);
        return preference.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET preferences by user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserPreference>> getPreferencesByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userPreferenceService.getPreferencesByUser(userId));
    }

    // GET preferences by category
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<UserPreference>> getPreferencesByCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(userPreferenceService.getPreferencesByCategory(categoryId));
    }

    // GET check if preference exists
    @GetMapping("/exists")
    public ResponseEntity<Boolean> preferenceExists(@RequestParam Long userId, @RequestParam Long categoryId) {
        boolean exists = userPreferenceService.preferenceExists(userId, categoryId);
        return ResponseEntity.ok(exists);
    }

    // POST add preference
    @PostMapping
    public ResponseEntity<UserPreference> addPreference(@RequestBody UserPreference preference) {
        if (userPreferenceService.preferenceExists(preference.getUserId(), preference.getCategoryId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        UserPreference savedPreference = userPreferenceService.savePreference(preference);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPreference);
    }

    // DELETE preference by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePreference(@PathVariable Long id) {
        userPreferenceService.deletePreference(id);
        return ResponseEntity.noContent().build();
    }

    // DELETE preference by user and category
    @DeleteMapping("/user/{userId}/category/{categoryId}")
    public ResponseEntity<Void> deletePreferenceByUserAndCategory(@PathVariable Long userId, @PathVariable Long categoryId) {
        userPreferenceService.deletePreferenceByUserAndCategory(userId, categoryId);
        return ResponseEntity.noContent().build();
    }
}

