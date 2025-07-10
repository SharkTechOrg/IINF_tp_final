package com.uber.repositories;

import com.uber.models.RateDriver;

public class DriverRepository {
    public void registerRating(RateDriver driver, int rating) {
        driver.addRating(rating);
        System.out.println("Calificación registrada para " + driver.getName() + ": " + rating + " estrellas.");
    }
}

