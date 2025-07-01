package src.com.uber.models;

public class Trip {
    private Location destination;
    private TripOption tripOption;

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public Location getDestination() {
        return destination;
    }

    public void setTripOption(TripOption tripOption) {
        this.tripOption = tripOption;
    }

    public TripOption getTripOption() {
        return tripOption;
    }
}
