package com.example.blogapplication.controllers;

import com.example.blogapplication.entities.Post;
import com.example.blogapplication.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private PostService postService;

    public HomeController(PostService postService) {
        this.postService = postService;
    }


    @GetMapping("/")
    public String index(Model model) {
        List<Post> posts = postService.findAllPosts();
        model.addAttribute("posts", posts);
        return "index";
    }
}
