package com.practice.blog_project.Contollers;

import com.practice.blog_project.Models.User_Model;
import com.practice.blog_project.Services.User_Service;
import com.practice.blog_project.Services.User_Service_Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class User_Controller {

    private final User_Service userService;
    @Autowired
    public User_Controller(User_Service userService) {
        this.userService = userService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/fetchAll")
    public List<User_Model> getAll(){
        return userService.readUsers();
    }

    @PostMapping("/add")
    public User_Model addUser(@RequestBody  User_Model user){
        return userService.createUser(user);
    }

    @PutMapping("/update/{id}")
    public User_Model updateUser(@PathVariable Integer id,@RequestBody User_Model user){
        return userService.updateUser(id,user);
    }

    @DeleteMapping("delete/{id}")
    public String deleteUser(@PathVariable Integer id){
        return userService.deleteUser(id);
    }
}
