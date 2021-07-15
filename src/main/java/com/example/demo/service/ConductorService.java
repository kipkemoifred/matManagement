package com.example.demo.service;
import com.example.demo.entity.Conductor;
import com.example.demo.exception.ConductorNotFoundException;
import com.example.demo.repository.ConductorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConductorService {
    @Autowired
    private ConductorRepo conductorRepo;

    public ConductorService() {
    }

    public List<Conductor> getConductors(){
        return conductorRepo.findAll();

    }
    public Conductor getConductor(int conductorId) throws ConductorNotFoundException {
        return conductorRepo.findById(conductorId).orElseThrow(()->new ConductorNotFoundException(conductorId));

    }
    public Conductor addConductor(Conductor company){
        return conductorRepo.save(company);
    }
    public Conductor updateConductor(int conductorId,Conductor companyDetails) throws ConductorNotFoundException {
        Conductor conductor=conductorRepo.findById(conductorId).orElseThrow(()-> new ConductorNotFoundException(conductorId));
        conductor.setConductorId(companyDetails.getConductorId());
        conductor.setfName(companyDetails.getfName());
        Conductor updatedConductor=conductorRepo.save(conductor);
        return updatedConductor;
    }
}
