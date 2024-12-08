package com.wewanderdust.wewanderdust;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wewanderdust.wewanderdust.entity.User;
import com.wewanderdust.wewanderdust.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class JwtAuthenticationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        // Ensure the test database is initialized
        userRepository.deleteAll();
        User testUser = new User();
        testUser.setUsername("testuser");
        testUser.setEmail("testuser@example.com");
        testUser.setPasswordHash("$2a$10$D5E0gVp0bB0asCQ.k4HxFOtL5.IqQ5Z7uNC9SyBMYh9KQlu4RHqAa"); // BCrypt encoded password for 'password'
        testUser.setRoles("ROLE_USER");
        userRepository.save(testUser);
    }

    @Test
    void testUserLoginAndAccessProtectedRoute() throws Exception {
        // Step 1: Login to get JWT token
        User loginRequest = new User();
        loginRequest.setUsername("testuser");
        loginRequest.setPasswordHash("password");

        String loginResponse = mockMvc.perform(post("/users/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginRequest)))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        // Extract token from response
        String token = extractTokenFromResponse(loginResponse);

        // Step 2: Access a protected route using the JWT token
        mockMvc.perform(get("/protected-route")
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk());
    }

    private String extractTokenFromResponse(String loginResponse) {
        // Assuming the token is returned as a plain string like "Bearer <JWT>"
        return loginResponse.replace("Bearer ", "");
    }

    @Test
    void testInvalidLogin() throws Exception {
        // Attempt login with incorrect credentials
        User invalidLoginRequest = new User();
        invalidLoginRequest.setUsername("invaliduser");
        invalidLoginRequest.setPasswordHash("wrongpassword");

        mockMvc.perform(post("/users/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalidLoginRequest)))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void testAccessProtectedRouteWithoutToken() throws Exception {
        // Attempt accessing a protected route without a token
        mockMvc.perform(get("/protected-route"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void testAccessProtectedRouteWithInvalidToken() throws Exception {
        // Attempt accessing a protected route with an invalid token
        String invalidToken = "invalid.token.value";

        mockMvc.perform(get("/protected-route")
                        .header("Authorization", "Bearer " + invalidToken))
                .andExpect(status().isUnauthorized());
    }
}