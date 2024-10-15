package com.wewanderdust.wewanderdust.blogWriting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Service
public class BlogWritingService {

    private final BlogWritingRepository blogWritingRepository;

    @Autowired
    public BlogWritingService(BlogWritingRepository blogWritingRepository) {
        this.blogWritingRepository = blogWritingRepository;
    }

    @GetMapping
    public List<BlogWriting> getBlogWritings() {
        return blogWritingRepository.findAll();

//        return List.of(
//                new BlogWriting(1,
//                        "Seyahat Tutkusu",
//                        "furkan",
//                        "travel",
//                        LocalDate.of(2024,10,10),
//                        new String[]{""} ));
    }
}
