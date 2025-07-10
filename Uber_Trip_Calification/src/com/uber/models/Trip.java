package com.uber.models;

public class Trip {
    private final String passengerName;
    private final String origin;
    private final String destination;
    private final Driver driver;

    public Trip(String passengerName, String origin, String destination, Driver driver) {
        this.passengerName = passengerName;
        this.origin = origin;
        this.destination = destination;
        this.driver = driver;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public Driver getDriver() {
        return driver;
    }
}
