package com.practice.project.controller;

import com.practice.project.model.SubscriptionModel;
import com.practice.project.service.SubsriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/subscriptions")

public class SubsriptionController {
    @Autowired
    private SubsriptionService subsriptionService;

    @PutMapping(path="edit")
    public ResponseEntity<?> editSubscription(@RequestBody SubscriptionModel subscriptionModel) {
        try {

            subsriptionService.editSubscription(subscriptionModel);
            return  ResponseEntity.ok(subscriptionModel);

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(path = "add")
    public ResponseEntity<?> saveSubscription(@RequestBody SubscriptionModel subscriptionModel){
        try {

            subsriptionService.saveSubscription(subscriptionModel);
            return  ResponseEntity.ok(subscriptionModel);

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(path = "subscription")
    public ResponseEntity<?> getSubscription(){
        try {


            return  ResponseEntity.ok(subsriptionService.getSubscription());

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(path = "delete")
    public ResponseEntity<?> deleteSubscription(@RequestParam(value = "loanId") long loan_id){
        try {


            subsriptionService.delete(loan_id);
            return  ResponseEntity.ok("Subsription Deleted Successfully");

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
