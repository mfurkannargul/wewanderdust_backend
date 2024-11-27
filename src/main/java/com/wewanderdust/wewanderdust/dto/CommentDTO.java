package com.wewanderdust.wewanderdust.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {
    private Long id;
    private Long guideId;
    private Long userId;

    @NotEmpty(message = "Comment content must not be empty")
    private String content;

    private String createdAt;
}

