package com.wewanderdust.wewanderdust.blogWriting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

    public void addNewBlogWriting(BlogWriting blogWriting) {
        Optional<BlogWriting> blogByTitle = blogWritingRepository.findBlogWritingByTitle(blogWriting.getTitle());
        if (blogByTitle.isPresent()) {
            throw new IllegalStateException("Title already taken.");
        }
//        Optional<BlogWriting> blogByID = blogWritingRepository.findBlogWritingByID(blogWriting.getBlogId());
//        if (blogByID.isPresent()) {
//            throw new IllegalStateException("ID already taken.");
//        }
        blogWritingRepository.save(blogWriting);
        System.out.println(blogWriting);
    }

    public void deleteBlogWriting(Integer blogID) {
        if (!blogWritingRepository.existsById(blogID)) {
            throw new IllegalStateException("Blog with ID " + blogID + " does not exist!");
        }
        blogWritingRepository.deleteById(blogID);
    }

    @Transactional
    public void updateBlogWriting(Integer blogID, BlogWriting blogWritingUpdated) {
        BlogWriting blogWriting = blogWritingRepository.findById(blogID)
                .orElseThrow(() -> new IllegalStateException("The blog with given ID " + blogID + " does not exist!"));

        System.out.println((blogWritingUpdated.getTitle()));
        System.out.println(blogWritingUpdated.getTitle().equals(blogWriting.getTitle()));
        System.out.println(blogWritingRepository.findBlogWritingByTitle(blogWriting.getTitle()).isPresent());

        if ((blogWritingUpdated.getTitle() != null) && !blogWritingUpdated.getTitle().equals(blogWriting.getTitle())
                && blogWritingRepository.findBlogWritingByTitle(blogWritingUpdated.getTitle()).isEmpty())
            blogWriting.setTitle(blogWritingUpdated.getTitle());

        System.out.println(blogWritingUpdated.getAuthor());
        System.out.println(blogWritingUpdated.getAuthor().equals(blogWriting.getAuthor()));
        if (blogWritingUpdated.getAuthor() != null && !blogWritingUpdated.getAuthor().equals(blogWriting.getAuthor()))
            blogWriting.setAuthor(blogWritingUpdated.getAuthor());

        System.out.println(blogWritingUpdated.getContent());
        System.out.println(blogWritingUpdated.getContent().equals(blogWriting.getContent()));
        if (blogWritingUpdated.getContent() != null && !blogWritingUpdated.getContent().equals(blogWriting.getContent()))
            blogWriting.setContent(blogWritingUpdated.getContent());

        System.out.println(blogWritingUpdated.getDate());
        System.out.println(blogWritingUpdated.getDate().equals(blogWriting.getDate()));
        if (blogWritingUpdated.getDate() != null && !blogWritingUpdated.getDate().equals(blogWriting.getDate()))
            blogWriting.setDate(blogWritingUpdated.getDate());

        System.out.println(Arrays.equals(blogWritingUpdated.getTags(), blogWriting.getTags()));
        if (!Arrays.equals(blogWritingUpdated.getTags(), blogWriting.getTags()))
            blogWriting.setTags(blogWritingUpdated.getTags());

//        blogWritingRepository.save(blogWriting);
    }
}
