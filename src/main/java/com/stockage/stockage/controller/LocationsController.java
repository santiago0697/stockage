package com.stockage.stockage.controller;

import com.stockage.stockage.exception.ResourceNotFoundException;
import com.stockage.stockage.model.locations;
import com.stockage.stockage.repository.LocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationsController {

    @Autowired
    LocationsRepository locationsRepository;

    @GetMapping("/all")
    public List<locations> getAllLocations() {
        return locationsRepository.findAll();
    }

    // Create new Provider
    @PostMapping("/insert")
    public locations createLocation(@Valid @RequestBody locations locations) {
        return locationsRepository.save(locations);
    }

    // Get single provider by ID
    @GetMapping("/get/{id}")
    public locations getLocationById(@PathVariable(value = "id") Integer location_id) {
        return locationsRepository.findById(location_id)
                .orElseThrow(() -> new ResourceNotFoundException("Location", "id", location_id));
    }

    // Update provider
    @PutMapping("/update/{id}")
    public locations updateLocation(@PathVariable(value = "id") Integer location_id, @Valid @RequestBody locations newLocation) {
        locations l = locationsRepository.findById(location_id)
                .orElseThrow(() -> new ResourceNotFoundException("Location", "location_id", location_id));

        l.setLocation_name(newLocation.getLocation_name());
        l.setLocation_rewrite(newLocation.getLocation_rewrite());

        return locationsRepository.save(l);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteLocation(@PathVariable(value = "id") Integer location_id) {
        locations l = locationsRepository.findById(location_id)
                .orElseThrow(() -> new ResourceNotFoundException("Location", "location_id", location_id));

        locationsRepository.delete(l);
        return ResponseEntity.ok().build();
    }
}
