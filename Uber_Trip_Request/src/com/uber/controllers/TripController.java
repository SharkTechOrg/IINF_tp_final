package src.com.uber.controllers;

import src.com.uber.models.Location;
import src.com.uber.models.TripOption;
import src.com.uber.repositories.AddressRepo;

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
