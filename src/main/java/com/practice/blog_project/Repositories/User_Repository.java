package com.practice.blog_project.Repositories;

import com.practice.blog_project.Entities.User_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_Repository extends JpaRepository<User_Entity,Integer> {

}
