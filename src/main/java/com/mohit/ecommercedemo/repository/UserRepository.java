package com.mohit.ecommercedemo.repository;

import com.mohit.ecommercedemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

