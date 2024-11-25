package com.wewanderdust.wewanderdust.repository;

import com.wewanderdust.wewanderdust.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByUserIdAndGuideId(Long userId, Long guideId);
}
