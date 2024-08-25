package com.backend.blog_project.Services;

import com.backend.blog_project.Entities.Blog_Entity;

import java.util.List;

public interface Blog_Service {

    Blog_Entity getBlogById(Integer id);
    List<Blog_Entity> getBlogOfUser(Integer user_id,Integer pageNo,Integer pageSize);
    List<Blog_Entity> getAllBlogs(Integer pageNo,Integer pageSize);
    Blog_Entity createBlog(Blog_Entity blog);
    Blog_Entity deleteBlogById(Integer id);
    Blog_Entity updateBlog(Integer id,Blog_Entity updated_blog);

    List<Blog_Entity> searchByTitle(String match,Integer pageNo,Integer pageSize);
    List<Blog_Entity> searchByDes(String match,Integer pageNo,Integer pageSize);


}
