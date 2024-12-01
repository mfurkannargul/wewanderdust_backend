package com.wewanderdust.wewanderdust.controller;

import com.wewanderdust.wewanderdust.entity.Guide;
import com.wewanderdust.wewanderdust.service.GuideService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/guides")
public class GuideController {

    private final GuideService guideService;

    public GuideController(GuideService guideService) {
        this.guideService = guideService;
    }

    @GetMapping("/country/{countryId}")
    public List<Guide> getGuidesByCountry(@PathVariable Long countryId) {
        return guideService.getGuidesByCountry(countryId);
    }

    @GetMapping("/city/{cityId}")
    public List<Guide> getGuidesByCity(@PathVariable Long cityId) {
        return guideService.getGuidesByCity(cityId);
    }
}
