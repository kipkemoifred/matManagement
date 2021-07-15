package com.example.demo.controller;
import com.example.demo.entity.Owner;

import com.example.demo.exception.OwnerNotFoundException;
import com.example.demo.repository.OwnerRepo;
import com.example.demo.service.OwnerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/api/")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;
    @Autowired
    private OwnerRepo ownerRepo;

    @PostMapping(value="/owner")
    Owner addNewOwner(@RequestBody Owner owner){
        return ownerService.addOwner(owner);
    }


    //
//    @GetMapping(value = "/user/{userId}") @PostMapping
////
////    @DeleteMapping
////    @PutMapping
    @GetMapping(value = "/owner/{ownerId}")
    public Owner getSpecificOwner(@PathVariable("ownerId") int ownerId) throws OwnerNotFoundException {
        return ownerService.getOwner(ownerId);

    }

    @GetMapping("/owners")
    public List<Owner> getAllOwners(){
        return ownerService.getOwners();
    }
    @PutMapping(value = "/owner/{ownerId}")
    public Owner updateOwner(@RequestBody Owner owner) throws OwnerNotFoundException {
        return ownerService.updateOwner(owner.getOwnerId(), owner);
    }
    @DeleteMapping("/owner/{ownerId}")
    public ResponseEntity<?> deleteOwner(@PathVariable(value = "ownerId") int ownerId) throws OwnerNotFoundException {
        Owner owner = ownerRepo.findById(ownerId)
                .orElseThrow(() -> new OwnerNotFoundException(ownerId));

        ownerRepo.delete(owner);

        return ResponseEntity.ok().build();
    }
}




