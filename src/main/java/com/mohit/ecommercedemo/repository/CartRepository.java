package com.mohit.ecommercedemo.repository;

import com.mohit.ecommercedemo.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

}

