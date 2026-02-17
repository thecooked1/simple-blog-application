package com.example.blogapplication.services.impl;

import com.example.blogapplication.dto.UserRegistration;
import com.example.blogapplication.entities.User;
import com.example.blogapplication.repositories.UserRepository;
import com.example.blogapplication.services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void addUser(UserRegistration userRegistration) {
        User user = new User();
        user.setUsername(userRegistration.getUserName());
        user.setEmail(userRegistration.getEmail());
        user.setPassword(passwordEncoder.encode(userRegistration.getPassword()));
        user.setEnabled(true);

        System.out.println("------------------------------------------------");
        System.out.println("SAVING USER: " + user.getUsername());
        System.out.println("ENCODED PASS: " + user.getPassword());
        userRepository.save(user);
        System.out.println("USER SAVED SUCCESSFULLY TO DB!");
        System.out.println("------------------------------------------------");
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
}
