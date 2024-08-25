package com.backend.blog_project.Services;

import com.backend.blog_project.Models.User_Model;

import java.util.List;

public interface User_Service {
    List<User_Model> readUsers();
    User_Model createUser(User_Model user);
    User_Model updateUser(Integer id, User_Model user);
    String deleteUser(Integer id);
    User_Model readUserById(Integer id);

    String verify(String username, String password);

    String logout(String username);
}
