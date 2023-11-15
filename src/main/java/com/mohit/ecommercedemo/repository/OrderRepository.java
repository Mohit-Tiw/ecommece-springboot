package com.mohit.ecommercedemo.repository;

import com.mohit.ecommercedemo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

