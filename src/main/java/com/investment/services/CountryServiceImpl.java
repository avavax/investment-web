package com.investment.services;

import com.investment.exceptions.PageNotFoundException;
import com.investment.models.Country;
import com.investment.repositories.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll(Sort.by("name"));
    }

    @Override
    public Country getCountryById(Integer id) {
        return countryRepository.findById(id).orElseThrow(PageNotFoundException::new);
    }
}
