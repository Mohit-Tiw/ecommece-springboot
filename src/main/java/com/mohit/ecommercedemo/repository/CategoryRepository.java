package com.mohit.ecommercedemo.repository;

import com.mohit.ecommercedemo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
