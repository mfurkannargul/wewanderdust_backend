package com.wewanderdust.wewanderdust.service;

import com.wewanderdust.wewanderdust.entity.Guide;
import com.wewanderdust.wewanderdust.entity.Like;
import com.wewanderdust.wewanderdust.entity.User;
import com.wewanderdust.wewanderdust.repository.GuideRepository;
import com.wewanderdust.wewanderdust.repository.LikeRepository;
import com.wewanderdust.wewanderdust.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeService {

    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final GuideRepository guideRepository;

    public LikeService(LikeRepository likeRepository, UserRepository userRepository, GuideRepository guideRepository) {
        this.likeRepository = likeRepository;
        this.userRepository = userRepository;
        this.guideRepository = guideRepository;
    }

    public Like likeGuide(Long userId, Long guideId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));
        Guide guide = guideRepository.findById(guideId)
                .orElseThrow(() -> new IllegalArgumentException("Guide not found with id: " + guideId));

        Optional<Like> existingLike = likeRepository.findByUserAndGuide(user, guide);
        if (existingLike.isPresent()) {
            throw new IllegalStateException("User already liked this guide");
        }

        Like like = new Like();
        like.setUser(user);
        like.setGuide(guide);
        return likeRepository.save(like);
    }

    public void unlikeGuide(Long userId, Long guideId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));
        Guide guide = guideRepository.findById(guideId)
                .orElseThrow(() -> new IllegalArgumentException("Guide not found with id: " + guideId));

        Like like = likeRepository.findByUserAndGuide(user, guide)
                .orElseThrow(() -> new IllegalStateException("Like not found for this user and guide"));
        likeRepository.delete(like);
    }

    public List<Like> getLikesByGuide(Long guideId) {
        Guide guide = guideRepository.findById(guideId)
                .orElseThrow(() -> new IllegalArgumentException("Guide not found with id: " + guideId));
        return likeRepository.findByGuide(guide);
    }

    public List<Like> getLikesByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));
        return likeRepository.findByUser(user);
    }
}
