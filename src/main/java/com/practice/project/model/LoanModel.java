package com.practice.project.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "loan")
public class LoanModel {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    @OneToOne
    @JoinColumn(name = "loan_id")
    private SubscriptionModel subscriptionModel;


    private String loanAmount;
    private LocalDateTime borrowedDate;
    private LocalDateTime paymentDate;
    private String amountRemaining;
    private boolean isPaid;

    public LoanModel() {
    }

    public LoanModel(UserModel user, String loanAmount, String interest, LocalDateTime borrowedDate, LocalDateTime paymentDate, boolean isPaid) {
        this.user = user;
        this.loanAmount = loanAmount;
        this.borrowedDate = borrowedDate;
        this.paymentDate = paymentDate;
        this.isPaid = isPaid;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public LocalDateTime getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(LocalDateTime borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}
