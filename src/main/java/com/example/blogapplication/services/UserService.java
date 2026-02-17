package com.example.blogapplication.services;

import com.example.blogapplication.dto.UserRegistration;
import com.example.blogapplication.entities.User;

public interface UserService {
    void addUser(UserRegistration userRegistration);
    User findUserByEmail(String email);
    User findUserByUsername(String username);
}
