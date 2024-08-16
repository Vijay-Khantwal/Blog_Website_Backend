package com.practice.blog_project.Models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User_Model {
    private Integer id;
    private String name;
    private String email;
    private String password;

}
