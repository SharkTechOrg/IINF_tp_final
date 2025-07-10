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

     public void calificarViaje(RateTrip trip, Scanner scanner) {
        int rating = -1;

        while (true) {
            try {
                System.out.print("Seleccioná una calificación (1 a 5 estrellas): ");
                rating = scanner.nextInt();
                scanner.nextLine(); 

                if (rating >= 1 && rating <= 5) {
                    RateDriver driver = trip.getDriver();
                    driver.setRating(rating);
                    driverRepo.registerRating(driver, rating);
                    System.out.println("Gracias por tu calificación de " + rating + " estrella(s)!\n");
                    break;
                } else {
                    System.out.println("Calificación inválida. Debe ser un número entre 1 y 5.\n");
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número del 1 al 5.\n");
                scanner.nextLine(); 
            }
        }
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

