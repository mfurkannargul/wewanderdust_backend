package com.wewanderdust.wewanderdust.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogDTO {
    private Long id;
    private String title;
    private Long author;  // Author's user ID
    private String content;
    private Set<Long> cities;      // Just store city IDs in the DTO
    private Set<Long> countries;   // Just store country IDs in the DTO
}
