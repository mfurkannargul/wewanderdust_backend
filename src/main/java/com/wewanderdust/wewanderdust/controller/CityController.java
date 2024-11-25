package com.wewanderdust.wewanderdust.controller;

import com.wewanderdust.wewanderdust.entity.City;
import com.wewanderdust.wewanderdust.service.CityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/{countryId}")
    public List<City> getCitiesByCountry(@PathVariable Long countryId) {
        return cityService.getCitiesByCountry(countryId);
    }
}