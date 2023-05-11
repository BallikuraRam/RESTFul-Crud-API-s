package com.crud.service;

import com.crud.model.Blog;

import java.util.List;

public interface BlogService {
    Blog saveBlog(Blog blog);
    Blog getById(int blogId);
    List getAllBlogs();
    Blog updateExistingBlogByBlogId(Blog blog , int blogId);
    void deleteExistingBlogByBlogId(int blogId);
}
