package com.investment.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName(value = "Model Country is working when")
class CountryTest {

    private Country testCountry;
    private Country emptyCountry;

    @BeforeEach
    void setUp() {
        testCountry = Country.builder()
                .id(1)
                .name("Россия")
                .build();
        emptyCountry = new Country();
    }

    @Test
    @DisplayName("getId() is working")
    void getId() {
        assertEquals(1, testCountry.getId());
    }

    @Test
    @DisplayName("getName() is working")
    void getName() {
        assertEquals("Россия", testCountry.getName());
    }

    @Test
    @DisplayName("setName() is working")
    void setName() {
        emptyCountry.setName("USA");
        assertEquals("USA", emptyCountry.getName());
    }
}