package com.example.demo.exception;



public class VehicleNotFoundException extends Exception {
    private int vehicleId;
    public VehicleNotFoundException(int vehicleId){
        super(String.format("vehicle not found with id '%s'",vehicleId));
    }
}


