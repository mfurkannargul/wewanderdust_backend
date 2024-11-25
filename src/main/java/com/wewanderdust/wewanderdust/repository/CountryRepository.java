package com.wewanderdust.wewanderdust.repository;

import com.wewanderdust.wewanderdust.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
