package com.investment.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticPageController {

    @GetMapping("/about")
    public String getAbout(Model model) {
        model.addAttribute("currentPage", "about");
        return "about";
    }
}
