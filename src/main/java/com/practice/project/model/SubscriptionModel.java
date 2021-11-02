package com.practice.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "subscriptions")

public class SubscriptionModel {
    @Id
    @GeneratedValue
    private long loan_id;

    @NotBlank
    private String name;
    private String interest;

    public SubscriptionModel() {
    }

    public SubscriptionModel(String name, String interest) {
        this.name = name;
        this.interest = interest;
    }

    public long getLoan_id() {
        return loan_id;
    }

    public void setLoan_id(long loan_id) {
        this.loan_id = loan_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }
}
