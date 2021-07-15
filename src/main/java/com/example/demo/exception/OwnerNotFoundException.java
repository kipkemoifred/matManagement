package com.example.demo.exception;



public class OwnerNotFoundException extends Exception {
    private int ownerId;
    public OwnerNotFoundException(int ownerId){
        super(String.format("owner not found with id '%s'",ownerId));
    }
}


