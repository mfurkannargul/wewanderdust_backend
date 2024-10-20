package com.wewanderdust.wewanderdust.blogWriting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/blogWriting")
public class BlogWritingController {

    private final BlogWritingService blogWritingService;

    @Autowired
    public BlogWritingController(BlogWritingService blogWritingService) {
        this.blogWritingService = blogWritingService;
    }

    @GetMapping
    public List<BlogWriting> getBlogWritings() {
        return blogWritingService.getBlogWritings();
    }

    @PostMapping
    public void addNewBlogWriting(@RequestBody BlogWriting blogWriting) {
        blogWritingService.addNewBlogWriting(blogWriting);
    }

    @DeleteMapping(path = "{blogID}")
    public void deleteBlogWriting(@PathVariable("blogID") Integer blogID) {
        blogWritingService.deleteBlogWriting(blogID);
    }

    @PutMapping(path = "{blogID}")
    public void updateBlogWriting(
            @PathVariable("blogID") Integer blogID,
            @RequestBody BlogWriting blogWritingUpdated) {
        blogWritingService.updateBlogWriting(blogID, blogWritingUpdated);
    }

}
