package com.wewanderdust.wewanderdust.blogWriting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path =  "api/v1/blogWriting")
public class BlogWritingController {

    private final BlogWritingService blogWritingService;

    @Autowired
    public BlogWritingController(BlogWritingService blogWritingService) {
        this.blogWritingService = blogWritingService;
    }

    @GetMapping
    public List<BlogWriting> getBlogWritings(){
        return blogWritingService.getBlogWritings();
    }

}
