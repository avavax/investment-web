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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.List;

@Controller
public class PortfolioController {

    private UserService userService;
    private PositionService positionService;
    private StockService stockService;
    private BondService bondService;
    private UserSecurity userSecurity;

    @Autowired
    public PortfolioController(UserService userService,
                               PositionService positionService,
                               StockService stockService,
                               BondService bondService,
                               UserSecurity userSecurity) {
        this.userService = userService;
        this.positionService = positionService;
        this.stockService = stockService;
        this.bondService = bondService;
        this.userSecurity = userSecurity;
    }

    @GetMapping("/")
    public String getAllPortfolio(Model model, Principal principal) {
        List<User> users = userService.getAllUsers();
        if (userSecurity.isPrincipalAdmin(principal)) {
            model.addAttribute("isAdmin", true);
        }
        model.addAttribute("usersFromServer", users);
        model.addAttribute("currentPage", "main");
        return "index";
    }

    @GetMapping("/portfolio")
    public String getMyPortfolio(Principal principal) {
        User user = userService.getUserByLogin(principal.getName()).orElse(null);
        if (user == null) {
            return "login";
        }
        return "redirect:/portfolio/" + user.getId();
    }

    @GetMapping("/portfolio/{user-id}")
    public String getPortfolioByUserId(Model model,
                        @PathVariable("user-id") Integer userId,
                        Principal principal) {
        User user = userService.getUserById(userId);
        if (user == null) {
            return "404";
        }
        if (userSecurity.hasAdminOrOwner(principal, user)) {
            model.addAttribute("isAdminOrOwner", true);
            model.addAttribute("currentPage", "myPortfolio");
        }
        List<Stock> stocks = stockService.findAllByUserId(userId);
        List<Bond> bonds = bondService.findAllByUserId(userId);
        List<Position<Stock>> stockPositions = positionService.getListPosition(stocks);
        List<Position<Bond>> bondPositions = positionService.getListPosition(bonds);
        model.addAttribute("userFromServer", user);
        model.addAttribute("stocksPositionsFromServer", stockPositions);
        model.addAttribute("bondsPositionsFromServer", bondPositions);
        return "portfolio";
    }
}
