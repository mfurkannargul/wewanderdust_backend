package com.wewanderdust.wewanderdust.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserDTO {
    private String email;

    private String passwordHash;

    private String username;

    private String roles;
}
