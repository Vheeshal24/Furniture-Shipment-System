/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.shippingsystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.List;



public class ShippingSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        Admin admin = new Admin("A001", "Admin User", "Admin", "admin@company.com");
        employees.add(admin);  // Add admin to the employee list

        Customer sender = new Customer("C001", "John Doe", "123 Street, City", "1234567890");
        Customer receiver = new Customer("C002", "Jane Smith", "456 Avenue, City", "0987654321");
        FurnitureItem furnitureItem = new FurnitureItem("F001", "Wooden Table", "5x5x3", "20kg");
        Route route = new Route("R001", "123 Street, City", "456 Avenue, City", 50.0, 2.5);
        route.addLocation("Intermediate Location 1");
        route.addLocation("Intermediate Location 2");
        route.addLocation("Intermediate Location 3");
        FurnitureShipment shipment = new FurnitureShipment(1, sender, receiver, "456 Avenue, City", "Pending", new Date(), furnitureItem, route);

        Manager manager = new Manager(); // Creating a Manager instance
        manager.setEmployeeID("E001");
        manager.setEmployeeName("Alice");
        manager.setRole("Manager");
        manager.setContactInfo("alice@company.com");
        employees.add(manager);

        Vehicle vehicle = new Vehicle("V001", "Truck", 5000.0, 5.5, 2.2, 2.0);
        DeliveryPerson deliveryPerson = new DeliveryPerson("E002", "Bob", "Driver", "bob@company.com", vehicle);
        employees.add(deliveryPerson);

        Warehouse warehouse = new Warehouse("W001", "789 Warehouse Lane, City", 100);

        Payment payment = new Payment("P001", 200.0, new Date(), "Pending");

        Delivery delivery = new Delivery("D001", "Truck", route, 20);

        while (true) {
            System.out.println("\nFurniture Shipping and Delivery System");
            System.out.println("1. Place an Order");
            System.out.println("2. Assign Shipment to Admin");
            System.out.println("3. Update Shipment Status");
            System.out.println("4. Process Payment");
            System.out.println("5. Load Vehicle");
            System.out.println("6. Deliver Shipment");
            System.out.println("7. Store Item in Warehouse");
            System.out.println("8. Retrieve Item from Warehouse");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    placeOrder();
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    if (!isAdminLoggedIn()) {
                        System.out.println("Access Denied. Only admins can use this feature.");
                        break;
                    }
                    handleAdminOption(choice, admin, manager, deliveryPerson, shipment, furnitureItem, warehouse, payment);
                    break;
                case 9:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static boolean isAdminLoggedIn() {
        // For simplicity, assume the first employee in the list is the admin
        return employees.get(0).getRole().equals("Admin");
    }

    private static void handleAdminOption(int choice, Admin admin, Manager manager, DeliveryPerson deliveryPerson, FurnitureShipment shipment, FurnitureItem furnitureItem, Warehouse warehouse, Payment payment) {
        switch (choice) {
            case 2:
                assignShipmentInteractively(manager, scanner, shipment);
                break;
            case 3:
                updateShipmentStatus(shipment);
                break;
            case 4:
                processPayment(payment);
                break;
            case 5:
                loadVehicle(deliveryPerson, furnitureItem);
                break;
            case 6:
                deliverShipment(deliveryPerson, shipment);
                break;
            case 7:
                storeItemInWarehouse(warehouse, furnitureItem);
                break;
            case 8:
                retrieveItemFromWarehouse(warehouse, furnitureItem);
                break;
        }
    }

    private static void placeOrder() {
    System.out.println("Order Placement");
    System.out.print("Enter customer ID: ");
    String custID = scanner.nextLine();
    System.out.print("Enter customer name: ");
    String custName = scanner.nextLine();
    System.out.print("Enter customer address: ");
    String custAddress = scanner.nextLine();
    System.out.print("Enter customer contact info: ");
    String contactInfo = scanner.nextLine();

    Customer sender = new Customer(custID, custName, custAddress, contactInfo);

    System.out.print("Enter receiver ID: ");
    String receiverID = scanner.nextLine();
    System.out.print("Enter receiver name: ");
    String receiverName = scanner.nextLine();
    System.out.print("Enter receiver address: ");
    String receiverAddress = scanner.nextLine();
    System.out.print("Enter receiver contact info: ");
    String receiverContactInfo = scanner.nextLine();

    Customer receiver = new Customer(receiverID, receiverName, receiverAddress, receiverContactInfo);

    System.out.print("Enter item ID: ");
    String itemID = scanner.nextLine();
    System.out.print("Enter item description: ");
    String description = scanner.nextLine();
    System.out.print("Enter item dimensions: ");
    String dimensions = scanner.nextLine();
    System.out.print("Enter item weight: ");
    String weight = scanner.nextLine();

    FurnitureItem furnitureItem = new FurnitureItem(itemID, description, dimensions, weight);

    System.out.print("Enter destination: ");
    String destination = scanner.nextLine();

    System.out.print("Enter shipment ID: ");
    int shipmentID = scanner.nextInt();
    scanner.nextLine(); // Consume newline

FurnitureShipment shipment = new FurnitureShipment(1, sender, receiver, "456 Avenue, City", "Pending", new Date(), furnitureItem,null);

    // Call the original placeOrder method with the dynamically created objects
    placeOrder(sender, receiver, furnitureItem, shipment, destination, shipmentID);

}

private static void placeOrder(Customer sender, Customer receiver, FurnitureItem furnitureItem, FurnitureShipment shipment, String destination, int shipmentID) {
    System.out.println("Placing order...");
    sender.placeOrder(receiver, furnitureItem, destination, shipmentID);
    System.out.println("Order placed by " + sender.getCustName() + " for shipment ID " + shipment.getShipmentID());
}

    private static void assignShipmentInteractively(Employee employee, Scanner scanner, FurnitureShipment shipment) {
        System.out.println("Assigning shipment...");

        System.out.print("Enter employee ID: ");
        String employeeID = scanner.nextLine();
        employee.setEmployeeID(employeeID);

        employee.assignShipment(shipment);
        System.out.println("Shipment " + shipment.getShipmentID() + " assigned to employee " + employee.getEmployeeName());
    }
 
    
    // Method to add employees to the list (for demonstration purposes)
    public static void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // Method to retrieve an employee by ID
    public static Employee getEmployeeById(String employeeID) {
        for (Employee employee : employees) {
            if (employee.getEmployeeID().equals(employeeID)) {
                return employee; // Found the employee with the given ID
            }
        }
        return null; // Employee with the given ID not found
    }

    // Method to remove an employee from the list
    public static void removeEmployee(String employeeID) {
        employees.removeIf(employee -> employee.getEmployeeID().equals(employeeID));
    }

    // Method to add employees to the list
    private static void updateShipmentStatus(FurnitureShipment shipment) {
    System.out.print("Enter new status: ");
    String status = scanner.nextLine();
    shipment.updateStatus(status);

    System.out.print("Enter employee ID to assign: ");
    String employeeID = scanner.nextLine();
    // Get the employee object based on the ID, possibly from a manager class or employee repository
    Employee employee = getEmployeeById(employeeID);
    shipment.assignToEmployee(employee);
}



    private static void processPayment(Payment payment) {
    Scanner scanner = new Scanner(System.in);
    payment.processPayment("Cash"); // Assuming cash payment for now
}

    private static void loadVehicle(DeliveryPerson deliveryPerson, FurnitureItem furnitureItem) {
        deliveryPerson.loadVehicle(furnitureItem);
    }

    private static void deliverShipment(DeliveryPerson deliveryPerson, FurnitureShipment shipment) {
    deliveryPerson.deliver(shipment);
}


    private static void storeItemInWarehouse(Warehouse warehouse, FurnitureItem furnitureItem) {
        warehouse.storeItem(furnitureItem);
    }

    private static void retrieveItemFromWarehouse(Warehouse warehouse, FurnitureItem furnitureItem) {
        warehouse.retrieveItem(furnitureItem);
    }
}
