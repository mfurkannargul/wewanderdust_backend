package com.wewanderdust.wewanderdust.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256); // Generate a strong secret key
    private static final long EXPIRATION_TIME = 86400000L; // Token expiration time (1 day in milliseconds)

    // Generate JWT token for a user
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)               // Set the subject as username
                .setIssuedAt(new Date())            // Issue time as current time
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // Set expiration time
                .signWith(secretKey)               // Sign the token with secret key
                .compact();                        // Create and return compact JWT
    }

    // Extract username from JWT token
    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)          // Validate the token with secret key
                .build()
                .parseClaimsJws(token)             // Parse claims from the token
                .getBody()
                .getSubject();                     // Return the subject (username)
    }

    // Validate JWT token
    public boolean validateToken(String token, String username) {
        String extractedUsername = extractUsername(token);
        return (username.equals(extractedUsername) && !isTokenExpired(token)); // Check username match and expiration
    }

    // Check if the JWT token has expired
    private boolean isTokenExpired(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration()
                .before(new Date()); // Check if expiration date is before current time
    }
}
