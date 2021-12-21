package com.investment.controllers;

import com.investment.models.Bond;
import com.investment.models.Position;
import com.investment.models.Stock;
import com.investment.models.User;
import com.investment.security.services.UserSecurity;
import com.investment.services.BondService;
import com.investment.services.PositionService;
import com.investment.services.StockService;
import com.investment.services.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PortfolioController.class)
@DisplayName("Portfolio Controller is working when")
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
    @DisplayName("getAllPortfolio() is working")
    public void getAllPortfolio() throws Exception {
        List<User> users = new ArrayList<>();
        users.add(User.builder().id(1).build());
        users.add(User.builder().id(2).build());
        Mockito.when(userService.getAllUsers()).thenReturn(users);

        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/jsp/index.jsp"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("usersFromServer"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("currentPage"))
                .andExpect(MockMvcResultMatchers.model().attribute("currentPage", "main"))
                .andExpect(MockMvcResultMatchers.model().attribute("usersFromServer", users))
                .andExpect(status().isOk());

        Mockito.verify(userService).getAllUsers();
    }

    @Test
    @DisplayName("getMyPortfolio() is working")
    public void getMyPortfolio() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/portfolio"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("http://localhost/login"))
                .andExpect(status().is(302));
    }

    @Test
    @DisplayName("getPortfolioByUserId() is working")
    public void getPortfolioByUserId() throws Exception {
        Integer userId = 1;
        User user = User.builder().id(userId).email("user@user.ru").build();
        Mockito.when(userService.getUserById(userId)).thenReturn(user);

        List<Stock> stocks = new ArrayList<>();
        Stock stock1 = Stock.builder().userId(userId).id(1).build();
        Stock stock2 = Stock.builder().userId(userId).id(2).build();
        stocks.add(stock1);
        stocks.add(stock2);
        Mockito.when(stockService.findAllByUserId(userId)).thenReturn(stocks);

        List<Bond> bonds = new ArrayList<>();
        Bond bond1 = Bond.builder().userId(userId).id(1).build();
        Bond bond2 = Bond.builder().userId(userId).id(2).build();
        bonds.add(bond1);
        bonds.add(bond2);
        Mockito.when(bondService.findAllByUserId(userId)).thenReturn(bonds);

        List<Position<Bond>> bondPositions = new ArrayList<>();
        Position<Bond> position1 = new Position();
        position1.setPaper(bond1);
        Position<Bond> position2 = new Position();
        position2.setPaper(bond2);
        bondPositions.add(position1);
        bondPositions.add(position2);
        Mockito.when(positionService.getListPosition(bonds)).thenReturn(bondPositions);

        List<Position<Stock>> stockPositions = new ArrayList<>();
        Position<Stock> position3 = new Position();
        position3.setPaper(stock1);
        Position<Stock> position4 = new Position();
        position4.setPaper(stock2);
        stockPositions.add(position3);
        stockPositions.add(position4);
        Mockito.when(positionService.getListPosition(stocks)).thenReturn(stockPositions);

        mockMvc.perform(MockMvcRequestBuilders.get("/portfolio/" + userId))
                .andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/jsp/portfolio.jsp"))
                .andExpect(MockMvcResultMatchers.model().attribute("userFromServer", user))
                .andExpect(MockMvcResultMatchers.model().attribute("stocksPositionsFromServer", stockPositions))
                .andExpect(MockMvcResultMatchers.model().attribute("bondsPositionsFromServer", bondPositions))
                .andExpect(status().isOk());

        Mockito.verify(positionService).getListPosition(stocks);
        Mockito.verify(positionService).getListPosition(bonds);
        Mockito.verify(bondService).findAllByUserId(userId);
        Mockito.verify(stockService).findAllByUserId(userId);
        Mockito.verify(userService).getUserById(userId);
    }

}