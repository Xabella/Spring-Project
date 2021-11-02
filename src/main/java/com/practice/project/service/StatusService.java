package com.practice.project.service;

import com.practice.project.model.StatusModel;
import com.practice.project.model.SubscriptionModel;
import com.practice.project.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {
    @Autowired
    private StatusRepository statusRepository;

    public void editStatus(StatusModel statusModel) {
            Optional<StatusModel> optionalStatusModel = statusRepository.findById(statusModel.getStatus_id());

            if(optionalStatusModel.isEmpty()){
                throw new IllegalArgumentException("invalid");
            }

            statusRepository.save(optionalStatusModel.get());

    }

    public void saveStatus(StatusModel statusModel) {
        statusRepository.save(statusModel);
    }


    public List<StatusModel>getStatus() {
        List<StatusModel > all = statusRepository.findAll();
        return all;
    }

    public void delete(long status_id) {
        Optional<StatusModel> optionalStatusModel = statusRepository.findById(status_id);

        if(optionalStatusModel.isEmpty()){
            throw new IllegalArgumentException("invalid");
        }

        statusRepository.deleteById(status_id);
    }

}
