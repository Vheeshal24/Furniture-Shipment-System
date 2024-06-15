/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shippingsystem;

import java.util.Date;
import java.util.Scanner;

public class Payment {
    private String paymentID;
    private double amount;
    private Date date;
    private String status;

    public Payment(String paymentID, double amount, Date date, String status) {
        this.paymentID = paymentID;
        this.amount = amount;
        this.date = date;
        this.status = status;
    }


public void processPayment(String paymentType) {
    // Implementation
    System.out.println("Processing " + paymentType + " payment of amount: " + amount);
    
    // Instead of directly reading from System.in, let's pass a Scanner object to the method
    Scanner scanner = new Scanner(System.in);
    String confirmation = getUserConfirmation(scanner, "Confirm " + paymentType + " payment? (yes/no): ");
    
    // Validate user input
    if (confirmation.equalsIgnoreCase("yes")) {
        this.status = "Processed";
        System.out.println(paymentType + " payment processed successfully.");
    } else if (confirmation.equalsIgnoreCase("no")) {
        System.out.println(paymentType + " payment cancelled.");
    } else {
        System.out.println("Invalid input. " + paymentType + " payment cancelled.");
    }
}

// Helper method to get user confirmation
private String getUserConfirmation(Scanner scanner, String prompt) {
    System.out.print(prompt);
    return scanner.nextLine();
}


    public void updateStatus(String status) {
        this.status = status;
    }

    // Getters and Setters
    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


