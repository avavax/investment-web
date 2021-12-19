package com.investment.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
    @GetMapping("/error/404")
    public String get404Page() {
        return "404";
    }

    @GetMapping("/error/500")
    public String get500Page() {
        return "500";
    }
}

