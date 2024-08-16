package com.practice.blog_project.Entities;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user_db")
public class User_Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String password;
    private String email;
}
