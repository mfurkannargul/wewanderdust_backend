package com.wewanderdust.wewanderdust.repository;

import com.wewanderdust.wewanderdust.entity.Guide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuideRepository extends JpaRepository<Guide, Long> {
    List<Guide> findByCountryId(Long countryId);
    List<Guide> findByCityId(Long cityId);
    List<Guide> findByCreatedById(Long userId);
}