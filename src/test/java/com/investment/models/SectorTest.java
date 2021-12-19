package com.investment.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName(value = "Model Sector is working when")
class SectorTest {

    private Sector sector;

    @BeforeEach
    void setUp() {
        sector = Sector.builder()
                .id(1)
                .title("Нефтегаз")
                .build();

        Sector emptySector = new Sector();
    }

    @Test
    @DisplayName("getId() is working")
    void getId() {
        assertEquals(sector.getId(), 1);
    }

    @Test
    @DisplayName("getTitle() is working")
    void getTitle() {
        assertEquals(sector.getTitle(), "Нефтегаз");
    }

    @Test
    @DisplayName("setTitle() is working")
    void setTitle() {
        sector.setTitle("Финансы");
        assertEquals(sector.getTitle(), "Финансы");
    }
}