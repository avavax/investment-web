package com.investment.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName(value = "Model PositionT is working when")
class PositionTest {

    private Stock testStock;
    private Position<Stock> testPosition;
    private Position<Stock> emptyPosition;

    @BeforeEach
    void setUp() {
        testStock = Stock.builder().id(1).build();
        testPosition = Position.<Stock>builder()
                .paper(testStock)
                .currentPrice(100.0)
                .diffCost(200.0)
                .value(300.0)
                .diffPercent(10.0)
                .share(15.0)
                .build();
        emptyPosition = new Position<>();
    }

    @Test
    @DisplayName("getPaper() is working")
    void getPaper() {
        assertEquals(testStock, testPosition.getPaper());
    }

    @Test
    @DisplayName("getPaper() is working")
    void getCurrentPrice() {
        assertEquals(testStock, testPosition.getPaper());
    }

    @Test
    @DisplayName("getValue() is working")
    void getValue() {
        assertEquals(300.0, testPosition.getValue());
    }

    @Test
    @DisplayName("getDiffCost() is working")
    void getDiffCost() {
        assertEquals(200.0, testPosition.getDiffCost());
    }

    @Test
    @DisplayName("getDiffPercent() is working")
    void getDiffPercent() {
        assertEquals(10.0, testPosition.getDiffPercent());
    }

    @Test
    @DisplayName("getShare() is working")
    void getShare() {
        assertEquals(15.0, testPosition.getShare());
    }

    @Test
    @DisplayName("setPaper() is working")
    void setPaper() {
        emptyPosition.setPaper(testStock);
        assertEquals(testStock, emptyPosition.getPaper());
    }

    @Test
    @DisplayName("setCurrentPrice() is working")
    void setCurrentPrice() {
        emptyPosition.setCurrentPrice(5000.0);
        assertEquals(5000.0, emptyPosition.getCurrentPrice());
    }

    @Test
    @DisplayName("setValue() is working")
    void setValue() {
        emptyPosition.setValue(300.0);
        assertEquals(300.0, emptyPosition.getValue());
    }

    @Test
    @DisplayName("setDiffCost() is working")
    void setDiffCost() {
        emptyPosition.setDiffCost(150.0);
        assertEquals(150.0, emptyPosition.getDiffCost());
    }

    @Test
    @DisplayName("setDiffPercent() is working")
    void setDiffPercent() {
        emptyPosition.setDiffPercent(17.0);
        assertEquals(17.0, emptyPosition.getDiffPercent());
    }

    @Test
    @DisplayName("setShare() is working")
    void setShare() {
        emptyPosition.setShare(7.0);
        assertEquals(7.0, emptyPosition.getShare());
    }
}