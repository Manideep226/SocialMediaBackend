package com.manideep.socialmedia.controller;

import com.manideep.socialmedia.model.User;
import com.manideep.socialmedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/socialmedia/users")
public class UsersController {
    @Autowired
    UserService userService;

    //creating the user
    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User userdetails = userService.saveUser(user);
        return new ResponseEntity<>(userdetails, HttpStatus.CREATED);
    }

    //get all users
    @GetMapping("/get")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userdetails = userService.getUsers();
        return new ResponseEntity<>(userdetails, HttpStatus.OK);
    }

    //get user by name
    @GetMapping("/getusers")
    public ResponseEntity<List<User>> getUserByName(@RequestParam(value="username",required = true) String name) {
        List<User> userdetails = userService.getUserByName(name);
        return new ResponseEntity<>(userdetails, HttpStatus.OK);
    }

    //get user by name
    @GetMapping("/getusers-miltiple")
    public ResponseEntity<List<User>> getUserByMultipleParamaters(@RequestParam(value="name",required = false) String name, @RequestParam(value="mobile",required = false) String mobile) {
        List<User> userdetails = userService.getUserByMultipleParamaters(name, mobile);
        return new ResponseEntity<>(userdetails, HttpStatus.OK);
    }
}
