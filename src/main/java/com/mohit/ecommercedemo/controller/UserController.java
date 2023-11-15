package com.mohit.ecommercedemo.controller;

import com.mohit.ecommercedemo.dto.UserDTO;
import com.mohit.ecommercedemo.entity.User;
import com.mohit.ecommercedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserDTO userDTO) {
        User user = new User();
        // Set user properties from DTO
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.loginUser(userDTO.getUsername(), userDTO.getPassword()));
    }
}

