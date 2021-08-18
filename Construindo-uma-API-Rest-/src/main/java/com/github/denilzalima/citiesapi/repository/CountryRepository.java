package com.github.denilzalima.citiesapi.repository;

import com.github.denilzalima.citiesapi.repository.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
