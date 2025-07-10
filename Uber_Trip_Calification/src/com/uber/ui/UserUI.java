package com.uber.ui;

import com.uber.controller.DriverController;
import com.uber.models.Driver;
import com.uber.models.Trip;

import java.util.Scanner;

public class UserUI {
    private final Scanner scanner;
    private final DriverController controller;

    public UserUI() {
        this.scanner = new Scanner(System.in);
        this.controller = new DriverController();
    }

    public void start() {
        Trip trip = simularViajeCompleto();

        System.out.println("Viaje completado exitosamente");
        System.out.println("Estado actual: COMPLETADO");
        System.out.println("CALIFICÁ TU VIAJE");

        Driver driver = trip.getDriver();
        System.out.println("¿Cómo fue tu experiencia con " + driver.getName() + "?");
        System.out.print("Seleccioná una calificación (1 a 5 estrellas): ");
        int rating = scanner.nextInt();

        if (controller.rateDriver(trip, rating)) {
            System.out.println("Gracias por tu calificación!");
        } else {
            System.out.println("Calificación inválida. Debe ser entre 1 y 5.");
        }

        controller.mostrarResumenFinal(trip);
    }

    private Trip simularViajeCompleto() {
        Driver driver = new Driver("Carlos Pérez");
        return new Trip("María García", "Av. Rivadavia 1234", "Corrientes y Callao", driver);
    }
}

