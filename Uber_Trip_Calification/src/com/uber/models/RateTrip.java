package com.uber.models;

public class RateTrip {
    private final String passengerName;
    private final String origin;
    private final String destination;
    private final RateDriver driver;

    public RateTrip(String passengerName, String origin, String destination, RateDriver driver) {
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

    public RateDriver getDriver() {
        return driver;
    }
}
