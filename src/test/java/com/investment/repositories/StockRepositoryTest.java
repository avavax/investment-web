package com.investment.repositories;

import com.investment.models.Bond;
import com.investment.models.Stock;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
@DisplayName(value = "Stock Repository is working when")
class StockRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private StockRepository stockRepository;

    private Stock stock1;
    private Stock stock2;
    private Stock stock3;

    @BeforeEach
    void setUp() {
        stock1 = Stock.builder().userId(1).build();
        stock2 = Stock.builder().userId(1).build();
        stock3 = Stock.builder().userId(3).build();
        entityManager.persist(stock1);
        entityManager.persist(stock2);
        entityManager.persist(stock3);
    }

    @Test
    @DisplayName("findAllByUserId() is working")
    void findAllByUserId() {
        List<Stock> stocks = stockRepository.findAllByUserId(1);
        assertTrue(stocks.contains(stock1));
        assertTrue(stocks.contains(stock2));
        assertFalse(stocks.contains(stock3));
        assertEquals(2, stocks.size());
    }

    @Test
    @DisplayName("findAll() is working")
    void findAll() {
        List<Stock> stocks = stockRepository.findAll();
        assertTrue(stocks.contains(stock1));
        assertTrue(stocks.contains(stock2));
        assertTrue(stocks.contains(stock3));
        assertEquals(3, stocks.size());
    }
}

