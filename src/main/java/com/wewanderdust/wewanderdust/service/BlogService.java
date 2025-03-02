package com.wewanderdust.wewanderdust.service;

import com.wewanderdust.wewanderdust.dto.BlogDTO;
import com.wewanderdust.wewanderdust.dto.CreateBlogDTO;
import com.wewanderdust.wewanderdust.entity.Blog;
import com.wewanderdust.wewanderdust.entity.City;
import com.wewanderdust.wewanderdust.entity.Country;
import com.wewanderdust.wewanderdust.entity.User;
import com.wewanderdust.wewanderdust.repository.BlogRepository;
import com.wewanderdust.wewanderdust.repository.CityRepository;
import com.wewanderdust.wewanderdust.repository.CountryRepository;
import com.wewanderdust.wewanderdust.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final UserRepository userRepository;
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    public List<BlogDTO> getAllBlogs() {
        return blogRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public BlogDTO getBlogById(Long id) {
        return blogRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("Blog not found"));
    }

    public BlogDTO createBlog(CreateBlogDTO createBlogDTO) {
        User author = userRepository.findById(createBlogDTO.getAuthor())
                .orElseThrow(() -> new RuntimeException("Author not found"));
        Blog blog = new Blog();
        blog.setTitle(createBlogDTO.getTitle());
        blog.setContent(createBlogDTO.getContent());
        blog.setAuthor(author);

        List<City> cityList = cityRepository.findAllById(createBlogDTO.getCities());
        Set<City> cities = new HashSet<>(cityList);
        blog.setCities(cities);

        List<Country> countryList = countryRepository.findAllById(createBlogDTO.getCountries());
        Set<Country> countries = new HashSet<>(countryList);
        blog.setCountries(countries);

        Blog savedBlog = blogRepository.save(blog);
        return convertToDTO(savedBlog);  // This must return a BlogDTO, not a CreateBlogDTO.
    }

    public BlogDTO updateBlog(Long id, BlogDTO blogDTO) {
        Blog blog = blogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog not found"));

        blog.setTitle(blogDTO.getTitle());
        blog.setContent(blogDTO.getContent());

        // Update author (optional — if you want to allow updating the author)
        User author = userRepository.findById(blogDTO.getAuthor())
                .orElseThrow(() -> new RuntimeException("Author not found"));
        blog.setAuthor(author);

        // Update cities
        Set<City> cities = blogDTO.getCities().stream()
                .map(cityId -> cityRepository.findById(Long.valueOf(cityId))
                        .orElseThrow(() -> new RuntimeException("City not found: " + cityId)))
                .collect(Collectors.toSet());
        blog.setCities(cities);

        // Update countries
        Set<Country> countries = blogDTO.getCountries().stream()
                .map(countryId -> countryRepository.findById(Long.valueOf(countryId))
                        .orElseThrow(() -> new RuntimeException("Country not found: " + countryId)))
                .collect(Collectors.toSet());
        blog.setCountries(countries);

        Blog updatedBlog = blogRepository.save(blog);
        return convertToDTO(updatedBlog);
    }

    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }

    private BlogDTO convertToDTO(Blog blog) {
        BlogDTO dto = new BlogDTO();
        dto.setId(blog.getId());
        dto.setTitle(blog.getTitle());
        dto.setAuthor(blog.getAuthor().getId());
        dto.setContent(blog.getContent());

        Set<Long> cityIds = blog.getCities().stream()
                .map(City::getId)
                .collect(Collectors.toSet());
        dto.setCities(cityIds);

        Set<Long> countryIds = blog.getCountries().stream()
                .map(Country::getId)
                .collect(Collectors.toSet());
        dto.setCountries(countryIds);

        return dto;
    }

    private Blog convertToEntity(BlogDTO dto) {
        Blog blog = new Blog();
        blog.setTitle(dto.getTitle());
        blog.setContent(dto.getContent());

        User author = userRepository.findById(dto.getAuthor())
                .orElseThrow(() -> new RuntimeException("Author not found"));
        blog.setAuthor(author);

        Set<City> cities = dto.getCities().stream()
                .map(cityId -> cityRepository.findById(Long.valueOf(cityId))
                        .orElseThrow(() -> new RuntimeException("City not found: " + cityId)))
                .collect(Collectors.toSet());
        blog.setCities(cities);

        Set<Country> countries = dto.getCountries().stream()
                .map(countryId -> countryRepository.findById(Long.valueOf(countryId))
                        .orElseThrow(() -> new RuntimeException("Country not found: " + countryId)))
                .collect(Collectors.toSet());
        blog.setCountries(countries);

        return blog;
    }
}
