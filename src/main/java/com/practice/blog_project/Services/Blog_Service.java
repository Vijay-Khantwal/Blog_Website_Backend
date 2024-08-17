package com.practice.blog_project.Services;

import com.practice.blog_project.Entities.Blog_Entity;
import com.practice.blog_project.Models.Blog_Model;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface Blog_Service {

    Blog_Entity getBlogById(Integer id);
    List<Blog_Entity> getBlogOfUser(Integer user_id,Integer pageNo,Integer pageSize);
    List<Blog_Entity> getAllBlogs(Integer pageNo,Integer pageSize);
    Blog_Entity createBlog(Blog_Entity blog);

    Blog_Entity deleteBlogById(Integer id);
    Blog_Entity updateBlog(Integer id,Blog_Entity updated_blog);

}
