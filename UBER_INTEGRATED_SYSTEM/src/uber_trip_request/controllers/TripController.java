package uber_trip_request.controllers;

import uber_trip_request.models.Location;
import uber_trip_request.models.TripOption;
import uber_trip_request.repositories.AddressRepo;


import java.util.List;

public class TripController {
    private final AddressRepo addressRepo;

    public TripController() {
        this.addressRepo = new AddressRepo();
    }

    public List<Location> buscarDirecciones(String input) {
        return addressRepo.search(input);
    }

    public boolean esDireccionValida(List<Location> resultados, int seleccion) {
        return seleccion >= 1 && seleccion <= resultados.size();
    }

    public boolean esOpcionDeViajeValida(List<TripOption> opciones, int seleccion) {
        return seleccion >= 1 && seleccion <= opciones.size();
    }
}
