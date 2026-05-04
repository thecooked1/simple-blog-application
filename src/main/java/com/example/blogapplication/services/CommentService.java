package com.example.blogapplication.services;

import com.example.blogapplication.dto.CommentDto;
import com.example.blogapplication.entities.Comment;
import com.example.blogapplication.entities.Post;
import com.example.blogapplication.entities.User;
import com.example.blogapplication.repositories.CommentRepository;
import com.example.blogapplication.repositories.PostRepository;
import com.example.blogapplication.repositories.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    void createComment(Long postId, CommentDto commentDto, String username);

}