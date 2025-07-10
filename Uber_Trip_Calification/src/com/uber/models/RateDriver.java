package com.uber.models;

import java.util.ArrayList;
import java.util.List;

public class RateDriver {
    private final String name;
    private final List<Integer> ratings = new ArrayList<>();
    private int lastRating;

    public RateDriver(String name) {
        this.name = name;
    }

    public void setRating(int rating) {
        this.lastRating = rating;
        addRating(rating); 
    }

    public void addRating(int rating) {
        ratings.add(rating);
    }

    public int getRating() {
        return lastRating;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getRatings() {
        return ratings;
    }
}