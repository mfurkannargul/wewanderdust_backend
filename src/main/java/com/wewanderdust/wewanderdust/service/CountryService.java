package com.wewanderdust.wewanderdust.service;

import com.wewanderdust.wewanderdust.entity.Country;
import com.wewanderdust.wewanderdust.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

}
