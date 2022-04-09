package com.believer.springBootBlog.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/blog")
public class BlogController {

    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    public List<Blog> getPosts() {
        return blogService.getBlogPosts();
    }

    @PostMapping("/create")
    public void createPost(@RequestBody Blog blog) {
        blogService.createBlogPost(blog);
    }

}
