package com.clarkbains.roommates.models.Database.Repositories;

import com.clarkbains.roommates.models.Database.Session;
import com.clarkbains.roommates.models.Database.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;


public interface UsersRepository extends CrudRepository<User, Integer> {
    User findFirstByEmailEqualsAndPasswordHashEquals(String email, String password);
    User findFirstByEmailEquals(String email);

       User findFirstByIdEquals(Integer id);
}