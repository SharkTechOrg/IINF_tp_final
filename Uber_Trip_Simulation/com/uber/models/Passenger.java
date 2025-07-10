package com.uber.models;

public class Passenger {
    private String id;
    private String name;
    private String phone;

    public Passenger(String id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }
}