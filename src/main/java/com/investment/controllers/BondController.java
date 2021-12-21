package com.investment.controllers;

import com.investment.exceptions.PageNotFoundException;
import com.investment.forms.BondForm;
import com.investment.forms.StockForm;
import com.investment.models.*;
import com.investment.security.services.UserSecurity;
import com.investment.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
public class BondController {
    private BondService bondService;
    private SectorService sectorService;
    private CountryService countryService;
    private UserService userService;
    private UserSecurity userSecurity;

    @Autowired
    public BondController(BondService bondService,
                           SectorService sectorService,
                           CountryService countryService,
                           UserService userService,
                           UserSecurity userSecurity) {
        this.bondService = bondService;
        this.sectorService = sectorService;
        this.countryService = countryService;
        this.userService = userService;
        this.userSecurity = userSecurity;
    }

    @GetMapping("/bonds/{user-id}/{bond-id}")
    public String getEditFormBond(Model model,
                                  @PathVariable("user-id") Integer userId,
                                  @PathVariable("bond-id") Integer bondId,
                                  Principal principal) {
        if (!userSecurity.hasAdminOrOwner(principal, userId)) {
            return "login";
        }
        Bond bond = bondService.getById(bondId);

        List<Country> countries = countryService.getAllCountries();
        List<Sector> sectors = sectorService.getAllSectors();
        model.addAttribute("bondFromServer", bond);
        model.addAttribute("countriesFromServer", countries);
        model.addAttribute("sectorsFromServer", sectors);
        return "bond";
    }

    @PostMapping("/bonds/{user-id}/{bond-id}")
    public String update(@Valid BondForm bondForm,
                         BindingResult result,
                         RedirectAttributes forRedirectModel,
                         @PathVariable("user-id") Integer userId,
                         @PathVariable("bond-id") Integer bondId,
                         Principal principal) {
        if (!userSecurity.hasAdminOrOwner(principal, userId)) {
            return "login";
        }
        Bond bond = bondService.getById(bondId);

        if (result.hasErrors()) {
            forRedirectModel.addFlashAttribute("errors", "Есть ошибки на форме!");
            return "redirect:/bonds/" + userId + "/" + bondId;
        }

        bondService.update(bondForm, bond);
        return "redirect:/portfolio/" + userId;
    }

    @GetMapping("/bonds/{user-id}")
    public String getAddFormBond(Model model,
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
        return "bond";
    }

    @PostMapping("/bonds/{user-id}")
    public String add(@Valid BondForm bondForm,
                         BindingResult result,
                         RedirectAttributes forRedirectModel,
                         @PathVariable("user-id") Integer userId,
                         Principal principal) {
        if (!userSecurity.hasAdminOrOwner(principal, userId)) {
            return "login";
        }

        if (result.hasErrors()) {
            forRedirectModel.addFlashAttribute("errors", "Есть ошибки на форме!");
            return "redirect:/bonds/" + userId;
        }
        bondService.add(bondForm, userId);
        return "redirect:/portfolio/" + userId;
    }

    @GetMapping("/bonds/{user-id}/{bond-id}/delete")
    public String delete (@PathVariable("user-id") Integer userId,
                          @PathVariable("bond-id") Integer bondId,
                          Principal principal) {
        if (!userSecurity.hasAdminOrOwner(principal, userId)) {
            return "login";
        }
        bondService.delete(bondId);
        return "redirect:/portfolio/" + userId;
    }
}
