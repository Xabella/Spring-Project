package com.practice.project.service;

import com.practice.project.model.LoanModel;
import com.practice.project.model.SubscriptionModel;
import com.practice.project.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;


    public void requestLoan(LoanModel loanModel){


        loanRepository.save(loanModel);
    }

    public void editLoan(LoanModel loanModel) {
        Optional<LoanModel> optionalLoanModel = loanRepository.findById(loanModel.getId());

        if(optionalLoanModel.isEmpty()){
            throw new IllegalArgumentException("invalid");
        }

        loanRepository.save(optionalLoanModel.get());

    }

    public List<LoanModel> getLoan() {
        List<LoanModel> all = loanRepository.findAll();
        return all;
    }

    public void delete(long id) {
        Optional<LoanModel> optionalLoanModel = loanRepository.findById(id);

        if(optionalLoanModel.isEmpty()){
            throw new IllegalArgumentException("Employee does not exist");
        }

        loanRepository.deleteById(id);
    }

}
