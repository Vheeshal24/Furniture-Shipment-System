/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shippingsystem;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private String routeID;
    private String startLocation;
    private String endLocation;
    private double distance;
    private double duration;
    private List<String> locations;

    public Route(String routeID, String startLocation, String endLocation, double distance, double duration) {
        this.routeID = routeID;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.distance = distance;
        this.duration = duration;
        this.locations = new ArrayList<>();
    }

    public String getRouteID() {
        return routeID;
    }

    public void setRouteID(String routeID) {
        this.routeID = routeID;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void addLocation(String location) {
        locations.add(location);
    }
}


