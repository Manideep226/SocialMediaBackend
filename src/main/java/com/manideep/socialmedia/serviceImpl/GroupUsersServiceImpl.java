package com.manideep.socialmedia.serviceImpl;

import com.manideep.socialmedia.exceptions.UserAlreadyExistsException;
import com.manideep.socialmedia.exceptions.UserNotFoundException;
import com.manideep.socialmedia.model.GroupUsers;
import com.manideep.socialmedia.model.User;
import com.manideep.socialmedia.repository.GroupsUsersRepository;
import com.manideep.socialmedia.repository.UserRepository;
import com.manideep.socialmedia.service.GroupUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class GroupUsersServiceImpl implements GroupUsersService {

    @Autowired
    GroupsUsersRepository groupsUsersRepository;

    @Autowired
    UserRepository usersRepository;

    @Override
    public GroupUsers addUserToGroup(int groupid, int userid) {
        Optional<User> userDetails = usersRepository.findById(userid);
        if(userDetails.isPresent()) {
            GroupUsers groupUserDetails = groupsUsersRepository.findUserinGroup(groupid, userid);
            if (Objects.nonNull(groupUserDetails)) {
                throw new UserAlreadyExistsException("User Already exists in the group" + groupid);
            } else{
                GroupUsers g = new GroupUsers();
                g.setGroupid(groupid);
                g.setUserid(userid);
                GroupUsers groupUserDetails1 = groupsUsersRepository.save(g);
                return groupUserDetails1;
            }
        } else {
            throw new UserNotFoundException("User not found : "+groupid);
        }

    }

    @Override
    public List<GroupUsers> getAllGroupsUsers() {
        return groupsUsersRepository.getAllGroupsUsers();
    }
}
