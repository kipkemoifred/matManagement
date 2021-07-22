package com.example.demo.controller;
import com.example.demo.entity.Passenger;

import com.example.demo.exception.PassengerNotFoundException;
import com.example.demo.repository.PassengerRepo;

import com.example.demo.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/api/")
public class PassengerController {
    @Autowired
    private PassengerService passengerService;
    @Autowired
    private PassengerRepo passengerRepo;

    @PostMapping(value="/addNewPassenger")
    Passenger addNewPassenger(@RequestBody Passenger passenger){
        return passengerService.addPassenger(passenger);
    }


    //
//    @GetMapping(value = "/user/{userId}") @PostMapping
////
////    @DeleteMapping
////    @PutMapping
    @GetMapping(value = "/passenger/{passengerId}")
    public Passenger getSpecificPassenger(@PathVariable("passengerId") int passengerId) throws PassengerNotFoundException {
        return passengerService.getPassenger(passengerId);

    }

    @GetMapping("/passengers")
    public List<Passenger> getAllPassengers(){
        return passengerService.getPassengers();
    }
    @PutMapping(value = "/passenger/{passengerId}")
    public Passenger updatePassenger(@RequestBody Passenger passenger) throws PassengerNotFoundException {
        return passengerService.updatePassenger(passenger.getPassengerId(), passenger);
    }
    @DeleteMapping("/passenger/{passengerId}")
    public ResponseEntity<?> deletePassenger(@PathVariable(value = "passengerId") int passengerId) throws PassengerNotFoundException {
        Passenger passenger = passengerRepo.findById(passengerId)
                .orElseThrow(() -> new PassengerNotFoundException(passengerId));

        passengerRepo.delete(passenger);

        return ResponseEntity.ok().build();
    }
}





