package com.investment.services;

import com.investment.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Integer id);
    void save(User user);
    public void softDelete(Integer id);
    Optional<User> getUserByLogin(String email);
}
