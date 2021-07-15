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

    public Expenditure(int expenditureId, String expenditureType) {
        this.expenditureId = expenditureId;
        this.expenditureType = expenditureType;
    }

    public int getExpenditureId() {
        return expenditureId;
    }

    public void setExpenditureId(int expenditureId) {
        this.expenditureId = expenditureId;
    }

    @Override
    public String toString() {
        return "Expenditure{" +
                "expenditureId=" + expenditureId +
                ", expenditureType='" + expenditureType + '\'' +
                '}';
    }
}
