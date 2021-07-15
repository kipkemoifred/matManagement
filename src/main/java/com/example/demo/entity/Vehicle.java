package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Vehicle {
    @GeneratedValue
    @Id
    private int vehicleId;
    private String type;//bus
    private String maxPassengers;
    private String numberPlate;

    public Vehicle(String type, String maxPassengers, String numberPlate) {
        this.type = type;
        this.maxPassengers = maxPassengers;
        this.numberPlate = numberPlate;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(String maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", type='" + type + '\'' +
                ", maxPassengers='" + maxPassengers + '\'' +
                ", numberPlate='" + numberPlate + '\'' +
                '}';
    }
}
