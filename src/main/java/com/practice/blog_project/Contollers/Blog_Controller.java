package com.practice.blog_project.Contollers;


import com.practice.blog_project.Entities.Blog_Entity;
import com.practice.blog_project.Models.Blog_Model;
import com.practice.blog_project.Repositories.Blog_Repository;
import com.practice.blog_project.Services.Blog_Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/blog")
@RestController
public class Blog_Controller {

    private final Blog_Service blogService;
    @Autowired
    public Blog_Controller(Blog_Service blogService){
        this.blogService = blogService;
    }


    @GetMapping("/get/{id}")
    public Blog_Entity getBlogById(@PathVariable Integer id){
        return blogService.getBlogById(id);
    }

    @GetMapping("/user/{id}")
    public List<Blog_Entity> get_Blog_By_UserName(
            @PathVariable Integer id,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize
    ){
        return blogService.getBlogOfUser(id,pageNo,pageSize);
    }

    @GetMapping("/fetchAll")
    public List<Blog_Entity> get_All_Blogs(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize
    ){
        return blogService.getAllBlogs(pageNo,pageSize);
    }

    @PostMapping("/addBlog")
    public String add_Blog(@RequestBody Blog_Entity blog){
        blogService.createBlog(blog);
        return "Blog Successfully added for: User:"+ blog.getUser_id();
    }

    @DeleteMapping("/delete/{id}")
    public String delete_Blog_By_id(@PathVariable Integer id){
        if(blogService.deleteBlogById(id) != null){
            return "Blog successfully deleted.";
        }
        else{
            return "Blog "+id+" doesn't exist.";
        }

    }

    @PutMapping("/update/{id}")
    public String update_blog(@PathVariable Integer id,@RequestBody Blog_Entity updated_blog){
        if(blogService.updateBlog(id,updated_blog) != null){
            return "Updation Successful!";
        }
        else{
            return "Blog "+id+" doesn't exist.";
        }
    }

    @GetMapping("/searchTitle/{match}")
    public List<Blog_Entity> search_By_Title(
            @PathVariable String match,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize
    ){
        return blogService.searchByTitle(match,pageNo,pageSize);
    }

    @GetMapping("/searchDes/{match}")
    public List<Blog_Entity> search_By_Des(
            @PathVariable String match,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize
    ){
        return blogService.searchByDes(match,pageNo,pageSize);
    }

}
