package com.example.blogapplication.configs;

import com.example.blogapplication.entities.Category;
import com.example.blogapplication.entities.User;
import com.example.blogapplication.repositories.CategoryRepository;
import com.example.blogapplication.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(UserRepository userRepository,
                                      CategoryRepository categoryRepository,
                                      PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setEmail("admin@blog.com");
                admin.setPassword(passwordEncoder.encode("123"));
                admin.setEnabled(true);

                userRepository.save(admin);
                System.out.println("DEBUG: Admin user created (Username: admin, Password: admin123)");
            }


            if (categoryRepository.count() == 0) {
                saveCategory(categoryRepository, "Movies", "Posts about Movies");
                saveCategory(categoryRepository, "Games", "Everything about Games");
                saveCategory(categoryRepository, "Tech", "Tech news");
                System.out.println("DEBUG: Default categories created");
            }
        };
    }

    private void saveCategory(CategoryRepository repo, String name, String desc) {
        Category cat = new Category();
        cat.setName(name);
        cat.setDescription(desc);
        repo.save(cat);
    }
}