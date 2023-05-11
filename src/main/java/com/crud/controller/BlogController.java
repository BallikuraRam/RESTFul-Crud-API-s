package com.crud.controller;

import com.crud.RestFulCrudApiApplication;
import com.crud.exception.BlogNotFoundException;
import com.crud.model.Blog;
import com.crud.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blog")
@RequiredArgsConstructor
public class BlogController {
    private final Logger logger = LoggerFactory.getLogger(RestFulCrudApiApplication.class);
    private final BlogService blogService;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Blog blog) {
        Blog blog1 = blogService.saveBlog(blog);
        logger.info("create a new Blog successfully  : " + blog1);
        return new ResponseEntity<>(blog1, HttpStatus.CREATED);
    }

    @GetMapping("/{blogId}")
    public ResponseEntity findById(@PathVariable("blogId") int blogId) throws BlogNotFoundException {

        Blog blogInfo = blogService.getById(blogId);
        logger.info("Found the Blog getBlogId   : ");
        return new ResponseEntity<>(HttpStatus.FOUND);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List> getAllBlogs() throws BlogNotFoundException {
        long count = blogService.getAllBlogs().stream().count();
        logger.info("Count All Blogs successfully   : " + count);
        return new ResponseEntity<List>(HttpStatus.FOUND);
    }

    @PutMapping("/{blogId}")
    public ResponseEntity updateExistingBlog(@RequestBody Blog blog, @PathVariable("blogId") int blogId) {
        Blog blog1 = blogService.updateExistingBlogByBlogId(blog, blogId);
        logger.info("Blog Updated successfully  : ");
        return new ResponseEntity<>(blog1, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{blogId}")
    public ResponseEntity deleteExistingBlogById(@PathVariable("blogId") int blogId) {
        blogService.deleteExistingBlogByBlogId(blogId);
        logger.info("Blog deleted successfully  : " + blogId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
