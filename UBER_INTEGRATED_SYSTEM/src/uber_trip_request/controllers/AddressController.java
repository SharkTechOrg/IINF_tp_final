package uber_trip_request.controllers;


import uber_trip_request.models.Location;
import uber_trip_request.repositories.AddressRepo;

import java.util.List;

public class AddressController {
    private AddressRepo repo;

    public AddressController() {
        this.repo = new AddressRepo();
    }

    public List<Location> findMatchingAddresses(String input) {
        return repo.search(input);
    }
}

