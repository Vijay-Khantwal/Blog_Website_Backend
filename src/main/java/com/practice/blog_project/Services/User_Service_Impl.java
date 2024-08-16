package com.practice.blog_project.Services;

import com.practice.blog_project.Entities.User_Entity;
import com.practice.blog_project.Models.User_Model;
import com.practice.blog_project.Repositories.User_Repository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class User_Service_Impl implements User_Service{

    @Autowired
    User_Repository user_repository;


    @Override
    public User_Model createUser(User_Model user) {

        User_Entity new_user = new User_Entity();
        BeanUtils.copyProperties(user,new_user);
        user_repository.save(new_user);
        return user;
    }

    @Override
    public String deleteUser(Integer id) {
        if(user_repository.existsById(id)){
            user_repository.deleteById(id);
            return "Deletion Successful!";
        }
        else{
            return "User doesn't exist!";
        }

    }
    @Override
    public List<User_Model> readUsers() {
        List<User_Entity> all_users = user_repository.findAll();
        List<User_Model> return_users = new ArrayList<>();

        for(User_Entity user : all_users){
            User_Model return_user = new User_Model();
            return_user.setName(user.getName());
            return_user.setEmail(user.getEmail());

            return_users.add(return_user);

        }

        return return_users;
    }

    @Override
    public User_Model updateUser(Integer id, User_Model user) {
        if(user_repository.existsById(id)){
            User_Entity existing = user_repository.findById(id).get();
            existing.setEmail(user.getEmail());
            existing.setName(user.getName());
            existing.setPassword(user.getPassword());
            user_repository.save(existing);
            return user;
        }
        return null;
    }

}
