package com.mohit.ecommercedemo.service;

import com.mohit.ecommercedemo.entity.User;
import com.mohit.ecommercedemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User loginUser(String username, String password) {
        return null;
    }
}

