package com.clarkbains.roommates.DatabaseRepositories;

import com.clarkbains.roommates.DatabaseModels.User;
import com.clarkbains.roommates.DatabaseModels.UserGroups;
import org.springframework.data.repository.CrudRepository;


public interface UserGroupsRepository extends CrudRepository<UserGroups, Integer> {

}