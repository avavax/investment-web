package com.investment.repositories;

import com.investment.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
