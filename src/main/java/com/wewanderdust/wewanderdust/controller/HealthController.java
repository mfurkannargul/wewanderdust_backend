package com.wewanderdust.wewanderdust.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HealthController {
    @GetMapping("/health")
    public ResponseEntity<String> getHealth() {
        return ResponseEntity.status(200).body("Healthy");
    }
}
