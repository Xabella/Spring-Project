package com.practice.project.service;

import com.practice.project.model.SubscriptionModel;
import com.practice.project.repository.SubscritionRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class SubsriptionService {

    @Autowired
    private SubscritionRepsitory subscritionRepsitory ;

    public void editSubscription(SubscriptionModel subscriptionModel) {
        Optional<SubscriptionModel> optionalSubscriptionModel = subscritionRepsitory.findById(subscriptionModel.getLoan_id());

        if(optionalSubscriptionModel.isEmpty()){
            throw new IllegalArgumentException("invalid");
        }

        subscritionRepsitory.save(optionalSubscriptionModel.get());

    }

    public void saveSubscription(SubscriptionModel subscriptionModel) {


        subscritionRepsitory.save(subscriptionModel);
    }

    public  List<SubscriptionModel> getSubsription() {
        List<SubscriptionModel> all = subscritionRepsitory.findAll();
        return all;
    }

    public void delete(long loan_id) {
        Optional<SubscriptionModel> optionalSubscriptionModel = subscritionRepsitory.findById(loan_id);

        if(optionalSubscriptionModel.isEmpty()){
            throw new IllegalArgumentException("Employee does not exist");
        }

        subscritionRepsitory.deleteById(loan_id);
    }


}
