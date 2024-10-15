package com.wewanderdust.wewanderdust.blogWriting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogWritingRepository extends JpaRepository<BlogWriting, Integer>{

}
