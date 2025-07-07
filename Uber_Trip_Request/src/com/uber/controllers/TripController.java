package src.com.uber.controllers;

import src.com.uber.models.Location;
import src.com.uber.models.Trip;
import src.com.uber.models.TripOption;

import java.util.List;

public class TripController {
    private AddressController addressController;
    private TripOptionController tripOptionController;
    private Trip trip;

    public TripController() {
        this.addressController = new AddressController();
        this.tripOptionController = new TripOptionController();
        this.trip = new Trip();
    }

    public List<Location> buscarDirecciones(String input) {
        return addressController.findMatchingAddresses(input);
    }

    public void asignarDestino(Location location) {
        trip.setDestination(location);
    }

    public Location obtenerDestino() {
        return trip.getDestination();
    }

    public List<TripOption> obtenerOpciones() {
        return tripOptionController.getAvailableOptions();
    }

    public void asignarOpcion(TripOption option) {
        trip.setTripOption(option);
    }

    public TripOption obtenerOpcionSeleccionada() {
        return trip.getTripOption();
    }

    public Trip obtenerViajeCompleto() {
        return trip;
    }
}

