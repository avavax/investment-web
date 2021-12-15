package com.investment.services;

import com.investment.exceptions.PageNotFoundException;
import com.investment.models.User;
import com.investment.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAllVisible();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(PageNotFoundException::new);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> getUserByLogin(String email) {
        return userRepository.findOneByLogin(email);
    }

    @Override
    public void softDelete(Integer id) {
        userRepository.softDelete(id);
    }
}
