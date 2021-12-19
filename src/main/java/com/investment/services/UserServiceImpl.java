package com.investment.services;

import com.investment.exceptions.PageNotFoundException;
import com.investment.forms.UserForm;
import com.investment.models.User;
import com.investment.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Класс сервиса для работы с пользователями (User)
 * @author Илья Петров
 * @version 1.0
 */
@Component
public class UserServiceImpl implements UserService {

    /** Поле репозитория пользователей */
    @Autowired
    UserRepository userRepository;

    /** Поле энкодер для шифрования пароля */
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Метод получения всех пользователей
     * @return список пользвателей
     */
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAllVisible();
    }

    /**
     * Метод получение пользователя по id
     * @param id пользователя
     * @return пользвателя или выбрасывает 404-ошибку
     */
    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(PageNotFoundException::new);
    }

    /**
     * Метод сохраняет пользователя в БД
     * @param userForm форма с данными о пользователе
     */
    @Override
    public void save(UserForm userForm) {
        User user = User.builder()
                .name(userForm.getName())
                .email(userForm.getEmail())
                .password(passwordEncoder.encode(userForm.getPassword()))
                .role(User.Role.USER)
                .visible(1)
                .build();
        userRepository.save(user);
    }

    /**
     * Метод возвращает пользователя по mail (используется как логин)
     * @param email
     * @return Optional пользователь
     */
    @Override
    public Optional<User> getUserByLogin(String email) {
        return userRepository.findOneByLogin(email);
    }

    /**
     * Метод реализует удаление пользователя.
     * Данные остаются в системе, поле visible устанавливается в 0
     * @param id пользователя
     */
    @Override
    public void softDelete(Integer id) {
        try {
            userRepository.softDelete(id);
        } catch(RuntimeException e) {
            e.getStackTrace();
        }
    }
}
