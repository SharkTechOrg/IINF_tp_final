package com.uber;

import com.uber.controller.TripRequestController;
import com.uber.models.*;
import com.uber.repositories.LocationRepo;

import java.util.List;

public class UberFlow {
    public static void main(String[] args) {
        Passenger passenger = new Passenger("1", "María García", "1112345678");
        Driver driver = new Driver("1", "Juan Pérez", true);
        LocationRepo locationRepo = new LocationRepo();
        TripRequestController controller = new TripRequestController();

        List<Location> foundLocations = locationRepo.search("Corrientes");
        if (foundLocations.isEmpty()) {
            System.out.println("No se encontraron direcciones coincidentes.");
            return;
        }

        Location origin = new Location("Av. Rivadavia 1234");
        Location destination = foundLocations.get(0);

        Trip trip = controller.requestTrip(passenger, origin, destination);
        System.out.println(passenger.getName() + " solicitó un viaje desde " + origin.getAddress() + " hasta " + destination.getAddress());


        if (driver.isAvailable()) {
            trip.assignDriver(driver);
            driver.setAvailable(false);
            System.out.println("Viaje aceptado por " + driver.getName());
        }

        trip.start();
        System.out.println("Viaje iniciado.");

        trip.complete();
        driver.setAvailable(true);
        System.out.println("Viaje finalizado.");
        System.out.println("Estado final del viaje: " + trip.getStatus());
    }
}