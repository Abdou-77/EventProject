package com.atlas.backend.repository;

import com.atlas.backend.model.UserPreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserPreferenceRepository extends JpaRepository<UserPreference, Long> {

    // Find all preferences by user
    List<UserPreference> findByUserId(Long userId);

    // Find all users who prefer a category
    List<UserPreference> findByCategoryId(Long categoryId);

    // Find specific preference
    Optional<UserPreference> findByUserIdAndCategoryId(Long userId, Long categoryId);

    // Check if preference exists
    boolean existsByUserIdAndCategoryId(Long userId, Long categoryId);

    // Delete preference
    void deleteByUserIdAndCategoryId(Long userId, Long categoryId);
}

