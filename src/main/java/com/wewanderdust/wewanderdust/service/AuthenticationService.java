package com.wewanderdust.wewanderdust.service;

import com.wewanderdust.wewanderdust.dto.LoginUserDTO;
import com.wewanderdust.wewanderdust.dto.RegisterUserDTO;
import com.wewanderdust.wewanderdust.entity.User;
import com.wewanderdust.wewanderdust.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(RegisterUserDTO input) {
        User user = new User();
        user.setUsername(input.getUsername());
        user.setEmail(input.getEmail());
        user.setPasswordHash(passwordEncoder.encode(input.getPasswordHash()));
        user.setRoles(input.getRoles());

        return userRepository.save(user);
    }

    public User authenticate(LoginUserDTO input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPasswordHash()
                )
        );

        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }
}