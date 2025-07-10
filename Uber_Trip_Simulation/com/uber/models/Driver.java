package com.uber.models;

public class Driver {
    private String id;
    private String name;
    private boolean isAvailable;

    public Driver(String id, String name, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.isAvailable = isAvailable;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
}