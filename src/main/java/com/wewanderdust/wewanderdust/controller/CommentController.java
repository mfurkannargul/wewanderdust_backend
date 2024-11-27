package com.wewanderdust.wewanderdust.controller;

import com.wewanderdust.wewanderdust.entity.Comment;
import com.wewanderdust.wewanderdust.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<Comment> addComment(@RequestParam Long guideId, @RequestParam Long userId, @RequestBody String content) {
        Comment comment = commentService.addComment(guideId, userId, content);
        return ResponseEntity.status(HttpStatus.CREATED).body(comment);
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long commentId, @RequestBody String content) {
        Comment updatedComment = commentService.updateComment(commentId, content);
        return ResponseEntity.ok(updatedComment);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-guide/{guideId}")
    public ResponseEntity<List<Comment>> getCommentsByGuide(@PathVariable Long guideId) {
        List<Comment> comments = commentService.getCommentsByGuide(guideId);
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/by-user/{userId}")
    public ResponseEntity<List<Comment>> getCommentsByUser(@PathVariable Long userId) {
        List<Comment> comments = commentService.getCommentsByUser(userId);
        return ResponseEntity.ok(comments);
    }
}
