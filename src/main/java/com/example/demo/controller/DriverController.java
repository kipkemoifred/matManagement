package com.example.demo.controller;
import com.example.demo.entity.Driver;
import com.example.demo.exception.DriverNotFoundException;
import com.example.demo.repository.DriverRepo;
import com.example.demo.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/api/")
public class DriverController {
    @Autowired
    private DriverService driverService;
    @Autowired
    private DriverRepo driverRepo;

    @PostMapping(value="/driver")
    Driver addNewDriver(@RequestBody Driver driver){
        return driverService.addDriver(driver);
    }


    //
//    @GetMapping(value = "/user/{userId}") @PostMapping
////
////    @DeleteMapping
////    @PutMapping
    @GetMapping(value = "/driver/{driverId}")
    public Driver getSpecificDriver(@PathVariable("driverId") int driverId) throws DriverNotFoundException {
        return driverService.getDriver(driverId);

    }

    @GetMapping("/drivers")
    public List<Driver> getAllDrivers(){
        return driverService.getDrivers();
    }
    @PutMapping(value = "/driver/{driverId}")
    public Driver updateDriver(@RequestBody Driver driver) throws DriverNotFoundException {
        return driverService.updateDriver(driver.getDriverId(),driver);
    }
    @DeleteMapping("/driver/{driverId}")
    public ResponseEntity<?> deleteDriver(@PathVariable(value = "driverId") int driverId) throws DriverNotFoundException {
        Driver driver = driverRepo.findById(driverId)
                .orElseThrow(() -> new DriverNotFoundException(driverId));

        driverRepo.delete(driver);

        return ResponseEntity.ok().build();
    }
}


