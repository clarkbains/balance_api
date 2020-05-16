package com.clarkbains.roommates.models.Database.Repositories;

import com.clarkbains.roommates.models.Database.Session;
import com.clarkbains.roommates.models.Database.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;


public interface UsersRepository extends CrudRepository<User, Integer> {
    @Query(value = "select * from `user` where email=?1 and password_hash=?2", nativeQuery = true)
    Collection<User> getUser(String email, String password);

    @Query(value = "select * from `user` where email=?1", nativeQuery = true)
    Collection<User> getUser(String email);
    @Query(value = "select * from `user` where id=?1", nativeQuery = true)
    User findFirstById(Integer id);

    User findFirstBy
}