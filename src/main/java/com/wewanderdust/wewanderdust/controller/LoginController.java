package com.wewanderdust.wewanderdust.controller;

import com.wewanderdust.wewanderdust.security.JwtUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final JwtUtil jwtUtil;

    public LoginController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping
    public String login(@RequestParam String username, @RequestParam String password) {
        // Authenticate user credentials here
        // In a real scenario, you will validate the username and password with a service

        // If authentication is successful, generate the JWT token
        return jwtUtil.generateToken(username);
    }
}
