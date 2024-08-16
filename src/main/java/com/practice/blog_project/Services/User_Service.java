package com.practice.blog_project.Services;

import com.practice.blog_project.Models.User_Model;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

public interface User_Service {
    List<User_Model> readUsers();
    User_Model createUser(User_Model user);
    User_Model updateUser(Integer id, User_Model user);
    String deleteUser(Integer id);
}
