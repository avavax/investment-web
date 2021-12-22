package com.investment.security.services;

import com.investment.models.User;
import com.investment.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.Principal;

@Component
public class UserSecurity {

    @Autowired
    private UserService userService;

    public boolean hasAdminOrOwner(Principal principal, User user) {
        if (user == null || principal == null) {
            return false;
        }
        return isPrincipalAdmin(principal) || user.getEmail().equals(principal.getName());
    }

    public boolean hasAdminOrOwner(Principal principal, Integer userId) {
        User user = userService.getUserById(userId);
        return hasAdminOrOwner(principal, user);
    }

    public boolean isPrincipalAdmin(Principal principal) {
        if (principal == null) {
            return false;
        }
        String email = principal.getName();
        User user = userService.getUserByLogin(email).orElse(null);
        return user != null && user.getRole().equals(User.Role.ADMIN);
    }

    /*public boolean hasAdminOrOwner(User authUser, Integer currentUserId) {
        if (authUser == null || currentUserId == null) {
            return false;
        }
        if (authUser.getRole().equals(User.Role.ADMIN) || authUser.getId().equals(currentUserId)) {
            return true;
        }
        return false;
    }*/
}

