package com.wewanderdust.wewanderdust.config;

import com.wewanderdust.wewanderdust.entity.City;
import com.wewanderdust.wewanderdust.entity.Country;
import com.wewanderdust.wewanderdust.entity.Guide;
import com.wewanderdust.wewanderdust.entity.User;
import com.wewanderdust.wewanderdust.repository.CityRepository;
import com.wewanderdust.wewanderdust.repository.CountryRepository;
import com.wewanderdust.wewanderdust.repository.GuideRepository;
import com.wewanderdust.wewanderdust.service.CountryService;
import com.wewanderdust.wewanderdust.service.GuideService;
import com.wewanderdust.wewanderdust.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner commandLineRunner(UserService userService, GuideRepository guideRepository,
                                               CountryRepository countryRepository, CountryService countryService,
                                               CityRepository cityRepository) {
        return args -> {
            // Add a sample user
//            if (userService.findByUsername("testuser").isEmpty()) {
//                User user = new User();
//                user.setId(1L);
//                user.setUsername("testuser");
//                user.setEmail("furkan@gmail.com");
//                user.setPasswordHash("password"); // Use UserService to encode the password
//                user.setCreatedAt(LocalDateTime.now());
//                user.setRoles("admin");
//                userService.registerUser(user);
//            }

            Country turkey = new Country();
            turkey.setName("Türkiye");

            Country scotland = new Country();
            scotland.setName("İskoçya");

            Country egypt = new Country();
            egypt.setName("Mısır");

//            countryRepository.save(egypt);

            // Add sample cities
            City edinburgh = new City();
            edinburgh.setName("Edinburgh");
            edinburgh.setCountry(scotland);

            City istanbul = new City();
            istanbul.setName("Istanbul");
            istanbul.setCountry(turkey);

//            cityRepository.saveAll(
//                    List.of(istanbul, edinburgh));

            Guide istanbulGuide = new Guide();
            istanbulGuide.setTitle("Istanbul Seyahat Rehberi");
            istanbulGuide.setCountry(turkey);
            istanbulGuide.setCity(istanbul);

            Guide edinburghGuide = new Guide();
            edinburghGuide.setTitle("Edinburgh Seyahat Rehberi");
            edinburghGuide.setCountry(scotland);
            edinburghGuide.setCity(edinburgh);

//            guideRepository.saveAll(
//                    List.of(istanbulGuide, edinburghGuide));
        };
    }
}
