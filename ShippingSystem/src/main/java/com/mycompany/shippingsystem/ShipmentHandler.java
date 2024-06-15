/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.shippingsystem;

/**
 *
 * @author User
 */
public interface ShipmentHandler {
    void assignShipment(FurnitureShipment shipment);
    void updateShipmentStatus(FurnitureShipment shipment, String status);
}
