package com.clarkbains.roommates.models.Database;

import javax.persistence.*;

@Entity
public class IndividualTransactions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    public Integer transactionId;
    public Integer owedById;
    public Double percentage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getOwedById() {
        return owedById;
    }

    public void setOwedById(Integer owedById) {
        this.owedById = owedById;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public IndividualTransactions() {
    }

    public IndividualTransactions (Integer transactionId, Integer owedById, Double percentage) {
        this.transactionId = transactionId;
        this.owedById = owedById;
        this.percentage = percentage;
    }
}
