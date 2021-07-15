package com.example.demo.service;
import com.example.demo.entity.Expenditure;
import com.example.demo.exception.ExpenditureNotFoundException;
import com.example.demo.repository.ExpenditureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenditureService {
    @Autowired
    private ExpenditureRepo expenditureRepo;

    public ExpenditureService() {
    }

    public List<Expenditure> getExpenditures(){
        return expenditureRepo.findAll();

    }
    public Expenditure getExpenditure(int expenditureId) throws ExpenditureNotFoundException {
        return expenditureRepo.findById(expenditureId).orElseThrow(()->new ExpenditureNotFoundException(expenditureId));

    }
    public Expenditure addExpenditure(Expenditure expenditure){
        return expenditureRepo.save(expenditure);
    }
    public Expenditure updateExpenditure(int expenditureId,Expenditure expenditureDetails) throws ExpenditureNotFoundException {
        Expenditure expenditure=expenditureRepo.findById(expenditureId).orElseThrow(()-> new ExpenditureNotFoundException(expenditureId));
        expenditure.setExpenditureId(expenditureDetails.getExpenditureId());
        //expenditure.(expenditureDetails.getfName());
        Expenditure updatedDriver=expenditureRepo.save(expenditure);
        return updatedDriver;
    }
}
