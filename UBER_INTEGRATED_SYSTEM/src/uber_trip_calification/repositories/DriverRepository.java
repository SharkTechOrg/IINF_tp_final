package uber_trip_calification.repositories;

import uber_trip_calification.models.RateDriver;


public class DriverRepository {
    public void registerRating(RateDriver driver, int rating) {
        driver.addRating(rating);
        System.out.println("Calificación registrada para " + driver.getName() + ": " + rating + " estrellas.");
    }
}

