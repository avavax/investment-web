package com.investment.services;

import com.investment.models.Country;
import com.investment.repositories.CountryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DisplayName(value = "Country Service is working when")
class CountryServiceImplTest {

    @Mock
    private CountryRepository countryRepositoryMock;

    @InjectMocks
    private CountryServiceImpl countryService;

    @Test
    @DisplayName("getAllCountries() is working")
    void getAllCountries() {
        List<Country> countries = new ArrayList<>();
        countries.add(Country.builder().name("Country 1").build());
        countries.add(Country.builder().name("Country 2").build());

        Mockito.when(countryRepositoryMock.findAll(Sort.by("name"))).thenReturn(countries);
        List<Country> resultList = countryService.getAllCountries();

        assertEquals(2, resultList.size());
        Mockito.verify(countryRepositoryMock).findAll(Sort.by("name"));
    }

    @Test
    @DisplayName("getCountryById() is working")
    void getCountryById() {
        Country country = Country.builder().name("Country 1").build();
        Integer countryId = country.getId();

        Mockito.when(countryRepositoryMock.findById(countryId)).thenReturn(java.util.Optional.of(country));

        Country resultCountry = countryService.getCountryById(countryId);
        assertEquals(resultCountry, country);
        Mockito.verify(countryRepositoryMock).findById(countryId);
    }
}