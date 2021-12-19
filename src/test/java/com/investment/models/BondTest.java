package com.investment.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName(value = "Model Bond is working when")
class BondTest {

    private Bond testBond;
    private Bond emptyBond;
    private Country country;

    @BeforeEach
    void setUp() {
        country = Country.builder().name("Россия").build();
        testBond = Bond.builder()
                .userId(5)
                .company("Company 1")
                .country(country)
                .count(100)
                .cupon(7.3)
                .maturity(LocalDate.parse("2022-01-30"))
                .symbol("SU26230RMFS1")
                .price(1005.0)
                .yield(8.2)
                .title("ОФЗ 25620")
                .id(1)
                .build();
        emptyBond = new Bond();
    }

    @Test
    @DisplayName("getId() is working")
    void getId() {
        assertEquals(1, testBond.getId());
    }

    @Test
    @DisplayName("getCompany() is working")
    void getCompany() {
        assertEquals("Company 1", testBond.getCompany());
    }

    @Test
    @DisplayName("getTitle() is working")
    void getTitle() {
        assertEquals("ОФЗ 25620", testBond.getTitle());
    }

    @Test
    @DisplayName("getCupon() is working")
    void getCupon() {
        assertEquals(7.3, testBond.getCupon());
    }

    @Test
    @DisplayName("getYield() is working")
    void getYield() {
        assertEquals(8.2, testBond.getYield());
    }

    @Test
    @DisplayName("getMaturity() is working")
    void getMaturity() {
        assertEquals(LocalDate.parse("2022-01-30"), testBond.getMaturity());
    }

    @Test
    @DisplayName("getUserId() is working")
    void getUserId() {
        assertEquals(5, testBond.getUserId());
    }

    @Test
    @DisplayName("getCountry() is working")
    void getCountry() {
        assertEquals(country, testBond.getCountry());
    }

    @Test
    @DisplayName("setSymbol() is working")
    void setSymbol() {
        emptyBond.setSymbol("SU26230RMFS1");
        assertEquals("SU26230RMFS1", emptyBond.getSymbol());
    }

    @Test
    @DisplayName("setCompany() is working")
    void setCompany() {
        emptyBond.setCompany("Company 1");
        assertEquals("Company 1", emptyBond.getCompany());
    }

    @Test
    @DisplayName("setTitle() is working")
    void setTitle() {
        emptyBond.setTitle("ОФЗ 25265");
        assertEquals("ОФЗ 25265", emptyBond.getTitle());
    }

    @Test
    @DisplayName("setCount() is working")
    void setCount() {
        emptyBond.setCount(100);
        assertEquals(100, emptyBond.getCount());
    }

    @Test
    @DisplayName("setPrice() is working")
    void setPrice() {
        emptyBond.setPrice(1005.0);
        assertEquals(1005.0, emptyBond.getPrice());
    }

    @Test
    @DisplayName("setCupon() is working")
    void setCupon() {
        emptyBond.setCupon(5.6);
        assertEquals(5.6, emptyBond.getCupon());
    }

    @Test
    @DisplayName("setYield() is working")
    void setYield() {
        emptyBond.setYield(7.5);
        assertEquals(7.5, emptyBond.getYield());
    }

    @Test
    @DisplayName("setMaturity() is working")
    void setMaturity() {
        emptyBond.setMaturity(LocalDate.parse("2022-01-30"));
        assertEquals(LocalDate.parse("2022-01-30"), emptyBond.getMaturity());
    }

    @Test
    @DisplayName("setUserId() is working")
    void setUserId() {
        emptyBond.setUserId(5);
        assertEquals(5, emptyBond.getUserId());
    }

    @Test
    @DisplayName("setCountry() is working")
    void setCountry() {
        emptyBond.setCountry(country);
        assertEquals(country, emptyBond.getCountry());
    }
}