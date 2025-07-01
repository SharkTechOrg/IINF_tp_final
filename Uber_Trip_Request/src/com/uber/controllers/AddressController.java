package src.com.uber.controllers;

import src.com.uber.models.Location;
import src.com.uber.repositories.AddressRepo;

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

