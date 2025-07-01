package com.uber.controller;

import com.uber.models.*;

public class TripRequestController {
    public Trip requestTrip(Passenger passenger, Location origin, Location destination) {
        return new Trip(passenger, origin, destination);
    }
}