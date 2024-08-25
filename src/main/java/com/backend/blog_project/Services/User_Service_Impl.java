package com.backend.blog_project.Services;

import com.backend.blog_project.Models.User_Model;
import com.backend.blog_project.Repositories.User_Repository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class User_Service_Impl implements User_Service{

    @Autowired
    User_Repository user_repository;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    JWTService jwtService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);


    @Override
    public User_Model createUser(User_Model user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user_repository.save(user);
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
    public User_Model readUserById(Integer id) {
        if(user_repository.existsById(id)){
            return user_repository.findById(id).get();
        }
        return null;
    }

    @Override
    public String verify(String username, String password) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));

        if(authentication.isAuthenticated()){
            return jwtService.generateToken(username,password);
        }
        return "fail";
    }

    @Override
    public String logout(String token) {
        if(token == null){
            return "Not Authorized";
        }
        String username = jwtService.extractUsername(token);
        User_Model user = user_repository.findByUsername(username);
        user.setJwt_logOut_Time(new Date());
        user_repository.save(user);
        return "Logout Successful!";

    }

    @Override
    public List<User_Model> readUsers() {

        return user_repository.findAll();
    }

    @Override
    public User_Model updateUser(Integer id, User_Model user) {
        if(user_repository.existsById(id)){
            User_Model existing = user_repository.findById(id).get();
            existing.setEmail(user.getEmail());
            existing.setUsername(user.getUsername());
            existing.setPassword(encoder.encode(user.getPassword()));
            user_repository.save(existing);
            return user;
        }
        return null;
    }



}
