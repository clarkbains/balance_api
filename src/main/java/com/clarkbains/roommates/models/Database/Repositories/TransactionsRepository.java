package com.clarkbains.roommates.models.Database.Repositories;

import com.clarkbains.roommates.models.Database.Group;
import com.clarkbains.roommates.models.Database.Transactions;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;


public interface TransactionsRepository extends CrudRepository<Transactions, Integer> {
    public Collection<Transactions> findAllByIdInAndGroupIdIsNull(List<Integer>Ids);
    public Collection<Transactions> findAllByIdInAndGroupIdIsNotNull(List<Integer>Ids);
}