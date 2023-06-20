package com.sat.webd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sat.webd.models.Blog;
import com.sat.webd.repository.BlogRepository;

import java.io.IOException;
import java.util.List;

@Service
public class BlogService {
    private final BlogRepository blogRepository;

    @Autowired
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    public Blog getBlogById(long id) {
        return blogRepository.findById(id).orElse(null);
    }
    
    public Blog createBlog(String title, String author, MultipartFile image, String description, String quote) {
    	Blog blog = new Blog();
    	blog.setTitle(title);
    	blog.setAuthor(author);
    	blog.setDate(java.time.LocalDate.now());
    	blog.setTime(java.time.LocalTime.now());
    	byte[] imageData = null;
		try {
			imageData = image.getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	blog.setImage(imageData);
    	blog.setDescription(description);
    	blog.setQuote(quote);
    	return blogRepository.save(blog);
	}

    public Blog updateBlog(long id, Blog updatedBlog) {
        Blog existingBlog = blogRepository.findById(id).orElse(null);
        if (existingBlog != null) {
            existingBlog.setTitle(updatedBlog.getTitle());
            existingBlog.setAuthor(updatedBlog.getAuthor());
            existingBlog.setDate(updatedBlog.getDate());
            existingBlog.setTime(updatedBlog.getTime());
            existingBlog.setImage(updatedBlog.getImage());
            existingBlog.setDescription(updatedBlog.getDescription());
            existingBlog.setQuote(updatedBlog.getQuote());
            return blogRepository.save(existingBlog);
        }
        return null;
    }

    public boolean deleteBlog(long id) {
        if (blogRepository.existsById(id)) {
            blogRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
