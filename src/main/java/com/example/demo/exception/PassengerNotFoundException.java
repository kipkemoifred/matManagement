package com.example.demo.exception;




public class PassengerNotFoundException extends Exception {
    private int passengerId;
    public PassengerNotFoundException(int passengerId){
        super(String.format("company not found with id '%s'",passengerId));
    }
}


