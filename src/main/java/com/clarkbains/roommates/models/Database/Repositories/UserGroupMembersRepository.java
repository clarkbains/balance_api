package com.clarkbains.roommates.models.Database.Repositories;

import com.clarkbains.roommates.models.Database.UserGroupMember;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;


public interface UserGroupMembersRepository extends CrudRepository<UserGroupMember, Integer> {
    Collection<UserGroupMember> findAllByMemberIdAndGroupIdIsNotIn(int memberId, Collection<Integer> excludedIds);
}