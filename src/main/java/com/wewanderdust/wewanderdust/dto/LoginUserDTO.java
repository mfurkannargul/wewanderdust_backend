package com.wewanderdust.wewanderdust.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserDTO {
    private String email;
    private String passwordHash;
}
