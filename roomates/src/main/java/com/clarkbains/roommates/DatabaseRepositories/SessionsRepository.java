package com.clarkbains.roommates.DatabaseRepositories;

import com.clarkbains.roommates.DatabaseModels.Session;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;


public interface SessionsRepository extends CrudRepository<Session, Integer> {
    @Query(value = "select * from session where id=?1", nativeQuery = true)
    Collection<Session> getSessions(Integer id);
}