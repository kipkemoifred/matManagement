package com.example.demo.repository;

import com.example.demo.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PassengerRepo extends JpaRepository<Passenger, Integer> {
}
