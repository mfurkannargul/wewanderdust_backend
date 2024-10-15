package com.wewanderdust.wewanderdust.blogWriting;

import com.wewanderdust.wewanderdust.user.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class BlogWritingConfig {

    @Bean
    CommandLineRunner commandLineRunner(BlogWritingRepository blogRepo) {
        return args -> {

            BlogWriting blog1 = new BlogWriting(1,
                    "Seyahat Tutkusu",
                    "furkan",
                    "travel",
                    LocalDate.of(2024,OCTOBER,10),
                    new String[]{""} );

            BlogWriting blog2 = new BlogWriting(2,
                    "Yazma Tutkusu",
                    "furkan",
                    "writing",
                    LocalDate.of(2024,OCTOBER,15),
                    new String[]{""} );

            blogRepo.saveAll(
                    List.of(blog1, blog2)
            );
        };
    }
}
