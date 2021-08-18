package com.github.denilzalima.citiesapi;


import com.github.denilzalima.citiesapi.repository.countries.Country;
import com.github.denilzalima.citiesapi.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


@RestController
public class CountryResource {
    @Autowired
    private final CountryRepository repository;

    public CountryResource(final CountryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/countries")
    public Page<Country> cities(Pageable page) {

        return repository.findAll(page);
    }
        @GetMapping("/{id}")
        public ResponseEntity<Country> getOne(@PathVariable Long id){
           Optional<Country>optional = repository.findById(id);
           if (optional.isPresent()){
            return ResponseEntity.ok().body(optional.get());
           }else

            return  ResponseEntity.notFound().build();
        }



}