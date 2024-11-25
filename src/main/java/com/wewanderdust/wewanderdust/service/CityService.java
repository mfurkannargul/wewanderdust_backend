package com.wewanderdust.wewanderdust.service;

import com.wewanderdust.wewanderdust.entity.City;
import com.wewanderdust.wewanderdust.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getCitiesByCountry(Long countryId) {
        return cityRepository.findByCountryId(countryId);
    }
}
