package uber_trip_request.ui;

import uber_trip_request.controllers.TripController;
import uber_trip_request.controllers.TripOptionController;
import uber_trip_request.models.Location;
import uber_trip_request.models.TripOption;

import uber_trip_simulation.models.Trip;
import uber_trip_simulation.models.Passenger;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class RequestUI {
    private final TripController tripController;
    private final TripOptionController tripOptionController;

    public RequestUI() {
        this.tripController = new TripController();
        this.tripOptionController = new TripOptionController();
    }

    public Trip startTripRequestFlow() {
        Scanner scanner = new Scanner(System.in);
        List<Location> matches;

        while (true) {
            System.out.print("Ingrese dirección de destino: ");
            String input = scanner.nextLine();
            matches = tripController.buscarDirecciones(input);

            if (!matches.isEmpty()) break;
            System.out.println("No se encontraron coincidencias. Intente nuevamente.\n");
        }

        System.out.println("Direcciones encontradas:");
        for (int i = 0; i < matches.size(); i++) {
            System.out.println((i + 1) + ". " + matches.get(i));
        }

        int selectedIndex = -1;
        while (true) {
            try {
                System.out.print("Seleccione una dirección (número): ");
                selectedIndex = scanner.nextInt();
                scanner.nextLine();
                if (tripController.esDireccionValida(matches, selectedIndex)) break;
                System.out.println("Número inválido. Intente nuevamente.");
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Debe ingresar un número.");
                scanner.nextLine();
            }
        }

        Location selected = matches.get(selectedIndex - 1);
        System.out.println("Destino asignado: " + selected.getAddress());

        // Selección de opción de viaje
        List<TripOption> options = tripOptionController.getAvailableOptions();
        System.out.println("Opciones de viaje disponibles:");
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }

        int selectedOption = -1;
        while (true) {
            try {
                System.out.print("Seleccione una opción de viaje (número): ");
                selectedOption = scanner.nextInt();
                scanner.nextLine();

                if (tripController.esOpcionDeViajeValida(options, selectedOption)) break;
                System.out.println("Opción inválida. Intente nuevamente.");
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Debe ingresar un número.");
                scanner.nextLine();
            }
        }

        TripOption chosenOption = options.get(selectedOption - 1);
        System.out.println("Opción seleccionada: " + chosenOption);

        // Creación del viaje
        Passenger passenger = new Passenger("1", "María García", "1112345678");
        uber_trip_simulation.models.Location origin = new uber_trip_simulation.models.Location("Av. Rivadavia 1234");
        uber_trip_simulation.models.Location destination = new uber_trip_simulation.models.Location(selected.getAddress());

        Trip trip = new Trip(passenger, origin, destination);
        trip.setTripOption(chosenOption);

        return trip;
    }
}
