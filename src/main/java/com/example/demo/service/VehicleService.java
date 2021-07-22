package com.example.demo.service;
import com.example.demo.entity.Vehicle;
import com.example.demo.exception.VehicleNotFoundException;
import com.example.demo.repository.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepo vehicleRepo;

    public VehicleService() {
    }

    public List<Vehicle> getVehicles(){
        return vehicleRepo.findAll();

    }
    public Vehicle getVehicle(int vehicleId) throws VehicleNotFoundException {
        return vehicleRepo.findById(vehicleId).orElseThrow(()->new VehicleNotFoundException(vehicleId));

    }
    public Vehicle addVehicle(Vehicle vehicle){
        return vehicleRepo.save(vehicle);
    }
    public Vehicle updateVehicle(int vehicleId,Vehicle vehicleDetails) throws VehicleNotFoundException {
        Vehicle vehicle=vehicleRepo.findById(vehicleId).orElseThrow(()-> new VehicleNotFoundException(vehicleId));
        vehicle.setVehicleId(vehicleDetails.getVehicleId());
        vehicle.setMaxPassengers(vehicleDetails.getMaxPassengers());
        vehicle.setNumberPlate(vehicleDetails.getNumberPlate());
        vehicle.setType(vehicleDetails.getType());
        Vehicle updatedVehicle=vehicleRepo.save(vehicle);
        return updatedVehicle;
    }
}
