package com.clarkbains.roommates.controllers;

import com.clarkbains.roommates.models.Database.Group;
import com.clarkbains.roommates.models.Database.User;
import com.clarkbains.roommates.models.Database.UserGroupMember;
import com.clarkbains.roommates.models.Exceptions.NotAuthenticatedException;
import com.clarkbains.roommates.models.Request.AuthenticatedRequest;
import com.clarkbains.roommates.models.Request.Groups.Member.AddUserToGroupRequest;
import com.clarkbains.roommates.models.Request.Groups.AddGroupRequest;
import com.clarkbains.roommates.models.Response.Successes.Generic.ResourceResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController // This means that this class is a Controller
@RequestMapping(path="/groups")
public class GroupsController extends Main{

    @PostMapping
    public @ResponseBody Group addNewGroup (@Valid @RequestBody AddGroupRequest req) throws NotAuthenticatedException {
        User u = getRequestor(req);
        Group g = new Group();
        g.setAddress(req.getAddress());
        g.setGroup_name(req.getGroupName());
        g.setOwner(u.getId());
        Group ret = groupsRepository.save(g);
        if (req.getAddSelf()){
            AddUserToGroupRequest addReq = new AddUserToGroupRequest();
            addReq.setGroupId(ret.getId());
            addReq.getAuthFromReq(req);
            Integer[] a = new Integer[1];
            a[0] = u.getId();
            addReq.setIds(a);
            addmemberToGroup(addReq);
        }
        return ret;
    }
       @GetMapping
       public @ResponseBody
       ResourceResponse<Collection<Group>> getGroups(@Valid @RequestBody AuthenticatedRequest req) throws NotAuthenticatedException {
            User u = getRequestor(req);
            Collection<Group> ownedGroupsList = groupsRepository.findAllByOwner(u.getId());
            Collection<Integer> ownedGroupsIds = new ArrayList<>();
            for (Group ownedGroup: ownedGroupsList){
                ownedGroupsIds.add(ownedGroup.getId());
            }
            List<Integer> partOfGroupsIds = new ArrayList<>();
            Collection<UserGroupMember> partOf = userGroupMembersRepository.findAllByMemberIdAndGroupIdIsNotIn(u.getId(), ownedGroupsIds);
            for (UserGroupMember ugm : partOf){
                partOfGroupsIds.add(ugm.getGroupId());
            }
            ownedGroupsList.addAll(groupsRepository.findAllByIdIn(partOfGroupsIds));
            ResourceResponse<Collection<Group>> resp = new ResourceResponse<>(ownedGroupsList);
            return resp;
        }
    @PostMapping(path = "/member")
    void addmemberToGroup(@Valid @RequestBody AddUserToGroupRequest req) throws NotAuthenticatedException {
        User u = getRequestor(req);
        ArrayList<UserGroupMember> correlations = new ArrayList<>();
        for (Integer member: req.getIds()){
            UserGroupMember o = new UserGroupMember();
            o.setGroupId(req.getGroupId());
            o.setMemberId(member);
            correlations.add(o);
        }
        userGroupMembersRepository.saveAll(correlations);
    }

}