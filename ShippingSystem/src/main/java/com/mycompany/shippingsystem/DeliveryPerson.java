/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shippingsystem;

import java.util.Date;

/**
 *
 * @author User
 */
// Import statements here

// Import statements here

public class DeliveryPerson extends Employee {
    private Vehicle vehicle;

    public DeliveryPerson(String employeeID, String employeeName, String role, String contactInfo, Vehicle vehicle) {
        super.setEmployeeID(employeeID);
        super.setEmployeeName(employeeName);
        super.setRole(role);
        super.setContactInfo(contactInfo);
        this.vehicle = vehicle;
    }

    public void loadVehicle(FurnitureItem item) {
        vehicle.loadItem(item);
    }

    public void deliver(FurnitureShipment shipment) {
    System.out.println("Starting delivery of shipment " + shipment.getShipmentID());

    // Simulate driving to the destination
    System.out.println("Starting journey to " + shipment.getDestination() + "...");
    simulateDriving(shipment);

    // Simulate unloading items
    System.out.println("Arrived at " + shipment.getDestination() + ". Unloading items...");
    simulateUnloading(shipment);

    // Update shipment status
    shipment.setStatus("Delivered");
    System.out.println("Shipment " + shipment.getShipmentID() + " status updated to Delivered");
}

@Override
public void performTask() {
    System.out.println("Performing delivery task");
    // Assume the shipment to deliver is obtained from some external source
    FurnitureShipment shipment = obtainShipmentToDeliver();
    loadVehicle(shipment.getItem()); // Simulate loading items onto the vehicle
    deliver(shipment); // Simulate the delivery process
}

private void simulateDriving(FurnitureShipment shipment) {
    // Simulate driving process with delays
    for (String location : shipment.getRoute().getLocations()) {
        System.out.println("Driving to: " + location);
        try {
            Thread.sleep(2000); // Simulate travel time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

private void simulateUnloading(FurnitureShipment shipment) {
    // Simulate unloading process for each item
    for (FurnitureItem item : vehicle.getItems()) {
        System.out.println("Unloading item: " + item.getFurnitureID());
        try {
            Thread.sleep(1000); // Simulate unloading time for each item
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

private FurnitureShipment obtainShipmentToDeliver() {
    // In a real scenario, this method would fetch the shipment to deliver from a database or another system
    // For demonstration purposes, we'll create a mock shipment here
    FurnitureItem item = new FurnitureItem("123", "Table", "100x60x80", "20kg");
    Customer sender = new Customer("C001", "Sender Name", "Sender Address", "Sender Contact Info");
    Customer receiver = new Customer("C002", "Receiver Name", "Receiver Address", "Receiver Contact Info");
    
    // Create a mock route
    Route route = new Route("R001", "Origin", "Destination", 100.0, 2.5); // Adjust parameters as needed
    
    return new FurnitureShipment(1, sender, receiver, "Destination", "Pending", new Date(), item, route);
}





    // Getters and Setters
    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}



