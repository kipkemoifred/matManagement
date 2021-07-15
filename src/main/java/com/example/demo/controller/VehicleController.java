package com.example.demo.controller;

import com.example.demo.entity.Vehicle;

import com.example.demo.exception.VehicleNotFoundException;
import com.example.demo.repository.VehicleRepo;

import com.example.demo.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/api/")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private VehicleRepo vehicleRepo;

    @PostMapping(value="/vehicle")
    Vehicle addNewCompany(@RequestBody Vehicle vehicle){
        return vehicleService.addVehicle(vehicle);
    }


    //
//    @GetMapping(value = "/user/{userId}") @PostMapping
////
////    @DeleteMapping
////    @PutMapping
    @GetMapping(value = "/vehicle/{vehicle}")
    public Vehicle getSpecificVehicle(@PathVariable("vehicleId") int vehicleId) throws VehicleNotFoundException {
        return vehicleService.getVehicle(vehicleId);


    }

    @GetMapping("/vehicles")
    public List<Vehicle> getAllVehicles(){
        return vehicleService.getVehicles();
    }
    @PutMapping(value = "/vehicle/{vehicleId}")
    public Vehicle updateVehicle(@RequestBody Vehicle vehicle) throws VehicleNotFoundException {
        return vehicleService.updateVehicle(vehicle.getVehicleId(), vehicle);
    }
    @DeleteMapping("/vehicle/{vehicleId}")
    public ResponseEntity<?> deleteVehicle(@PathVariable(value = "vehicleId") int vehicleId) throws VehicleNotFoundException {
        Vehicle vehicle = vehicleRepo.findById(vehicleId)
                .orElseThrow(() -> new VehicleNotFoundException(vehicleId));

        vehicleRepo.delete(vehicle);

        return ResponseEntity.ok().build();
    }
}





