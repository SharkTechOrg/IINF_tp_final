package com.uber.repositories;

import com.uber.models.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LocationRepo {
    private List<Location> knownLocations;

    public LocationRepo() {
        knownLocations = new ArrayList<>();
        knownLocations.add(new Location("Av. Corrientes 1234"));
        knownLocations.add(new Location("Corrientes y Callao"));
        knownLocations.add(new Location("Av. Corrientes 4567"));
    }

    public List<Location> search(String query) {
        return knownLocations.stream()
                .filter(loc -> loc.getAddress().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }
}