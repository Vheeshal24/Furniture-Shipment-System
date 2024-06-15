/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shippingsystem;

/**
 *
 * @author User
 */
public abstract class Employee implements ShipmentHandler {
    private String employeeID;
    private String employeeName;
    private String role;
    String contactInfo;
    
    public abstract void performTask();
    
    @Override
    public void assignShipment(FurnitureShipment shipment) {
    if (shipment == null) {
        System.out.println("Cannot assign a null shipment.");
        return;
    }
    
    // Check if the employee can handle the shipment based on their role or other criteria
    if (!canHandleShipment(shipment)) {
        System.out.println("Employee " + employeeName + " cannot handle shipment " + shipment.getShipmentID() + ".");
        return;
    }
    
    // Assign the shipment to the employee
    shipment.setAssignedEmployeeName(employeeName); // Update the assigned employee name in the shipment
    System.out.println("Shipment " + shipment.getShipmentID() + " assigned to employee " + employeeName);
}

    @Override
    public void updateShipmentStatus(FurnitureShipment shipment, String status) {
    if (shipment == null) {
        System.out.println("Cannot update status for a null shipment.");
        return;
    }
    
    // Check if the employee is assigned to the shipment
    if (!isAssignedToShipment(shipment)) {
        System.out.println("Employee " + employeeName + " is not assigned to shipment " + shipment.getShipmentID() + ".");
        return;
    }
    
    // Update the shipment status
    shipment.setStatus(status);
    System.out.println("Shipment " + shipment.getShipmentID() + " status updated to " + status + " by employee " + employeeName);
}

// Method to check if the employee can handle the shipment
private boolean canHandleShipment(FurnitureShipment shipment) {
    return true; // For now, assume all employees can handle all shipments
}

// Method to check if the employee is assigned to the shipment
private boolean isAssignedToShipment(FurnitureShipment shipment) {
    return shipment.getAssignedEmployeeName().equals(employeeName);
}

    // Getters and Setters
    public String getEmployeeID() { 
        return employeeID;
    }
    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID; 
    }
    public String getEmployeeName() { 
        return employeeName;
    }
    public void setEmployeeName(String employeeName) { 
        this.employeeName = employeeName; 
    }
    public String getRole() { 
        return role;
    }
    public void setRole(String role) { 
        this.role = role;
    }
    public String getContactInfo() {
        return contactInfo;
    }
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}

