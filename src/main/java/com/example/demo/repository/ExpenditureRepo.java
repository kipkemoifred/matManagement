package com.example.demo.repository;

import com.example.demo.entity.Expenditure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenditureRepo extends JpaRepository<Expenditure,Integer> {
}
