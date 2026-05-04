package com.example.blogapplication.controllers;

import com.example.blogapplication.dto.CommentDto;
import com.example.blogapplication.dto.PostDto;
import com.example.blogapplication.entities.Post;
import com.example.blogapplication.repositories.CategoryRepository;
import com.example.blogapplication.services.PostService;
import com.example.blogapplication.services.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.blogapplication.services.CommentService;

import java.security.Principal;

@Controller
public class PostController {
    private final PostService postService;
    private final CommentService commentService;
    private final CategoryRepository categoryRepository;

    public PostController(PostService postService, CommentService commentService, CategoryRepository categoryRepository) {
        this.postService = postService;
        this.commentService = commentService;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/posts/new")
    public String newPost(Model model) {
        model.addAttribute("post", new PostDto());
        model.addAttribute("allCategories", categoryRepository.findAll());
        return "post";
    }

    @PostMapping("/posts")
    public String createPost(@Valid @ModelAttribute("post") PostDto postDto, Principal principal,
                             BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("allCategories", categoryRepository.findAll());
            return "post";}
        String username =  principal.getName();
        postService.addPost(postDto, username);
        return "redirect:/?success";
    }

    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable Long id, Model model) {
        Post post = postService.findPostById(id);
        model.addAttribute("post", post);
        model.addAttribute("commentDto", new CommentDto());
        return "post-details";
    }

    @PostMapping("/posts/{id}/comments")
    public String addComment(@PathVariable Long id, @Valid @ModelAttribute("commentDto") CommentDto commentDto,
                             BindingResult bindingResult, Model model, Principal principal) {
        if(bindingResult.hasErrors()) {
            Post post =  postService.findPostById(id);
            model.addAttribute("post", post);
            return  "post-details";}
        commentService.createComment(id, commentDto, principal.getName());
        return "redirect:/posts/" + id;
    }

}
