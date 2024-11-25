package com.wewanderdust.wewanderdust.repository;

import com.wewanderdust.wewanderdust.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByGuideId(Long guideId);
}
