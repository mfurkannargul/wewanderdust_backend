package com.wewanderdust.wewanderdust.service;

import com.wewanderdust.wewanderdust.entity.Guide;
import com.wewanderdust.wewanderdust.repository.GuideRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuideService {

    private final GuideRepository guideRepository;

    public GuideService(GuideRepository guideRepository) {
        this.guideRepository = guideRepository;
    }

    public List<Guide> getGuidesByCountry(Long countryId) {
        return guideRepository.findByCountryId(countryId);
    }

    public List<Guide> getGuidesByCity(Long cityId) {
        return guideRepository.findByCityId(cityId);
    }
}
