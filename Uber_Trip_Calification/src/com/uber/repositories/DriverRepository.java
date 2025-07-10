package com.uber.repositories;

import com.uber.models.Driver;

public class DriverRepository {
    public void registerRating(Driver driver, int rating) {
        driver.addRating(rating);
        System.out.println("Calificación registrada para " + driver.getName() + ": " + rating + " estrellas.");
    }
}

