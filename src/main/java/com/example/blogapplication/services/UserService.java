package com.example.blogapplication.services;

import com.example.blogapplication.dto.UserRegistrationDto;
import com.example.blogapplication.entities.User;

public interface UserService {
    void addUser(UserRegistrationDto userRegistrationDto);
    User findUserByEmail(String email);
    User findUserByUsername(String username);
}
