package com.investment.services;

import com.investment.models.User;

import java.util.List;
import java.util.Optional;

/**
 * Интерфейс сервиса для работы с пользователями (User)
 * @author Илья Петров
 * @version 1.0
 */
public interface UserService {

    /**
     * Метод для получения всех пользователей
     * @return список пользователей
     */
    List<User> getAllUsers();

    /**
     * Метод получения одного пользователя
     * @param id
     * @return пользователь
     */
    User getUserById(Integer id);

    /**
     * Метод сохранения пользователя в репозиторий
     * @param user пользователь
     */
    void save(User user);

    /**
     * Метод для условного удаления пользователя
     * @param id пользователя
     */
    void softDelete(Integer id);

    /**
     * Метод для получения пользователя по логину
     * @param email логин
     * @return Optional пользователь
     */
    Optional<User> getUserByLogin(String email);
}
