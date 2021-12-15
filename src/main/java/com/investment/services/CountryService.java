package com.investment.services;

import com.investment.models.Country;

import java.util.List;

public interface CountryService {
    List<Country> getAllCountries();
    Country getCountryById(Integer id);
}
