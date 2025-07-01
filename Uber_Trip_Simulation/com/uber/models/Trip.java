package com.uber.models;

public class Trip {
    private Passenger passenger;
    private Driver driver;
    private Location origin;
    private Location destination;
    private TripStatus status;

    public Trip(Passenger passenger, Location origin, Location destination) {
        this.passenger = passenger;
        this.origin = origin;
        this.destination = destination;
        this.status = TripStatus.SOLICITADO;
    }

    public void assignDriver(Driver driver) {
        this.driver = driver;
        this.status = TripStatus.ACEPTADO;
    }

    public void start() {
        this.status = TripStatus.EN_PROGRESO;
    }

    public void complete() {
        this.status = TripStatus.COMPLETADO;
    }

    public TripStatus getStatus() {
        return status;
    }
}