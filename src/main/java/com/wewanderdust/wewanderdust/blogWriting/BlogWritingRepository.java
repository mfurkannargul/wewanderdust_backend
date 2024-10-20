package com.wewanderdust.wewanderdust.blogWriting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlogWritingRepository extends JpaRepository<BlogWriting, Integer>{

    @Query("SELECT blog FROM BlogWriting blog WHERE blog.title = ?1")
    Optional<BlogWriting> findBlogWritingByTitle(String title);

    @Query("SELECT blog FROM BlogWriting blog WHERE blog.id = ?1")
    Optional<BlogWriting> findBlogWritingByID(Integer id);

}
