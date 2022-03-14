package com.manideep.socialmedia.serviceImpl;

import com.manideep.socialmedia.model.GroupUsers;
import com.manideep.socialmedia.model.Groups;
import com.manideep.socialmedia.model.User;
import com.manideep.socialmedia.repository.GroupsRepository;
import com.manideep.socialmedia.repository.GroupsUsersRepository;
import com.manideep.socialmedia.repository.UserRepository;
import com.manideep.socialmedia.service.GroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupsServiceImpl implements GroupsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    GroupsRepository groupsRepository;

    @Autowired
    GroupsUsersRepository groupsUsersRepository;

    @Override
    public Groups createGroup(int id, Groups groups) {
        Optional<User> user = userRepository.findById(id);
        GroupUsers groupUsers = new GroupUsers();
        if(user.isPresent()) {
            groups.setCreatedby(id);
            Groups groupdetails = groupsRepository.save(groups);
            groupUsers.setGroupid(groupdetails.getId());
            groupUsers.setUserid(id);
            groupsUsersRepository.save(groupUsers);
            return groupdetails;
        }
        else{
            return null;
        }

    }

    @Override
    public List<Groups> getAllGroups() {
        return groupsRepository.findAllGroups();
    }
}
