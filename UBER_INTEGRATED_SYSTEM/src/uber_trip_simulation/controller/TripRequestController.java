package uber_trip_simulation.controller;

import uber_trip_simulation.models.*;


public class TripRequestController {
    public Trip requestTrip(Passenger passenger, Location origin, Location destination) {
        return new Trip(passenger, origin, destination);
    }
}
