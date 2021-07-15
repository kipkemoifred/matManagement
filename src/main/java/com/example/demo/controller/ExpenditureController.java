package com.example.demo.controller;
import com.example.demo.entity.Expenditure;

import com.example.demo.exception.ExpenditureNotFoundException;
import com.example.demo.repository.ExpenditureRepo;
import com.example.demo.service.ExpenditureService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/api/")
public class ExpenditureController {
    @Autowired
    private ExpenditureService expenditureService;
    @Autowired
    private ExpenditureRepo expenditureRepo;

    @PostMapping(value="/expenditure")
    Expenditure addNewExpenditure(@RequestBody Expenditure expenditure){
        return expenditureService.addExpenditure(expenditure);
    }


    //
//    @GetMapping(value = "/user/{userId}") @PostMapping
////
////    @DeleteMapping
////    @PutMapping
    @GetMapping(value = "/expenditure/{expenditureId}")
    public Expenditure getSpecificExpenditure(@PathVariable("expenditureId") int expenditureId) throws ExpenditureNotFoundException {
        return expenditureService.getExpenditure(expenditureId);

    }

    @GetMapping("/expenditures")
    public List<Expenditure> getAllExpenditures(){
        return expenditureService.getExpenditures();
    }
    @PutMapping(value = "/expenditures/{expendituresId}")
    public Expenditure updateExpenditures(@RequestBody Expenditure expenditure) throws ExpenditureNotFoundException {
        return expenditureService.updateExpenditure(expenditure.getExpenditureId(), expenditure);
    }
    @DeleteMapping("/expenditures/{expenditureId}")
    public ResponseEntity<?> deleteExpenditure(@PathVariable(value = "expenditureId") int expenditureId) throws ExpenditureNotFoundException {
        Expenditure expenditure = expenditureRepo.findById(expenditureId)
                .orElseThrow(() -> new ExpenditureNotFoundException(expenditureId));

        expenditureRepo.delete(expenditure);

        return ResponseEntity.ok().build();
    }
}



