package com.manideep.socialmedia.controller;

import com.manideep.socialmedia.model.Groups;
import com.manideep.socialmedia.service.GroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/socialmedia/groups")
public class GroupsController {

    @Autowired
    private GroupsService groupsService;

    //user creating a group
    @PostMapping("/create/{id}")
    public ResponseEntity<?> createGroup(@PathVariable int id,@RequestBody Groups groups){
        Groups groupdetails = groupsService.createGroup(id,groups);
        if(Objects.nonNull(groupdetails))
            return new ResponseEntity<>(groupdetails, HttpStatus.CREATED);
        else
            return new ResponseEntity<>("No user present with id: "+id,HttpStatus.NOT_FOUND);
    }

    //get all groups
    @GetMapping("/get")
    public ResponseEntity<List<Groups>> getAllGroups(){
        List<Groups> groupdetails = groupsService.getAllGroups();
        return new ResponseEntity<>(groupdetails,HttpStatus.OK);
    }
}
