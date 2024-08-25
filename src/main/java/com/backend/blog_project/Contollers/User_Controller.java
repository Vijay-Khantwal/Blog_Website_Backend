package com.backend.blog_project.Contollers;

import com.backend.blog_project.Models.User_Model;
import com.backend.blog_project.Services.User_Service;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class User_Controller {

    private final User_Service userService;
    @Autowired
    public User_Controller(User_Service userService) {
        this.userService = userService;
    }


    @GetMapping("/fetchAll")
    public List<User_Model> getAll(){
        return userService.readUsers();
    }

    @GetMapping("/{id}")
    public User_Model getUserById(@PathVariable Integer id){
        return userService.readUserById(id);
    }

    @PostMapping("/register")
    public User_Model addUser(@RequestBody @Valid User_Model user){
        return userService.createUser(user);
    }

    @PutMapping("/update/{id}")
    public User_Model updateUser(@PathVariable Integer id,@RequestBody @Valid User_Model user){
        return userService.updateUser(id,user);
    }
    @PostMapping("login")
    public String login(@RequestParam String username,@RequestParam String password ){
        return userService.verify(username,password);
    }

    @DeleteMapping("delete/{id}")
    public String deleteUser(@PathVariable Integer id){
        return userService.deleteUser(id);
    }

    @PostMapping("logout")
    public String logOut(HttpServletRequest request){
        String authheader = request.getHeader("Authorization");
        String token = null;
        if(authheader!=null && authheader.startsWith("Bearer ")){
            token = authheader.substring(7);
        }
        return userService.logout(token);
    }
}
