package src.com.uber.ui;

import src.com.uber.controllers.TripController;
import src.com.uber.models.Location;
import src.com.uber.models.TripOption;

import java.util.List;
import java.util.Scanner;

public class UserUI {
    private TripController tripController;
    private Scanner scanner;

    public UserUI() {
        this.tripController = new TripController();
        this.scanner = new Scanner(System.in);
    }

    public void startTripRequestFlow() {
        System.out.println("Bienvenido a Uber Trip Request");

        System.out.print("Ingrese dirección de destino: ");
        String input = scanner.nextLine();

        List<Location> matches = tripController.buscarDirecciones(input);
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
        tripController.asignarDestino(matches.get(selectedIndex - 1));

        System.out.println("Destino asignado: " + tripController.obtenerDestino());

        System.out.println("Opciones de viaje disponibles:");
        List<TripOption> options = tripController.obtenerOpciones();
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }

        System.out.print("Seleccione una opción de viaje (número): ");
        int selectedOption = scanner.nextInt();
        tripController.asignarOpcion(options.get(selectedOption - 1));

        System.out.println("Opción seleccionada: " + tripController.obtenerOpcionSeleccionada());
    }
}
