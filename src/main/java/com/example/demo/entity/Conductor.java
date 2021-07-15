package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Conductor {
    @GeneratedValue
    @Id
    private int conductorId;
    private String fName;
    private String lName;
    private String phoneNumber;
    private String idNumber;

    public Conductor(String fName, String lName, String phoneNumber, String idNumber) {
        this.fName = fName;
        this.lName = lName;
        this.phoneNumber = phoneNumber;
        this.idNumber = idNumber;
    }
    public Conductor(){}

    public int getConductorId() {
        return conductorId;
    }

    public void setConductorId(int conductorId) {
        this.conductorId = conductorId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public String toString() {
        return "Conductor{" +
                "conductorId=" + conductorId +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", idNumber='" + idNumber + '\'' +
                '}';
    }
    //vehicle
    //driver

}
