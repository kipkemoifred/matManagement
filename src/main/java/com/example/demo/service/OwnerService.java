package com.example.demo.service;
import com.example.demo.entity.Owner;
import com.example.demo.exception.OwnerNotFoundException;
import com.example.demo.repository.OwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepo ownerRepo;

    public OwnerService() {
    }

    public List<Owner> getOwners(){
        return ownerRepo.findAll();

    }
    public Owner getOwner(int ownerId) throws OwnerNotFoundException {
        return ownerRepo.findById(ownerId).orElseThrow(()->new OwnerNotFoundException(ownerId));

    }
    public Owner addOwner(Owner owner){
        return ownerRepo.save(owner);
    }
    public Owner updateOwner(int ownerId,Owner ownerDetails) throws OwnerNotFoundException {
        Owner owner=ownerRepo.findById(ownerId).orElseThrow(()-> new OwnerNotFoundException(ownerId));
        owner.setOwnerId(ownerDetails.getOwnerId());
        owner.setfName(ownerDetails.getfName());
        owner.setIdNumber(ownerDetails.getIdNumber());
        owner.setlName(ownerDetails.getlName());
        owner.setPhoneNumber(ownerDetails.getPhoneNumber());
        Owner updatedOwner=ownerRepo.save(owner);
        return updatedOwner;
    }
}
