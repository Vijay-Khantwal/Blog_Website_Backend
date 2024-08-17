package com.practice.blog_project.Repositories;

import com.practice.blog_project.Entities.Blog_Entity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Blog_Repository extends JpaRepository<Blog_Entity,Integer> {

    @Query("SELECT b FROM Blog_Entity b where b.user_id = :user_id")
    Page<Blog_Entity> getBlogsOfUser(@Param("user_id") Integer user_id, Pageable pageable);

    @Query("SELECT b FROM Blog_Entity b where b.title like %:match%")
    Page<Blog_Entity> searchBlogByTitle(@Param("match") String match,Pageable pageable);

    @Query("SELECT b FROM Blog_Entity b where b.content like %:match%")
    Page<Blog_Entity> searchBlogByDes(@Param("match") String match,Pageable pageable);
}
