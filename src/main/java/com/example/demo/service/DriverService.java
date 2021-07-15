package com.example.demo.service;
import com.example.demo.entity.Driver;
import com.example.demo.exception.DriverNotFoundException;
import com.example.demo.repository.DriverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {
    @Autowired
    private DriverRepo driverRepo;

    public DriverService() {
    }

    public List<Driver> getDrivers(){
        return driverRepo.findAll();

    }
    public Driver getDriver(int driverId) throws DriverNotFoundException {
        return driverRepo.findById(driverId).orElseThrow(()->new DriverNotFoundException(driverId));

    }
    public Driver addDriver(Driver driver){
        return driverRepo.save(driver);
    }
    public Driver updateDriver(int driverId,Driver driverDetails) throws DriverNotFoundException {
        Driver driver=driverRepo.findById(driverId).orElseThrow(()-> new DriverNotFoundException(driverId));
        driver.setDriverId(driverDetails.getDriverId());
        driver.setfName(driverDetails.getfName());
        Driver updatedDriver=driverRepo.save(driver);
        return updatedDriver;
    }
}
