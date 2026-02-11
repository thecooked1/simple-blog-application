package com.example.blogapplication.repositories;

import com.example.blogapplication.entities.Post;
import com.example.blogapplication.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findByAuthor(User author);

    List<Post> findByAuthorUsername(String username);

    List<Post> findByAuthorEmail(String email);

    List<Post> findAllByOrderByCreatedAtDesc();
}
