package com.wewanderdust.wewanderdust.repository;

import com.wewanderdust.wewanderdust.entity.Guide;
import com.wewanderdust.wewanderdust.entity.Like;
import com.wewanderdust.wewanderdust.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {

    // Find a Like by User and Guide
    Optional<Like> findByUserAndGuide(User user, Guide guide);

    // Find all Likes for a specific Guide
    List<Like> findByGuide(Guide guide);

    // Find all Likes by a specific User
    List<Like> findByUser(User user);
}

