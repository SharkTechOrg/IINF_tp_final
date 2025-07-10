package src.com.uber.ui;

import src.com.uber.controllers.AddressController;
import src.com.uber.controllers.TripController;
import src.com.uber.controllers.TripOptionController;
import src.com.uber.models.Location;
import src.com.uber.models.Trip;
import src.com.uber.models.TripOption;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserUI {
    private final AddressController addressController;
    private final TripOptionController tripOptionController;
    private final TripController tripController;
    private final Trip trip;

    public UserUI() {
        this.addressController = new AddressController();
        this.tripOptionController = new TripOptionController();
        this.tripController = new TripController();
        this.trip = new Trip();
    }

    public void startTripRequestFlow() {
        Scanner scanner = new Scanner(System.in);
        List<Location> matches;

        // BUCLE para ingresar dirección hasta que haya coincidencias
        while (true) {
            System.out.print("Ingrese dirección de destino: ");
            String input = scanner.nextLine();
            matches = tripController.buscarDirecciones(input);

            if (!matches.isEmpty()) break;

            System.out.println("No se encontraron coincidencias. Intente nuevamente.\n");
        }

        // Mostrar coincidencias
        System.out.println("Direcciones encontradas:");
        for (int i = 0; i < matches.size(); i++) {
            System.out.println((i + 1) + ". " + matches.get(i));
        }

        // BUCLE para elegir dirección válida
        int selectedIndex = -1;
        while (true) {
            try {
                System.out.print("Seleccione una dirección (número): ");
                selectedIndex = scanner.nextInt();
                scanner.nextLine(); // limpiar buffer

                if (tripController.esDireccionValida(matches, selectedIndex)) break;

                System.out.println("Número inválido. Intente nuevamente.");
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Debe ingresar un número.");
                scanner.nextLine();
            }
        }

        Location selected = matches.get(selectedIndex - 1);
        trip.setDestination(selected);
        System.out.println("Destino asignado: " + trip.getDestination());

        // Mostrar opciones de viaje
        List<TripOption> options = tripOptionController.getAvailableOptions();
        System.out.println("Opciones de viaje disponibles:");
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }

        // BUCLE para elegir opción válida
        int selectedOption = -1;
        while (true) {
            try {
                System.out.print("Seleccione una opción de viaje (número): ");
                selectedOption = scanner.nextInt();

                if (tripController.esOpcionDeViajeValida(options, selectedOption)) break;

                System.out.println("Opción inválida. Intente nuevamente.");
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Debe ingresar un número.");
                scanner.nextLine();
            }
        }

        TripOption chosenOption = options.get(selectedOption - 1);
        trip.setTripOption(chosenOption);

        System.out.println("Opción seleccionada: " + trip.getTripOption());
    }
}
