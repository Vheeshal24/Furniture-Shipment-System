package com.mycompany.shippingsystem;

import java.util.ArrayList;

public class Vehicle {
    private String vehicleID;
    private String deliveryVehicle;
    private ArrayList<FurnitureItem> items;
    private double maxCapacity;
    private double maxLength;
    private double maxWidth;
    private double maxHeight;

    public Vehicle(String vehicleID, String deliveryVehicle, double maxCapacity, double maxLength, double maxWidth, double maxHeight) {
    this.vehicleID = vehicleID;
    this.deliveryVehicle = deliveryVehicle;
    this.maxCapacity = maxCapacity;
    this.maxLength = maxLength;
    this.maxWidth = maxWidth;
    this.maxHeight = maxHeight;
    this.items = new ArrayList<>();
}


    public void loadItem(FurnitureItem item) {
        items.add(item);
        System.out.println("Loaded item: " + item.getFurnitureID());
    }

    public boolean canLoadShipment(FurnitureShipment shipment) {
    // Check if the shipment is null
    if (shipment == null) {
        return false;
    }
    
    // Check if the vehicle has enough capacity
    if (calculateTotalWeight() + Double.parseDouble(shipment.getItem().getWeight()) > maxCapacity) {
        return false; // Vehicle cannot accommodate the additional weight
    }
    
    // Check if the dimensions of the shipment exceed the vehicle's space
    String[] shipmentDimensions = shipment.getItem().getDimensions().split("x");
    double shipmentLength = Double.parseDouble(shipmentDimensions[0]);
    double shipmentWidth = Double.parseDouble(shipmentDimensions[1]);
    double shipmentHeight = Double.parseDouble(shipmentDimensions[2]);
    
    if (shipmentLength > maxLength || shipmentWidth > maxWidth || shipmentHeight > maxHeight) {
        return false; // Shipment dimensions exceed vehicle's space
    }
    
    // Additional checks such as fragility or special handling requirements can be added here
    
    return true; // Shipment can be loaded onto the vehicle
}

    public double calculateTotalWeight() {
    double totalWeight = 0.0;
    for (FurnitureItem item : items) {
        totalWeight += Double.parseDouble(item.getWeight());
    }
    return totalWeight;
}
    public String getVehicleID() {
        return vehicleID;
    }
    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }
    public String getDeliveryVehicle() {
        return deliveryVehicle;
    }
    public void setDeliveryVehicle(String deliveryVehicle) {
        this.deliveryVehicle = deliveryVehicle;
    }
    public ArrayList<FurnitureItem> getItems() {
        return items;
    }
}
