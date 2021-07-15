package com.example.demo.exception;

public class DriverNotFoundException extends Exception {
    private int driverId;
    public DriverNotFoundException(int driverId){
        super(String.format("driver not found with id '%s'",driverId));
    }
}