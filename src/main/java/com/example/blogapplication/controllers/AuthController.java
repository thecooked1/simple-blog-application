package com.example.blogapplication.controllers;

import com.example.blogapplication.dto.UserRegistration;
import com.example.blogapplication.entities.User;
import com.example.blogapplication.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(Model model) {
        UserRegistration user = new UserRegistration();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
    public String registration(User user, Model model, UserRegistration userRegistration) {
        if(userService.findUserByEmail(userRegistration.getEmail()) != null){
            return "register";
        }

        if(userService.findUserByUsername(userRegistration.getUserName()) != null){
            return "register";
        }

        userService.addUser(userRegistration);

        return "redirect:/login?success";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
