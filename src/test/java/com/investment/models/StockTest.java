package com.investment.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName(value = "Model Stock is working when")
class StockTest {

    private Stock testStock;
    private Stock emptyStock;
    private Country country;
    private Sector sector;

    @BeforeEach
    void setUp() {
        country = Country.builder()
                .id(1)
                .name("Россия")
                .build();

        sector = Sector.builder()
                .id(1)
                .title("Металлургия")
                .build();
        testStock = Stock.builder()
                .id(1)
                .symbol("NLMK")
                .company("НЛМК")
                .country(country)
                .sector(sector)
                .count(100)
                .price(3500.0)
                .userId(12)
                .build();

        emptyStock = new Stock();
    }

    @Test
    @DisplayName("getSymbol() is working")
    void getSymbol() {
        assertEquals(testStock.getSymbol(), "NLMK");
    }

    @Test
    @DisplayName("getCount() is working")
    void getCount() {
        assertEquals(testStock.getCount(), 100);
    }

    @Test
    @DisplayName("getPrice() is working")
    void getPrice() {
        assertEquals(testStock.getPrice(), 3500.0);
    }

    @Test
    @DisplayName("getId() is working")
    void getId() {
        assertEquals(testStock.getId(), 1);
    }

    @Test
    @DisplayName("getCompany() is working")
    void getCompany() {
        assertEquals(testStock.getCompany(), "НЛМК");
    }

    @Test
    @DisplayName("getUserId() is working")
    void getUserId() {
        assertEquals(testStock.getUserId(), 12);
    }

    @Test
    @DisplayName("getCountry() is working")
    void getCountry() {
        assertEquals(testStock.getCountry(), country);
    }

    @Test
    @DisplayName("getSector() is working")
    void getSector() {
        assertEquals(testStock.getSector(), sector);
    }

    @Test
    @DisplayName("setSymbol() is working")
    void setSymbol() {
        emptyStock.setSymbol("SBER");
        assertEquals(emptyStock.getSymbol(), "SBER");
    }

    @Test
    @DisplayName("setCompany() is working")
    void setCompany() {
        emptyStock.setCompany("Сбербанк");
        assertEquals(emptyStock.getCompany(), "Сбербанк");
    }

    @Test
    @DisplayName("setCount() is working")
    void setCount() {
        emptyStock.setCount(200);
        assertEquals(emptyStock.getCount(), 200);
    }

    @Test
    @DisplayName("getPrice() is working")
    void setPrice() {
        emptyStock.setPrice(7500.0);
        assertEquals(emptyStock.getPrice(), 7500.0);
    }

    @Test
    @DisplayName("setUserId() is working")
    void setUserId() {
        emptyStock.setUserId(5);
        assertEquals(emptyStock.getUserId(), 5);
    }

    @Test
    @DisplayName("setCountry() is working")
    void setCountry() {
        emptyStock.setCountry(country);
        assertEquals(emptyStock.getCountry(), country);
    }

    @Test
    @DisplayName("setSector() is working")
    void setSector() {
        emptyStock.setSector(sector);
        assertEquals(emptyStock.getSector(), sector);
    }
}