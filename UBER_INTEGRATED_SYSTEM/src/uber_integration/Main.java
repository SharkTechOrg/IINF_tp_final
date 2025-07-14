package uber_integration;

import uber_trip_request.ui.RequestUI;
import uber_trip_simulation.ui.SimulationUI;
import uber_trip_calification.ui.CalificationUI;
import uber_trip_simulation.models.Trip;

public class Main {
    public static void main(String[] args) {
        
        RequestUI requestUI = new RequestUI();
        Trip trip = requestUI.startTripRequestFlow();

        
        SimulationUI simulationUI = new SimulationUI();
        simulationUI.start(trip);

        
        CalificationUI calificationUI = new CalificationUI();
        calificationUI.start(trip);
    }
}
