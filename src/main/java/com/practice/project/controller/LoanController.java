package com.practice.project.controller;

import com.practice.project.model.LoanModel;
import com.practice.project.model.SubscriptionModel;
import com.practice.project.model.UserModel;
import com.practice.project.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/loan")
public class LoanController {

    @Autowired
    private LoanService loanService;


    @PostMapping(path = "request")
    public ResponseEntity<?> requestLoan(@RequestBody LoanModel loanModel) {
        try {

            loanService.requestLoan(loanModel);
            return ResponseEntity.ok(loanModel);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping(path="edit")
    public ResponseEntity<?> editLoan(@RequestBody LoanModel loanModel) {
        try {

            loanService.editLoan(loanModel);
            return  ResponseEntity.ok(loanModel);

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(path = "loan")
    public ResponseEntity<?> getLoan(){
        try {


            return  ResponseEntity.ok(loanService.getLoan());

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(path = "delete")
    public ResponseEntity<?> deleteLoan(@RequestParam(value = "id") long id){
        try {


            loanService.delete(id);
            return  ResponseEntity.ok("Loan Deleted Successfully");

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
