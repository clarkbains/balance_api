package com.clarkbains.roommates.models.Database.Repositories;

import com.clarkbains.roommates.models.Database.Group;
import com.clarkbains.roommates.models.Database.IndividualTransactions;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;


public interface IndividualTransactionsRepository extends CrudRepository<IndividualTransactions, Integer> {
    public Collection<IndividualTransactions> findAllByOwedByIdEquals(Integer id);
}