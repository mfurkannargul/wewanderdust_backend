package com.wewanderdust.wewanderdust.service;

import com.wewanderdust.wewanderdust.entity.Comment;
import com.wewanderdust.wewanderdust.entity.Guide;
import com.wewanderdust.wewanderdust.entity.User;
import com.wewanderdust.wewanderdust.repository.CommentRepository;
import com.wewanderdust.wewanderdust.repository.GuideRepository;
import com.wewanderdust.wewanderdust.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final GuideRepository guideRepository;

    public CommentService(CommentRepository commentRepository, UserRepository userRepository, GuideRepository guideRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.guideRepository = guideRepository;
    }

    public Comment addComment(Long guideId, Long userId, String content) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));
        Guide guide = guideRepository.findById(guideId)
                .orElseThrow(() -> new IllegalArgumentException("Guide not found with id: " + guideId));

        Comment comment = new Comment();
        comment.setUser(user);
        comment.setGuide(guide);
        comment.setContent(content);
        return commentRepository.save(comment);
    }

    public Comment updateComment(Long commentId, String content) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("Comment not found with id: " + commentId));
        comment.setContent(content);
        return commentRepository.save(comment);
    }

    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("Comment not found with id: " + commentId));
        commentRepository.delete(comment);
    }

    public List<Comment> getCommentsByGuide(Long guideId) {
        Guide guide = guideRepository.findById(guideId)
                .orElseThrow(() -> new IllegalArgumentException("Guide not found with id: " + guideId));
        return commentRepository.findByGuide(guide);
    }

    public List<Comment> getCommentsByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));
        return commentRepository.findByUser(user);
    }
}

