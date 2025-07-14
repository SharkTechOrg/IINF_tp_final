package uber_trip_request.models;

public class Location {
    private String address;

    public Location(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return address;
    }
}
