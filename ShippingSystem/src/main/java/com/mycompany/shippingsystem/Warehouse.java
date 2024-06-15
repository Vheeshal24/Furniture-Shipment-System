package com.mycompany.shippingsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Warehouse {
    private String warehouseID;
    private String location;
    private int capacity;
    private ArrayList<FurnitureItem> items;

    public Warehouse(String warehouseID, String location, int capacity) {
        this.warehouseID = warehouseID;
        this.location = location;
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    public void storeItem(FurnitureItem item) {
        items.add(item);
        System.out.println("Stored item: " + item.getFurnitureID());
    }

    public void retrieveItem(FurnitureItem item) {
        items.remove(item);
        System.out.println("Retrieved item: " + item.getFurnitureID());
    }

    public void addItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adding new item to the warehouse:");
        System.out.print("Enter item ID: ");
        String itemID = scanner.nextLine();
        System.out.print("Enter item description: ");
        String description = scanner.nextLine();
        System.out.print("Enter item dimensions: ");
        String dimensions = scanner.nextLine();
        System.out.print("Enter item weight: ");
        String weight = scanner.nextLine();

        FurnitureItem newItem = new FurnitureItem(itemID, description, dimensions, weight);
        storeItem(newItem);
    }

    public void updateItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Updating item details:");
        System.out.print("Enter item ID to update: ");
        String itemID = scanner.nextLine();
        for (FurnitureItem item : items) {
            if (item.getFurnitureID().equals(itemID)) {
                System.out.print("Enter new description: ");
                item.setDescription(scanner.nextLine());
                System.out.print("Enter new dimensions: ");
                item.setDimensions(scanner.nextLine());
                System.out.print("Enter new weight: ");
                item.setWeight(scanner.nextLine());
                System.out.println("Item details updated successfully.");
                return;
            }
        }
        System.out.println("Item with ID " + itemID + " not found.");
    }

    public void removeItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Removing item from the warehouse:");
        System.out.print("Enter item ID to remove: ");
        String itemID = scanner.nextLine();
        for (FurnitureItem item : items) {
            if (item.getFurnitureID().equals(itemID)) {
                retrieveItem(item);
                return;
            }
        }
        System.out.println("Item with ID " + itemID + " not found.");
    }

    // Getters and Setters
    public String getWarehouseID() {
        return warehouseID;
    }

    public void setWarehouseID(String warehouseID) {
        this.warehouseID = warehouseID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ArrayList<FurnitureItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<FurnitureItem> items) {
        this.items = items;
    }
}
