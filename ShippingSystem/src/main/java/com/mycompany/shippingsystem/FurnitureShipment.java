/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shippingsystem;

import java.util.Date;

public class FurnitureShipment {
    private int shipmentID;
    private Customer sender;
    private Customer receiver;
    private String destination;
    private String status;
    private Date deliveryDate;
    private FurnitureItem item;
    private Route route;
    private String assignedEmployeeName; 

    public FurnitureShipment(int shipmentID, Customer sender, Customer receiver, String destination, String status, Date deliveryDate, FurnitureItem item,Route route) {
        this.shipmentID = shipmentID;
        this.sender = sender;
        this.receiver = receiver;
        this.destination = destination;
        this.status = status;
        this.deliveryDate = deliveryDate;
        this.item = item;
        this.route = route;
    }

    // Getter and setter methods for the assigned employee's name
   public void updateStatus(String status) {
        if (isValidStatus(status)) {
            this.status = status;
            System.out.println("Shipment " + shipmentID + " status updated to: " + status);
        } else {
            System.out.println("Invalid status: " + status);
        }
    }

    // Method to assign the shipment to an employee
    public void assignToEmployee(Employee employee) {
        if (employee != null) {
            this.assignedEmployeeName = employee.getEmployeeName();
            System.out.println("Shipment " + shipmentID + " assigned to employee: " + assignedEmployeeName);
        } else {
            System.out.println("Cannot assign shipment to null employee.");
        }
    }

    // Helper method to validate the status
    private boolean isValidStatus(String status) {
        // Define valid status values here (e.g., "Pending," "In Progress," "Delivered")
        String[] validStatuses = {"Pending", "In Progress", "Delivered"};
        for (String validStatus : validStatuses) {
            if (validStatus.equalsIgnoreCase(status)) {
                return true;
            }
        }
        return false;
    }

    // Getters and Setters
    public int getShipmentID() { 
        return shipmentID; 
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
    
    public void setShipmentID(int shipmentID) {
        this.shipmentID = shipmentID; 
    }
    public Customer getSender() { 
        return sender;
    }
    public void setSender(Customer sender) {
        this.sender = sender;
    }
    public Customer getReceiver() { 
        return receiver;
    }
    public void setReceiver(Customer receiver) { 
        this.receiver = receiver; 
    }
    public String getDestination() { 
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status; 
    }
    public Date getDeliveryDate() { 
        return deliveryDate;
    }
    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate; 
    }
    public FurnitureItem getItem() {
        return item;
    }
    public void setItem(FurnitureItem item) {
        this.item = item;
    }
    public String getAssignedEmployeeName() {
        return assignedEmployeeName;
    }

    public void setAssignedEmployeeName(String assignedEmployeeName) {
        this.assignedEmployeeName = assignedEmployeeName;
    }
}



