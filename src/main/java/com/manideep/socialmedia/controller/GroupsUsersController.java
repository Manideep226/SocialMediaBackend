package com.manideep.socialmedia.controller;

import com.manideep.socialmedia.model.GroupUsers;
import com.manideep.socialmedia.model.Groups;
import com.manideep.socialmedia.service.GroupUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/socialmedia/groups")
public class GroupsUsersController {

    @Autowired
    GroupUsersService groupusersService;

    //adding users to group
    // for now send candidate id manually in groupUsers. in real life scenario we will get user details after login anyway.
    @PostMapping("/add")
    public ResponseEntity<?> addUserToGroup(@RequestParam(name="groupid") int groupid,@RequestParam(name="userid") int userid){
        GroupUsers groupuserDetails = groupusersService.addUserToGroup(groupid,userid);
            return new ResponseEntity<>(groupuserDetails, HttpStatus.CREATED);
        }

    @GetMapping("/get/groupdetails")
    public ResponseEntity<List<GroupUsers>> createGroup(){
        List<GroupUsers> groupUsers = groupusersService.getAllGroupsUsers();
        return new ResponseEntity<>(groupUsers,HttpStatus.OK);
    }
}
