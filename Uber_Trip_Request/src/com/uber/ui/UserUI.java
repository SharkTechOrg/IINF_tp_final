package src.com.uber.ui;

import src.com.uber.controllers.AddressController;
import src.com.uber.controllers.TripOptionController;
import src.com.uber.models.*;

import java.util.List;
import java.util.Scanner;

public class UserUI {
    private AddressController addressController;
    private TripOptionController tripOptionController;
    private Trip trip;

    public UserUI() {
        this.addressController = new AddressController();
        this.tripOptionController = new TripOptionController();
        this.trip = new Trip();
    }

    public void startTripRequestFlow() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese dirección de destino: ");
        String input = scanner.nextLine();

        List<Location> matches = addressController.findMatchingAddresses(input);
        if (matches.isEmpty()) {
            System.out.println("No se encontraron coincidencias.");
            return;
        }

        System.out.println("Direcciones encontradas:");
        for (int i = 0; i < matches.size(); i++) {
            System.out.println((i + 1) + ". " + matches.get(i));
        }

        System.out.print("Seleccione una dirección (número): ");
        int selectedIndex = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer
        Location selected = matches.get(selectedIndex - 1);
        trip.setDestination(selected);

        System.out.println("Destino asignado: " + trip.getDestination());

        System.out.println("Opciones de viaje disponibles:");
        List<TripOption> options = tripOptionController.getAvailableOptions();
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }

        System.out.print("Seleccione una opción de viaje (número): ");
        int selectedOption = scanner.nextInt();
        TripOption chosenOption = options.get(selectedOption - 1);
        trip.setTripOption(chosenOption);

        System.out.println("Opción seleccionada: " + trip.getTripOption());
    }
}
