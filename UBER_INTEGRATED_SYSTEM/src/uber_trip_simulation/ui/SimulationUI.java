package uber_trip_simulation.ui;

import uber_trip_simulation.controller.TripFlowController;
import uber_trip_simulation.models.Driver;
import uber_trip_simulation.models.Trip;

public class SimulationUI {
    private final TripFlowController flowController = new TripFlowController();

    // Método para usar en integración
    public void start(Trip trip) {
        if (trip == null) {
            System.out.println("No se pudo procesar el viaje.");
            return;
        }

        System.out.println("Pasajero: " + trip.getPassenger().getName() + " solicitó un viaje desde "
                + trip.getOrigin().getAddress() + " hasta " + trip.getDestination().getAddress());
        System.out.println("Viaje solicitado con éxito.");

        Driver conductor = new Driver("1", "Carlos Pérez", true);
        trip.assignDriver(conductor);

        System.out.println("Conductor asignado: " + conductor.getName() + " (Toyota Corolla - ABC123)");
        System.out.println("Calificación: 4.9");
        System.out.println("Teléfono del conductor: +54 11 5555 1234");
        System.out.println("Punto de recogida: " + trip.getOrigin().getAddress());

        showDriverCountdown();

        System.out.println("Tu conductor ha llegado al punto de encuentro.");

        flowController.iniciarViaje(trip);

        System.out.println("En viaje hacia: " + trip.getDestination().getAddress());

        simulateTravel();

        flowController.completarViaje(trip);

        System.out.println("Has llegado a tu destino: " + trip.getDestination().getAddress());
        System.out.println("Gracias por viajar con Uber.");
    }

    // ✅ Método adicional para pruebas locales (UberFlow)
    public void start() {
        Trip trip = flowController.solicitarViaje();
        start(trip);
    }

    private void showDriverCountdown() {
        try {
            Thread.sleep(1000);
            System.out.println("Carlos está a 8 minutos de tu ubicación.");
            Thread.sleep(1000);
            System.out.println("Carlos está a 5 minutos de tu ubicación.");
            Thread.sleep(1000);
            System.out.println("Carlos está llegando. ¡Sal a su encuentro!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void simulateTravel() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
