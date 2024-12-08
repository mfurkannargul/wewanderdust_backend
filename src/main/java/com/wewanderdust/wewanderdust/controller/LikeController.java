package com.wewanderdust.wewanderdust.controller;

import com.wewanderdust.wewanderdust.entity.Like;
import com.wewanderdust.wewanderdust.service.LikeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/likes")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping
    public ResponseEntity<Like> likeGuide(@RequestParam Long userId, @RequestParam Long guideId) {
        Like like = likeService.likeGuide(userId, guideId);
        return ResponseEntity.status(HttpStatus.CREATED).body(like);
    }

    @DeleteMapping
    public ResponseEntity<Void> unlikeGuide(@RequestParam Long userId, @RequestParam Long guideId) {
        likeService.unlikeGuide(userId, guideId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-guide/{guideId}")
    public ResponseEntity<List<Like>> getLikesByGuide(@PathVariable Long guideId) {
        List<Like> likes = likeService.getLikesByGuide(guideId);
        return ResponseEntity.ok(likes);
    }

    @GetMapping("/by-user/{userId}")
    public ResponseEntity<List<Like>> getLikesByUser(@PathVariable Long userId) {
        List<Like> likes = likeService.getLikesByUser(userId);
        return ResponseEntity.ok(likes);
    }
}