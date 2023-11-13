package com.mohit.ecommercedemo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categories")
//Using lombok to create getters and setters
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

}
