package com.example.demo.exception;

public class CompanyNotFoundException extends Exception {
    private int companyId;
    public CompanyNotFoundException(int companyId){
        super(String.format("company not found with id '%s'",companyId));
    }
}
