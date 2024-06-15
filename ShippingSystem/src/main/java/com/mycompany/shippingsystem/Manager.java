/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shippingsystem;

/**
 *
 * @author User
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Manager extends Employee  {
    private ArrayList<Employee> team;

    public Manager() {
        team = new ArrayList<>();
    }

    public void manageTeam() {
        System.out.println("Managing team");
    }

    @Override
    public void performTask() {
        System.out.println("Manager " + getEmployeeName() + " is managing tasks.");
    }
    
    public void addTeamMember(Employee employee) {
        team.add(employee);
    }

    public ArrayList<Employee> getTeam() {
        return team;
    }

    // New method for dynamic shipment assignment
    public void dynamicShipmentAssignment(ArrayList<FurnitureShipment> availableShipments) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Available Shipments:");
    for (FurnitureShipment shipment : availableShipments) {
        System.out.println(shipment.getShipmentID() + ": " + shipment.getStatus());
    }
    System.out.print("Enter shipment ID to assign: ");
    int shipmentID = scanner.nextInt();
    scanner.nextLine(); // Consume newline

    FurnitureShipment selectedShipment = findShipmentByID(availableShipments, shipmentID);
    if (selectedShipment != null) {
        assignShipmentToEmployee(selectedShipment);
    } else {
        System.out.println("Invalid shipment ID.");
    }
}

// Helper method to find a shipment by ID
private FurnitureShipment findShipmentByID(ArrayList<FurnitureShipment> shipments, int shipmentID) {
    for (FurnitureShipment shipment : shipments) {
        if (shipment.getShipmentID() == shipmentID) {
            return shipment;
        }
    }
    return null; // Shipment not found
}

// Helper method to assign a shipment to the current employee
private void assignShipmentToEmployee(FurnitureShipment shipment) {
    shipment.setStatus("Assigned");
    System.out.println("Shipment " + shipment.getShipmentID() + " assigned to " + this.getEmployeeName());
}

}
