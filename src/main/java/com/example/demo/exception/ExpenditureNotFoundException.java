package com.example.demo.exception;



    public class ExpenditureNotFoundException extends Exception {
        private int expenditureId;
        public ExpenditureNotFoundException(int expenditureId){
            super(String.format("expenditure not found with id '%s'",expenditureId));
        }
    }

