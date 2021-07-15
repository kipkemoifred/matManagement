package com.example.demo.controller;
import com.example.demo.entity.Conductor;
import com.example.demo.exception.ConductorNotFoundException;
import com.example.demo.repository.ConductorRepo;
import com.example.demo.service.ConductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/api/")
public class ConductorController {
    @Autowired
    private ConductorService conductorService;
    @Autowired
    private ConductorRepo conductorRepo;

    @PostMapping(value="/company")
    Conductor addNewConductor(@RequestBody Conductor conductor){
        return conductorService.addConductor(conductor);
    }


    //
//    @GetMapping(value = "/user/{userId}") @PostMapping
////
////    @DeleteMapping
////    @PutMapping
    @GetMapping(value = "/conductor/{conductorId}")
    public Conductor getSpecificConductor(@PathVariable("conductorId") int conductorId) throws ConductorNotFoundException {
        return conductorService.getConductor(conductorId);

    }

    @GetMapping("/conductors")
    public List<Conductor> getAllConductors(){
        return conductorService.getConductors();
    }
    @PutMapping(value = "/conductor/{companyId}")
    public Conductor updateConductor(@RequestBody Conductor conductor) throws ConductorNotFoundException {
        return conductorService.updateConductor(conductor.getConductorId(), conductor);
    }
    @DeleteMapping("/conductor/{conductorId}")
    public ResponseEntity<?> deleteCompany(@PathVariable(value = "conductorId") int conductorId) throws ConductorNotFoundException {
        Conductor conductor = conductorRepo.findById(conductorId)
                .orElseThrow(() -> new ConductorNotFoundException(conductorId));

        conductorRepo.delete(conductor);

        return ResponseEntity.ok().build();
    }
}

