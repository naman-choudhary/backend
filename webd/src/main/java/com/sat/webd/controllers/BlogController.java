package com.sat.webd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.sat.webd.models.Blog;
import com.sat.webd.services.BlogService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/blogs")
@CrossOrigin(origins = "http://localhost:3000")
public class BlogController {
    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    public ResponseEntity<List<Blog>> getAllBlogs() {
        List<Blog> blogs = blogService.getAllBlogs();
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable long id) {
        Blog blog = blogService.getBlogById(id);
        if (blog != null) {
            return new ResponseEntity<>(blog, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Blog> createBlog(@RequestParam("title") String title,
    		@RequestParam("author") String author,
    		@RequestParam("image") MultipartFile image,
    		@RequestParam("description") String description,
    		@RequestParam("quote") String quote) {
        Blog createdBlog = blogService.createBlog(title,author,image,description,quote);
        return new ResponseEntity<>(createdBlog, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable long id, @RequestBody Blog updatedBlog) {
        Blog blog = blogService.updateBlog(id, updatedBlog);
        if (blog != null) {
            return new ResponseEntity<>(blog, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable long id) {
        boolean deleted = blogService.deleteBlog(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
