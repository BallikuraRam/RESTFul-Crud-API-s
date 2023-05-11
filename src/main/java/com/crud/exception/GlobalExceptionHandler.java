package com.crud.exception;

import com.crud.model.Blog;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Component
public class GlobalExceptionHandler {
    @ExceptionHandler(value = BlogAlreadyExistsException.class)
    public ResponseEntity handleBlogAlreadyExistsException(BlogAlreadyExistsException blogAlreadyExistsException) {
        return new ResponseEntity<>("Blog already exists ", HttpStatus.CONFLICT);
    }
    @ExceptionHandler(value = BlogNotFoundException.class)
    public ResponseEntity handleBlogNotFoundException(BlogNotFoundException blogNotFoundException) {
        Blog blog = new Blog();
        return new ResponseEntity("Blog not Exist With This id " + blog.getBlogId(), HttpStatus.CONFLICT);
    }
}
