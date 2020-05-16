package com.clarkbains.roommates.models.Database.Repositories;

import com.clarkbains.roommates.models.Database.Session;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Collection;


public interface SessionsRepository extends CrudRepository<Session, Integer> {
    Collection<Session> findBySessionToken(String id);
    @Transactional
    void removeAllByExpiryDateIsBefore(Timestamp now);
}