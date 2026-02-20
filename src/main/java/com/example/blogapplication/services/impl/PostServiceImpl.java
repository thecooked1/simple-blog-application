package com.example.blogapplication.services.impl;

import com.example.blogapplication.dto.PostDto;
import com.example.blogapplication.entities.Post;
import com.example.blogapplication.entities.User;
import com.example.blogapplication.repositories.PostRepository;
import com.example.blogapplication.repositories.UserRepository;
import com.example.blogapplication.services.PostService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;
    private UserRepository userRepository;

    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void addPost(PostDto postDto, String username) {
        User author = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + "not found"));
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setAuthor(author);
        postRepository.save(post);
    }

    @Override
    public List<Post> findAllPosts() {
        return postRepository.findAllByOrderByCreatedAtDesc();
    }

    @Override
    public List<Post> findPostsByAuthor(User user) {
        return postRepository.findByAuthor(user);
    }

    @Override
    public List<Post> findPostsByAuthorEmail(String email) {
        return postRepository.findByAuthorEmail(email);
    }

}
