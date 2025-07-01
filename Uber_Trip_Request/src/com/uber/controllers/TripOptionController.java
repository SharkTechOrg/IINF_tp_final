package src.com.uber.controllers;

import java.util.List;
import src.com.uber.models.TripOption;

public class TripOptionController {
    public List<TripOption> getAvailableOptions() {
        return List.of(
            new TripOption("UberX", 300.0),
            new TripOption("UberXL", 500.0),
            new TripOption("Comfort", 700.0)
        );
    }
}
