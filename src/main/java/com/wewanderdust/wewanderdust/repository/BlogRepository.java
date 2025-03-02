package com.wewanderdust.wewanderdust.repository;

import com.wewanderdust.wewanderdust.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}
