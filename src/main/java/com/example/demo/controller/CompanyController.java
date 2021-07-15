package com.example.demo.controller;
import com.example.demo.entity.Company;
import com.example.demo.exception.CompanyNotFoundException;
import com.example.demo.repository.CompanyRepo;
import com.example.demo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/api/")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CompanyRepo companyRepository;

    @PostMapping(value="/company")
    Company addNewCompany(@RequestBody Company company){
        return companyService.addCompany(company);
    }


    //
//    @GetMapping(value = "/user/{userId}") @PostMapping
////
////    @DeleteMapping
////    @PutMapping
    @GetMapping(value = "/company/{companyId}")
    public Company getSpecificCompany(@PathVariable("companyId") int companyId) throws CompanyNotFoundException {
        return companyService.getCompany(companyId);

    }

    @GetMapping("/companies")
    public List<Company> getAllCompanies(){
        return companyService.getCompanies();
    }
    @PutMapping(value = "/company/{companyId}")
    public Company updateCompany(@RequestBody Company company) throws CompanyNotFoundException {
        return companyService.updateCompany(company.getCompanyId(), company);
    }
    @DeleteMapping("/company/{companyId}")
    public ResponseEntity<?> deleteCompany(@PathVariable(value = "companyId") int companyId) throws CompanyNotFoundException {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new CompanyNotFoundException(companyId));

        companyRepository.delete(company);

        return ResponseEntity.ok().build();
    }
}
