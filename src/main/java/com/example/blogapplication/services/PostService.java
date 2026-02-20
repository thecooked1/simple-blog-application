package com.example.blogapplication.services;

import com.example.blogapplication.dto.PostDto;
import com.example.blogapplication.entities.Post;
import com.example.blogapplication.entities.User;

import java.util.List;

public interface PostService {
    void addPost(PostDto postDto, String username);
    List<Post> findAllPosts();
    List<Post> findPostsByAuthor(User user);
    List<Post> findPostsByAuthorEmail(String email);

}
