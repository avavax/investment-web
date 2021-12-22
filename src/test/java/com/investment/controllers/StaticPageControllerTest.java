package com.investment.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StaticPageController.class)
@DisplayName(value = "StaticPageController is working when")
class StaticPageControllerTest {

    @Autowired
    private StaticPageController staticPageController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("getAbout() is working")
    void getAbout() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/about"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/jsp/about.jsp"))
                .andExpect(status().isOk());;
    }
}