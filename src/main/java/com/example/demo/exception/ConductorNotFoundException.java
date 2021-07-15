package com.example.demo.exception;



public class ConductorNotFoundException extends Exception {
    private int conductorId;
    public ConductorNotFoundException(int conductorId){
        super(String.format("conductor not found with id '%s'",conductorId));
    }
}