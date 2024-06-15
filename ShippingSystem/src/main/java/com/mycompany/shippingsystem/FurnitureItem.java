/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shippingsystem;

/**
 *
 * @author User
 */
public class FurnitureItem {
    private String furnitureID;
    private String description;
    private String dimensions;
    private String weight;

    public FurnitureItem(String furnitureID, String description, String dimensions, String weight) {
        this.furnitureID = furnitureID;
        this.description = description;
        this.dimensions = dimensions;
        this.weight = weight;
    }

    // Getters and Setters
    public String getFurnitureID() {
        return furnitureID;
    }
    public void setFurnitureID(String furnitureID) {
        this.furnitureID = furnitureID; }
    public String getDescription() { 
        return description;
    }
    public void setDescription(String description) { 
        this.description = description;
    }
    public String getDimensions() { 
        return dimensions; 
    }
    public void setDimensions(String dimensions) { 
        this.dimensions = dimensions;
    }
    public String getWeight() { 
        return weight; 
    }
    public void setWeight(String weight) {
        this.weight = weight; 
    }
}

