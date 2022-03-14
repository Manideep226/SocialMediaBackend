package com.manideep.socialmedia.service;

import com.manideep.socialmedia.model.GroupUsers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GroupUsersService {
    GroupUsers addUserToGroup(int groupid, int userid);

    List<GroupUsers> getAllGroupsUsers();
}
