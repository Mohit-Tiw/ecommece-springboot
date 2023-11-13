package com.mohit.ecommercedemo.repository;

import com.mohit.ecommercedemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
