package com.wewanderdust.wewanderdust.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class CreateBlogDTO {
    @NotBlank
    private String title;

    @NotBlank
    private String content;

    private Long author;  // Optional user ID

    private Set<Long> cities = new HashSet<>();
    private Set<Long> countries = new HashSet<>();
}
