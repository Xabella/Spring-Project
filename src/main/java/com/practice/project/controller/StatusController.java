package com.practice.project.controller;

import com.practice.project.model.StatusModel;
import com.practice.project.model.SubscriptionModel;
import com.practice.project.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/status")
public class StatusController {
    @Autowired

    private StatusService statusService;
    @PutMapping(path="edit")
    public ResponseEntity<?> editStatus(@RequestBody StatusModel statusModel) {
        try {

            statusService.editStatus(statusModel);
            return  ResponseEntity.ok(statusModel);

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(path = "add")
    public ResponseEntity<?> saveStatus(@RequestBody StatusModel statusModel){
        try {

            statusService.saveStatus(statusModel);
            return  ResponseEntity.ok(statusModel);

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(path = "status")
    public ResponseEntity<?> getStatus(){
        try {


            return  ResponseEntity.ok(statusService.getStatus());

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping(path = "delete")
    public ResponseEntity<?> deleteStatus(@RequestParam(value = "statusId") long status_id){
        try {


            statusService.delete(status_id);
            return  ResponseEntity.ok("Subsription Deleted Successfully");

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

