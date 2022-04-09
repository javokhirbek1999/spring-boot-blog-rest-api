package com.believer.springBootBlog.blog;


import com.believer.springBootBlog.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BlogService {

    private final BlogRepository blogRepository;
    private final UserRepository userRepository;

    @Autowired
    public BlogService(BlogRepository blogRepository, UserRepository userRepository) {
        this.blogRepository = blogRepository;
        this.userRepository = userRepository;
    }

    public List<Blog> getBlogPosts() {
        return blogRepository.findAll();
    }

    public void createBlogPost(Blog blog) {
        blog.setAuthor(userRepository.getById(blog.getContentAuthorId()));
        blog.setDatePosted(LocalDate.now());
        blog.setDateUpdated(LocalDate.now());
        blogRepository.save(blog);
    }
}
