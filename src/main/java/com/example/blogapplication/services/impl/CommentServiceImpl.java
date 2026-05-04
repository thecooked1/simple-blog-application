package com.example.blogapplication.services.impl;

import com.example.blogapplication.dto.CommentDto;
import com.example.blogapplication.entities.Comment;
import com.example.blogapplication.entities.Post;
import com.example.blogapplication.entities.User;
import com.example.blogapplication.repositories.CommentRepository;
import com.example.blogapplication.repositories.PostRepository;
import com.example.blogapplication.repositories.UserRepository;
import com.example.blogapplication.services.CommentService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void createComment(Long postId, CommentDto commentDto, String username) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        User author = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        Comment comment = new Comment();
        comment.setContent(commentDto.getContent());
        comment.setPost(post);
        comment.setAuthor(author);

        commentRepository.save(comment);
    }

    public List<Comment> findCommentsByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }
}
