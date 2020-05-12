package com.clarkbains.roommates.DatabaseRepositories;

import com.clarkbains.roommates.DatabaseModels.User;
import org.springframework.data.repository.CrudRepository;


public interface UsersRepository extends CrudRepository<User, Integer> {

}