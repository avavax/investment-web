package com.investment.controllers;

import com.investment.exceptions.PageNotFoundException;
import com.investment.forms.StockForm;
import com.investment.models.Country;
import com.investment.models.Sector;
import com.investment.models.Stock;
import com.investment.models.User;
import com.investment.security.services.UserSecurity;
import com.investment.services.CountryService;
import com.investment.services.SectorService;
import com.investment.services.StockService;
import com.investment.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
public class StockController {

    private StockService stockService;
    private SectorService sectorService;
    private CountryService countryService;
    private UserService userService;
    private UserSecurity userSecurity;

    @Autowired
    public StockController(StockService stockService,
                           SectorService sectorService,
                           CountryService countryService,
                           UserService userService,
                           UserSecurity userSecurity
    ) {
        this.stockService = stockService;
        this.sectorService = sectorService;
        this.countryService = countryService;
        this.userService = userService;
        this.userSecurity = userSecurity;
    }

    @GetMapping("/stocks/{user-id}/{stock-id}")
    public String getEditFormStock(Model model,
                                   @PathVariable("user-id") Integer userId,
                                   @PathVariable("stock-id") Integer stockId,
                                   Principal principal) {
        if (!userSecurity.hasAdminOrOwner(principal, userId)) {
            return "login";
        }

        Stock stock = stockService.getById(stockId);

        List<Country> countries = countryService.getAllCountries();
        List<Sector> sectors = sectorService.getAllSectors();
        model.addAttribute("stockFromServer", stock);
        model.addAttribute("countriesFromServer", countries);
        model.addAttribute("sectorsFromServer", sectors);
        return "stock";
    }

    @PostMapping("/stocks/{user-id}/{stock-id}")
    public String update(@Valid StockForm stockForm,
                         BindingResult result,
                         RedirectAttributes forRedirectModel,
                         @PathVariable("user-id") Integer userId,
                         @PathVariable("stock-id") Integer stockId,
                         Principal principal) {
        if (!userSecurity.hasAdminOrOwner(principal, userId)) {
            return "login";
        }

        Stock stock = stockService.getById(stockId);

        if (result.hasErrors()) {
            forRedirectModel.addFlashAttribute("errors", "Есть ошибки на форме!");
            return "redirect:/stocks/" + userId + "/" + stockId;
        }

        stockService.update(stockForm, stock);
        return "redirect:/portfolio/" + userId;
    }

    @GetMapping("/stocks/{user-id}")
    public String getAddFormStock(Model model,
                                  @PathVariable("user-id") Integer userId,
                                  Principal principal) {
        if (!userSecurity.hasAdminOrOwner(principal, userId)) {
            return "login";
        }
        User user = userService.getUserById(userId);

        List<Country> countries = countryService.getAllCountries();
        List<Sector> sectors = sectorService.getAllSectors();
        model.addAttribute("userFromServer", user);
        model.addAttribute("countriesFromServer", countries);
        model.addAttribute("sectorsFromServer", sectors);
        return "stock";
    }

    @PostMapping("/stocks/{user-id}")
    public String update(@Valid StockForm stockForm,
                         BindingResult result,
                         RedirectAttributes forRedirectModel,
                         @PathVariable("user-id") Integer userId,
                         Principal principal) {
        if (!userSecurity.hasAdminOrOwner(principal, userId)) {
            return "login";
        }
        if (result.hasErrors()) {
            forRedirectModel.addFlashAttribute("errors", "Есть ошибки на форме!");
            return "redirect:/stocks/" + userId;
        }
        stockService.add(stockForm, userId);
        return "redirect:/portfolio/" + userId;
    }

    @GetMapping("/stocks/{user-id}/{stock-id}/delete")
    public String delete (@PathVariable("user-id") Integer userId,
                   @PathVariable("stock-id") Integer stockId,
                   Principal principal) {
        if (!userSecurity.hasAdminOrOwner(principal, userId)) {
            return "login";
        }
        stockService.delete(stockId);
        return "redirect:/portfolio/" + userId;
    }
}
