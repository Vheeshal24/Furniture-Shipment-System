package com.mycompany.shippingsystem;

import java.util.Scanner;
import java.util.Date;


public class Customer {
    private String custID;
    private String custName;
    private String custAddress;
    private String contactInfo;

    public Customer(String custID, String custName, String custAddress, String contactInfo) {
        this.custID = custID;
        this.custName = custName;
        this.custAddress = custAddress;
        this.contactInfo = contactInfo;
    }

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public static FurnitureShipment placeOrder(Scanner scanner) {
        System.out.println("Interactive Order Placement");

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

       return new FurnitureShipment(1, sender, receiver, "456 Avenue, City", "Pending", new Date(), furnitureItem, null);
    }
    public void placeOrder(Customer receiver, FurnitureItem item, String destination, int shipmentID) {
    // include any additional logic related to placing the order, such as updating databases,

    // Output a message indicating that the order is being placed
    System.out.println("Placing order for shipment ID " + shipmentID + " from customer " + this.getCustName() + " to receiver " + receiver.getCustName());
}

}



