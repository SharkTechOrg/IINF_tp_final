package uber_trip_calification;

import uber_trip_calification.controller.DriverController;
import uber_trip_calification.models.RateDriver;
import uber_trip_calification.models.RateTrip;
import uber_trip_simulation.models.Trip;

import java.util.Scanner;

public class UserCalificationUI {
    private final Scanner scanner;
    private final DriverController controller;

    public UserCalificationUI() {
        this.scanner = new Scanner(System.in);
        this.controller = new DriverController();
    }

    public void start(Trip tripData) {
        RateDriver driver = new RateDriver(tripData.getDriver().getName());
        RateTrip trip = new RateTrip(
                tripData.getPassenger().getName(),
                tripData.getOrigin().getAddress(),
                tripData.getDestination().getAddress(),
                driver
        );

        System.out.println("Viaje completado exitosamente");
        System.out.println("Estado actual: COMPLETADO");
        System.out.println("CALIFICÁ TU VIAJE\n");

        System.out.println("¿Cómo fue tu experiencia con " + driver.getName() + "?");

        controller.calificarViaje(trip, scanner);
        controller.mostrarResumenFinal(trip);
    }
}
