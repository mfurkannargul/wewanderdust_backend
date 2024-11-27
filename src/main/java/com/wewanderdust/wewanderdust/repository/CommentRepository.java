package com.wewanderdust.wewanderdust.repository;

import com.wewanderdust.wewanderdust.entity.Comment;
import com.wewanderdust.wewanderdust.entity.Guide;
import com.wewanderdust.wewanderdust.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    // Find all Comments for a specific Guide
    List<Comment> findByGuide(Guide guide);

    // Find all Comments by a specific User
    List<Comment> findByUser(User user);
}
