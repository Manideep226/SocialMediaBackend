package com.manideep.socialmedia.serviceImpl;

import com.manideep.socialmedia.model.User;
import com.manideep.socialmedia.repository.UserRepository;
import com.manideep.socialmedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        User userdetails = userRepository.save(user);
        return userdetails;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.getAllUsers();
    }
}
