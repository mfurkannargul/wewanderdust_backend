package com.wewanderdust.wewanderdust.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules(); // Enable JavaTimeModule for handling date/time
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); // ISO-8601 formatting
        return objectMapper;
    }
}
