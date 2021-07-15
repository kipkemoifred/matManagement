package com.example.demo.service;
import com.example.demo.entity.Company;
import com.example.demo.exception.CompanyNotFoundException;
import com.example.demo.repository.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepo companyRepo;

    public CompanyService() {
    }

    public List<Company> getCompanies(){
        return companyRepo.findAll();

    }
    public Company getCompany(int companyId) throws CompanyNotFoundException {
        return companyRepo.findById(companyId).orElseThrow(()->new CompanyNotFoundException(companyId));

    }
    public Company addCompany(Company company){
        return companyRepo.save(company);
    }
    public Company updateCompany(int companyId,Company companyDetails) throws CompanyNotFoundException {
        Company company=companyRepo.findById(companyId).orElseThrow(()-> new CompanyNotFoundException(companyId));
        company.setCompanyId(companyDetails.getCompanyId());
        //company.set(companyDetails.getCompanyName());
        Company updatedCompany=companyRepo.save(company);
        return updatedCompany;
    }
}
