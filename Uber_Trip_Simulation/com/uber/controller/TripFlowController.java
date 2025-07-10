package com.uber.controller;

import com.uber.models.*;
import com.uber.repositories.LocationRepo;

import java.util.List;

public class TripFlowController {
    private final TripRequestController requestController;
    private final LocationRepo locationRepo;
    private final Driver driver;
    private final Passenger passenger;

    public TripFlowController() {
        this.requestController = new TripRequestController();
        this.locationRepo = new LocationRepo();

        
        this.passenger = new Passenger("1", "María García", "1112345678");
        this.driver = new Driver("1", "Carlos Pérez", true);
    }

    public Trip solicitarViaje() {
        List<Location> found = locationRepo.search("Corrientes");
        if (found.isEmpty()) return null;

        Location origin = new Location("Av. Rivadavia 1234");
        Location destination = found.get(0);

        Trip trip = requestController.requestTrip(passenger, origin, destination);
        if (driver.isAvailable()) {
            trip.assignDriver(driver);
            driver.setAvailable(false);
        }
        return trip;
    }

    public void iniciarViaje(Trip trip) {
        trip.start();
    }

    public void completarViaje(Trip trip) {
        trip.complete();
        driver.setAvailable(true);
    }
}

