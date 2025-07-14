package uber_trip_request.controllers;

import java.util.List;

import uber_trip_request.models.TripOption;


public class TripOptionController {
    public List<TripOption> getAvailableOptions() {
        return List.of(
            new TripOption("UberX", 3400.0),
            new TripOption("UberXL", 4000.0),
            new TripOption("Comfort", 5500.0)
        );
    }
}