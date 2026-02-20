package com.example.blogapplication.controllers;

import com.example.blogapplication.dto.PostDto;
import com.example.blogapplication.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts/new")
    public String newPost(Model model) {
        PostDto postDto = new PostDto();
        model.addAttribute("post", postDto);
        return "post";
    }

    @PostMapping("/posts")
    public String createPost(PostDto postDto, Principal principal) {
        String username =  principal.getName();
        postService.addPost(postDto, username);
        return "redirect:/?success";
    }
}
