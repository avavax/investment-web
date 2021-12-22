package com.investment.repositories;

import com.investment.models.Country;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@RunWith(SpringRunner.class)
@DisplayName(value = "Country Repository is working when")
class CountryRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CountryRepository countryRepository;

    @Test
    @DisplayName("getAllCountries() is working")
    public void getAllCountries() {
        Country country1 = Country.builder().name("Страна 1").build();
        entityManager.persist(country1);

        Country country2 = Country.builder().name("Страна 2").build();
        entityManager.persist(country2);

        List<Country> countries = countryRepository.findAll();;

        assertTrue(countries.contains(country1));
        assertTrue(countries.contains(country2));
        assertEquals(2, countries.size());
    }

    @Test
    @DisplayName("getCountrieById() is working")
    public void getCountrieById() {
        Country country1 = Country.builder().name("Страна 1").build();
        entityManager.persist(country1);

        Integer id = country1.getId();
        assertEquals(id, countryRepository.getById(id).getId());
    }

}