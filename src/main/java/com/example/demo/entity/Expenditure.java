package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Expenditure {
    @GeneratedValue
    @Id
    private int expenditureId;
    private String expenditureType;
    private double expenditureAmount;

    public Expenditure( String expenditureType,double expenditureAmount) {

        this.expenditureType = expenditureType;
        this.expenditureAmount=expenditureAmount;
    }
    public Expenditure(){}

    public int getExpenditureId() {
        return expenditureId;
    }

    public void setExpenditureId(int expenditureId) {
        this.expenditureId = expenditureId;
    }

    public String getExpenditureType() {
        return expenditureType;
    }

    public void setExpenditureType(String expenditureType) {
        this.expenditureType = expenditureType;
    }

    public double getExpenditureAmount() {
        return expenditureAmount;
    }

    public void setExpenditureAmount(double expenditureAmount) {
        this.expenditureAmount = expenditureAmount;
    }

    @Override
    public String toString() {
        return "Expenditure{" +
                "expenditureId=" + expenditureId +
                ", expenditureType='" + expenditureType + '\'' +
                ", expenditureAmount='" + expenditureAmount + '\'' +
                '}';
    }
}
