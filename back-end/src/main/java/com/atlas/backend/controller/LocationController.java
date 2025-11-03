package com.atlas.backend.controller;

import com.atlas.backend.model.Location;
import com.atlas.backend.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/locations")
@CrossOrigin(origins = "*")
public class LocationController {

    @Autowired
    private LocationService locationService;

    // GET all locations
    @GetMapping
    public ResponseEntity<List<Location>> getAllLocations() {
        return ResponseEntity.ok(locationService.getAllLocations());
    }

    // GET location by ID
    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable Long id) {
        Optional<Location> location = locationService.getLocationById(id);
        return location.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET locations by city
    @GetMapping("/city/{city}")
    public ResponseEntity<List<Location>> getLocationsByCity(@PathVariable String city) {
        return ResponseEntity.ok(locationService.getLocationsByCity(city));
    }

    // GET search locations by name
    @GetMapping("/search")
    public ResponseEntity<List<Location>> searchLocations(@RequestParam String name) {
        return ResponseEntity.ok(locationService.searchLocationsByName(name));
    }

    // POST create location
    @PostMapping
    public ResponseEntity<Location> createLocation(@RequestBody Location location) {
        Location savedLocation = locationService.saveLocation(location);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLocation);
    }

    // PUT update location
    @PutMapping("/{id}")
    public ResponseEntity<Location> updateLocation(@PathVariable Long id, @RequestBody Location location) {
        if (!locationService.locationExists(id)) {
            return ResponseEntity.notFound().build();
        }
        location.setId(id);
        Location updatedLocation = locationService.saveLocation(location);
        return ResponseEntity.ok(updatedLocation);
    }

    // DELETE location
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable Long id) {
        if (!locationService.locationExists(id)) {
            return ResponseEntity.notFound().build();
        }
        locationService.deleteLocation(id);
        return ResponseEntity.noContent().build();
    }

    // GET all cities (distinct list)
    @GetMapping("/cities")
    public ResponseEntity<List<String>> getAllCities() {
        return ResponseEntity.ok(locationService.getAllCities());
    }
}

