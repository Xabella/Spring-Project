package com.practice.project.repository;

import com.practice.project.model.LoanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository  extends JpaRepository<LoanModel, Long> {
}
