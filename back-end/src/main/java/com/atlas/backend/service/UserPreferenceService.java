package com.atlas.backend.service;

import com.atlas.backend.model.UserPreference;
import com.atlas.backend.repository.UserPreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserPreferenceService {

    @Autowired
    private UserPreferenceRepository userPreferenceRepository;

    // Create or update preference
    public UserPreference savePreference(UserPreference preference) {
        return userPreferenceRepository.save(preference);
    }

    // Get all preferences
    public List<UserPreference> getAllPreferences() {
        return userPreferenceRepository.findAll();
    }

    // Get preference by ID
    public Optional<UserPreference> getPreferenceById(Long id) {
        return userPreferenceRepository.findById(id);
    }

    // Get preferences by user
    public List<UserPreference> getPreferencesByUser(Long userId) {
        return userPreferenceRepository.findByUserId(userId);
    }

    // Get preferences by category
    public List<UserPreference> getPreferencesByCategory(Long categoryId) {
        return userPreferenceRepository.findByCategoryId(categoryId);
    }

    // Get specific preference
    public Optional<UserPreference> getPreferenceByUserAndCategory(Long userId, Long categoryId) {
        return userPreferenceRepository.findByUserIdAndCategoryId(userId, categoryId);
    }

    // Check if preference exists
    public boolean preferenceExists(Long userId, Long categoryId) {
        return userPreferenceRepository.existsByUserIdAndCategoryId(userId, categoryId);
    }

    // Delete preference
    public void deletePreference(Long id) {
        userPreferenceRepository.deleteById(id);
    }

    // Delete preference by user and category
    @Transactional
    public void deletePreferenceByUserAndCategory(Long userId, Long categoryId) {
        userPreferenceRepository.deleteByUserIdAndCategoryId(userId, categoryId);
    }
}

