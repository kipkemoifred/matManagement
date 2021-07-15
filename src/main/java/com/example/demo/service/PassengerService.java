package com.example.demo.service;
import com.example.demo.entity.Passenger;
import com.example.demo.exception.PassengerNotFoundException;
import com.example.demo.repository.PassengerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {
    @Autowired
    private PassengerRepo passengerRepo;

    public PassengerService() {
    }

    public List<Passenger> getPassengers(){
        return passengerRepo.findAll();

    }
    public Passenger getPassenger(int passengerId) throws PassengerNotFoundException {
        return passengerRepo.findById(passengerId).orElseThrow(()->new PassengerNotFoundException(passengerId));

    }
    public Passenger addPassenger(Passenger owner){
        return passengerRepo.save(owner);
    }
    public Passenger updatePassenger(int passengerId,Passenger passengerDetails) throws PassengerNotFoundException {
        Passenger passenger=passengerRepo.findById(passengerId).orElseThrow(()-> new PassengerNotFoundException(passengerId));
        passenger.setPassengerId(passengerDetails.getPassengerId());
        //expenditure.(expenditureDetails.getfName());
        Passenger updatedPassenger=passengerRepo.save(passenger);
        return updatedPassenger;
    }
}
