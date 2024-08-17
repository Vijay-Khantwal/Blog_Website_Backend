package com.practice.blog_project.Services;

import com.practice.blog_project.Entities.Blog_Entity;
import com.practice.blog_project.Repositories.Blog_Repository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class Blog_Service_Impl implements Blog_Service{

    @Autowired
    Blog_Repository blogRepository;

    @Override
    public Blog_Entity createBlog(Blog_Entity blog) {
        blog.setDateTime(LocalDateTime.now());
        blogRepository.save(blog);
        return blog;
    }

    public Blog_Entity getBlogById(Integer id){
        if(blogRepository.existsById(id)){
            return blogRepository.findById(id).get();
        }
        else{
            return null;
        }
    }

    @Override
    public List<Blog_Entity> getAllBlogs(Integer pageNo,Integer pageSize) {
        Sort sortOrder = Sort.by("dateTime");
        Pageable paging = PageRequest.of(pageNo,pageSize,sortOrder);
        Page<Blog_Entity> pagedResult = blogRepository.findAll(paging);
        if(pagedResult.hasContent()){
                return pagedResult.getContent();
        }
        else{
            return new ArrayList<Blog_Entity>();
        }
    }

    @Override
    public List<Blog_Entity> getBlogOfUser(Integer user_id, Integer pageNo, Integer pageSize) {
        Sort sortOrder = Sort.by("dateTime");
        Pageable paging = PageRequest.of(pageNo,pageSize,sortOrder);
        Page<Blog_Entity> pagedResult = blogRepository.getBlogsOfUser(user_id,paging);
        if(pagedResult.hasContent()){
            return pagedResult.getContent();
        }
        else{
            return new ArrayList<Blog_Entity>();
        }
    }

    @Override
    public Blog_Entity deleteBlogById(Integer id) {
        if(blogRepository.existsById(id)){
            Blog_Entity  existing= blogRepository.findById(id).get();
            blogRepository.deleteById(id);
            return existing ;
        }
        else{
            return null;
        }
    }

    @Override
    public Blog_Entity updateBlog(Integer id, Blog_Entity updated_blog) {
        if(blogRepository.existsById(id)){
            Blog_Entity  existing= blogRepository.findById(id).get();
            existing.setTitle(updated_blog.getTitle());
            existing.setContent(updated_blog.getContent());
            blogRepository.save(existing);
            return updated_blog;
        }
        return null;
    }

}
