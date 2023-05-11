package com.crud.service;

import com.crud.exception.BlogAlreadyExistsException;
import com.crud.exception.BlogNotFoundException;
import com.crud.model.Blog;
import com.crud.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class BlogServiceImpl implements BlogService {

    private final BlogRepository repository;

    @Override
    public Blog saveBlog(Blog blog) {
        if (repository.existsById(blog.getBlogId())) {
            throw new BlogAlreadyExistsException();
        }
        return repository.save(blog);
    }
    @Override
    public Blog getById(int id) throws BlogNotFoundException {
        Blog blog;
        if (repository.findById(id).isEmpty()) {
            throw new BlogNotFoundException();
        } else {
            blog = repository.findById(id).get();
        }
        return blog;
    }

    @Override
    public List getAllBlogs() throws BlogNotFoundException {
        return (List) repository.findAll();
    }

    @Override
    public Blog updateExistingBlogByBlogId(Blog blog, int blogId) {
        Blog blog1;
        if (repository.findById(blogId).isEmpty()) {
            throw new BlogNotFoundException();
        } else {
            Blog save = repository.save(blog);
        }
        return repository.save(blog);
    }

    @Override
    public void deleteExistingBlogByBlogId(int blogId) {
        if (repository.findById(blogId).isPresent()) {
            repository.deleteById(blogId);
        }
        else {
            throw new BlogNotFoundException();
        }

    }
}
