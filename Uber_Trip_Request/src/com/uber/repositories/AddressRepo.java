package src.com.uber.repositories;

import src.com.uber.models.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AddressRepo {
    private List<Location> locations = new ArrayList<>();

    public AddressRepo() {
        locations.add(new Location("Av. Rivadavia 1234"));
        locations.add(new Location("Av. Corrientes 4321"));
        locations.add(new Location("Av. Callao 5678"));
    }

    public List<Location> search(String input) {
        return locations.stream()
                .filter(loc -> loc.getAddress().toLowerCase().contains(input.toLowerCase()))
                .collect(Collectors.toList());
    }
}