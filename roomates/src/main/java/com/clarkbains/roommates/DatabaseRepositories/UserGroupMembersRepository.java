package com.clarkbains.roommates.DatabaseRepositories;

import com.clarkbains.roommates.DatabaseModels.UserGroupMember;
import org.springframework.data.repository.CrudRepository;


public interface UserGroupMembersRepository extends CrudRepository<UserGroupMember, Integer> {

}