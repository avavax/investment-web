package com.investment.controllers;

import com.investment.forms.LoginForm;
import com.investment.forms.UserForm;
import com.investment.models.User;
import com.investment.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {

    private UserService userService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public String getLoginForm(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String login(LoginForm loginForm) {
        return "/";
    }

    @GetMapping("/register")
    public String getRegisterForm(Model model) {
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserForm userForm,
                           BindingResult result,
                           RedirectAttributes forRedirectModel) {
        if (result.hasErrors()) {
            forRedirectModel.addFlashAttribute("errors", "Одно или несколько полей введены некорректной!");
            return "redirect:/register";
        }
        if (!userForm.getPassword().equals(userForm.getRepeatPassword())) {
            forRedirectModel.addFlashAttribute("errors", "Пароли должны совпадать!");
            return "redirect:/register";
        }
        User user = User.builder()
                .name(userForm.getName())
                .email(userForm.getEmail())
                .password(passwordEncoder.encode(userForm.getPassword()))
                .role(User.Role.USER)
                .visible(1)
                .build();
        userService.save(user);
        return "redirect:/login";
    }

    @GetMapping("/users/{user-id}/delete")
    public String getRegisterForm(@PathVariable("user-id") Integer userId) {
        User user = userService.getUserById(userId);
        if (user == null || user.getRole().equals(User.Role.ADMIN)) {
            return "redirect:/";
        }
        userService.softDelete(userId);
        return "redirect:/";
    }
}
