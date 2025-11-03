package com.atlas.backend.service;

import com.atlas.backend.model.Location;
import com.atlas.backend.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    // Create or update location
    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }

    // Get all locations
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    // Get location by ID
    public Optional<Location> getLocationById(Long id) {
        return locationRepository.findById(id);
    }

    // Get locations by city
    public List<Location> getLocationsByCity(String city) {
        return locationRepository.findByCity(city);
    }

    // Search locations by name
    public List<Location> searchLocationsByName(String name) {
        return locationRepository.findByNameContainingIgnoreCase(name);
    }

    // Delete location
    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }

    // Check if location exists
    public boolean locationExists(Long id) {
        return locationRepository.existsById(id);
    }

    // Get all unique cities
    public List<String> getAllCities() {
        return locationRepository.findAll().stream()
                .map(Location::getCity)
                .distinct()
                .sorted()
                .toList();
    }
}

