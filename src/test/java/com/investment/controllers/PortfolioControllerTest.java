package com.investment.controllers;

import com.investment.security.services.UserSecurity;
import com.investment.services.BondService;
import com.investment.services.PositionService;
import com.investment.services.StockService;
import com.investment.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(PortfolioController.class)
class PortfolioControllerTest {

    @Autowired
    private PortfolioController portfolioController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private PositionService positionService;

    @MockBean
    private StockService stockService;

    @MockBean
    private BondService bondService;

    @MockBean
    private UserSecurity userSecurity;

    @Test
    public void getPortfolioByUserIdTest() throws Exception {

    }
}