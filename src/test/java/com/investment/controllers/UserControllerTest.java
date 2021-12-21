package com.investment.controllers;

import com.investment.services.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@DisplayName("User Controller is working when")
class UserControllerTest {

    @Autowired
    private UserController userController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userServiceMock;

    @Test
    @DisplayName("getLoginForm() is working")
    public void getLoginForm() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/login"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/jsp/login.jsp"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("getRegisterForm() is working")
    public void getRegisterForm() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/register"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/jsp/register.jsp"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("register() is working")
    public void register() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/register"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/register"))
                .andExpect(status().is(302));
    }
}