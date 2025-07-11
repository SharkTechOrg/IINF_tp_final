package com.uber.ui;

import com.uber.controller.DriverController;
import com.uber.models.RateDriver;
import com.uber.models.RateTrip;

import java.util.Scanner;

public class UserUI {
    private final Scanner scanner;
    private final DriverController controller;

    public UserUI() {
        this.scanner = new Scanner(System.in);
        this.controller = new DriverController();
    }

    public void start() {
        RateTrip trip = simularViajeCompleto();

        System.out.println("Viaje completado exitosamente");
        System.out.println("Estado actual: COMPLETADO");
        System.out.println("CALIFICÁ TU VIAJE\n");

        RateDriver driver = trip.getDriver();
        System.out.println("¿Cómo fue tu experiencia con " + driver.getName() + "?");

        controller.calificarViaje(trip, scanner);

        controller.mostrarResumenFinal(trip);
    }

     private RateTrip simularViajeCompleto() {
        RateDriver driver = new RateDriver("Carlos Pérez");
        return new RateTrip("María García", "Av. Rivadavia 1234", "Corrientes y Callao", driver);
    }
}

