package com.backend.blog_project.Repositories;

import com.backend.blog_project.Models.User_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_Repository extends JpaRepository<User_Model,Integer> {

    User_Model findByUsername(String username);

}
