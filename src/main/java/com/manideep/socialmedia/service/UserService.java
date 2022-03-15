package com.manideep.socialmedia.service;

import com.manideep.socialmedia.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User saveUser(User user);

    List<User> getUsers();

    List<User> getUserByName(String name);

    List<User> getUserByMultipleParamaters(String name, String mobile);
}
