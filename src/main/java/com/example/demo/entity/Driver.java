package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Driver {
    @GeneratedValue
    @Id
    private int driverId;
    private String fName;
    private String lName;
    private String phoneNumber;
    private String idNumber;
    private String dlInfo;

    public Driver( String fName, String lName, String phoneNumber, String idNumber, String dlInfo) {

        this.fName = fName;
        this.lName = lName;
        this.phoneNumber = phoneNumber;
        this.idNumber = idNumber;
        this.dlInfo = dlInfo;
    }
    public Driver(){}

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
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

    public String getDlInfo() {
        return dlInfo;
    }

    public void setDlInfo(String dlInfo) {
        this.dlInfo = dlInfo;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverId=" + driverId +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", dlInfo='" + dlInfo + '\'' +
                '}';
    }
}
