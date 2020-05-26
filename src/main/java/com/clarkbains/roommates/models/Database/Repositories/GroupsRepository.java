package com.clarkbains.roommates.models.Database.Repositories;

import com.clarkbains.roommates.models.Database.Group;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;


public interface GroupsRepository extends CrudRepository<Group, Integer> {
    Collection<Group> findAllByIdIn(List groupIds);
    Group findFirstByIdEquals(Integer groupId);

    Collection<Group> findAllByOwner(Integer ownerId);

}