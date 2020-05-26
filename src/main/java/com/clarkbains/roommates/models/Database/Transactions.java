package com.clarkbains.roommates.models.Database;

import com.clarkbains.roommates.models.Request.Transaction.Group.AddGroupTransaction;
import com.clarkbains.roommates.models.Request.Transaction.Single.AddTransaction;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    public Integer ownerId;
    public Double amount;
    public String note;
    public Integer groupId;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }


    public Integer getId() {
        return id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Transactions() {
    }

    public Transactions(Integer ownerId, Double amount, String note, Integer groupId) {
        this.ownerId = ownerId;
        this.amount = amount;
        this.note = note;
        this.groupId = groupId;
    }

    public static Transactions fromSingleTransactionReqAndUser(AddTransaction r, User u){
        return new Transactions(u.getId(), r.getAmount(), r.getNote(), null);
    }
    public static Transactions fromSingleTransactionReqAndUser(AddGroupTransaction r, User u){
        return new Transactions(u.getId(), r.getAmount(), r.getNote(), r.getGroupId());
    }


}
