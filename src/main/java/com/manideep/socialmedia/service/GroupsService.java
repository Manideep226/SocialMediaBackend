package com.manideep.socialmedia.service;

import com.manideep.socialmedia.model.Groups;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GroupsService {
    Groups createGroup(int id, Groups group);

    List<Groups> getAllGroups();
}
