package com.clarkbains.roommates.DatabaseRepositories;

import com.clarkbains.roommates.DatabaseModels.Group;
import org.springframework.data.repository.CrudRepository;


public interface GroupsRepository extends CrudRepository<Group, Integer> {

}