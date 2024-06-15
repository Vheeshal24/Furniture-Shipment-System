package com.mycompany.shippingsystem;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Delivery {
    private String deliveryID;
    private String vehicleType;
    private Route route;
    private int capacity;
    private String currentLocation;
    private ArrayList<FurnitureItem> items;

    public Delivery(String deliveryID, String vehicleType, Route route, int capacity) {
        this.deliveryID = deliveryID;
        this.vehicleType = vehicleType;
        this.route = route;
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    public void loadItem(FurnitureItem item, int quantity) {
    for (int i = 0; i < quantity; i++) {
        items.add(item);
    }
    String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    System.out.println("Loaded " + quantity + " " + item.getFurnitureID() + "(s) into delivery at " + timestamp);
}

    public void unloadItem(FurnitureItem item, int quantity) {
    for (int i = 0; i < quantity; i++) {
        items.remove(item);
    }
    String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    System.out.println("Unloaded " + quantity + " " + item.getFurnitureID() + "(s) from delivery at " + timestamp);
}

    public void updateLocation(String newLocation) {
    String previousLocation = this.currentLocation;
    this.currentLocation = newLocation;
    String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    System.out.println("Location updated from " + previousLocation + " to " + newLocation + " at " + timestamp);
}

    public String trackDelivery() {
    if (currentLocation != null) {
        return "Current location of delivery " + deliveryID + ": " + currentLocation;
    } else {
        return "Delivery " + deliveryID + " has not started yet.";
    }
}

    // Getters and Setters
    public String getDeliveryID() { 
        return deliveryID; 
    }
    public void setDeliveryID(String deliveryID) {
        this.deliveryID = deliveryID;
    }
    public String getVehicleType() {
        return vehicleType; 
    }
    public void setVehicleType(String vehicleType) { 
        this.vehicleType = vehicleType;
    }
    public Route getRoute() {
        return route;
    }
    public void setRoute(Route route) { 
        this.route = route; 
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) { 
        this.capacity = capacity;
    }
    public String getCurrentLocation() { 
        return currentLocation; 
    }
    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }
    public ArrayList<FurnitureItem> getItems() {
        return items;
    }
    public void setItems(ArrayList<FurnitureItem> items) {
        this.items = items;
    }
}
