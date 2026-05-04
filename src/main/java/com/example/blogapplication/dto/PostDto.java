package com.example.blogapplication.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostDto {
    @NotBlank(message = "Title is required")
    @Size(min = 1)
    public String title;

    @NotBlank(message = "Content is required")
    @Size(min = 1)
    public String content;

    private List<Long> categoryIds;
}
