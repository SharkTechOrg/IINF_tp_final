package com.uber.ui;

import com.uber.controller.TripFlowController;
import com.uber.models.Driver;
import com.uber.models.Trip;

import java.util.Scanner;

public class UserUI {
    private final TripFlowController flowController = new TripFlowController();

    public void start() {
        Scanner scanner = new Scanner(System.in);

        Trip trip = flowController.solicitarViaje();

        if (trip == null) {
            System.out.println("No se encontraron direcciones coincidentes.");
            return;
        }

        String nombrePasajero = trip.getPassenger().getName();
        System.out.println("Pasajero: " + nombrePasajero + " solicitó un viaje desde "
                + trip.getOrigin().getAddress() + " hasta " + trip.getDestination().getAddress());
        System.out.println("Viaje solicitado con éxito.");
        Driver conductor = trip.getDriver();
        System.out.println("Buscando un conductor cercano...");
        System.out.println("Conductor asignado: " + conductor.getName() + " (Toyota Corolla - ABC123)");
        System.out.println("Calificación: 4.9");
        System.out.println("Teléfono del conductor: +54 11 5555 1234");
        System.out.println("El conductor llegará en aproximadamente 10 minutos.");
        System.out.println("Punto de recogida: " + trip.getOrigin().getAddress());

        showDriverCountdown();

        System.out.println("Tu conductor ha llegado al punto de encuentro.");

        flowController.iniciarViaje(trip);

        System.out.println("En viaje hacia: " + trip.getDestination().getAddress());

        simulateTravel();

        flowController.completarViaje(trip);

        System.out.println("Has llegado a tu destino: " + trip.getDestination().getAddress());
        System.out.println("Gracias por viajar con Uber.");
        System.out.print("Calificá tu viaje con " + conductor.getName() + " (1 a 5 estrellas): ");
    }

    private void showDriverCountdown() {
        try {
            Thread.sleep(2000);
            System.out.println("Carlos está a 8 minutos de tu ubicación.");
            Thread.sleep(2000);
            System.out.println("Carlos está a 5 minutos de tu ubicación.");
            Thread.sleep(2000);
            System.out.println("Carlos está a 2 minutos de tu ubicación.");
            Thread.sleep(2000);
            System.out.println("Carlos está llegando. ¡Sal a su encuentro!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void simulateTravel() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
