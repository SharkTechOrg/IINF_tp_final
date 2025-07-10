package com.uber.controller;

import com.uber.models.RateDriver;
import com.uber.models.RateTrip;
import com.uber.repositories.DriverRepository;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DriverController {
    private final DriverRepository driverRepo;

    public DriverController() {
        this.driverRepo = new DriverRepository();
    }

    public boolean rateDriver(Trip trip, int rating) {
        if (rating < 1 || rating > 5) {
            return false;
        }
        Driver driver = trip.getDriver();
        driver.setRating(rating);
        driverRepo.registerRating(driver, rating);
        return true;
    }

   public void mostrarResumenFinal(Trip trip) {
    Driver driver = trip.getDriver();
    System.out.println("VIAJE COMPLETADO");
    System.out.println("Resumen del viaje:");
    System.out.println("Usuario: " + trip.getPassengerName());
    System.out.println("Viaje exitoso: " + trip.getOrigin() + " -> " + trip.getDestination());
    System.out.println("Tu calificación: " + driver.getRating() + " estrellas");
    System.out.println("Gracias por usar Uber");
}

}

