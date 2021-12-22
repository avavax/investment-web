package com.investment.services;

import java.util.List;
import java.util.Optional;

/**
 * Интерфейс сервиса для работы с ценными бумагами (Papers)
 * @author Илья Петров
 * @version 1.0
 * @param <F> тип данных формы для добавления/обновления
 * @param <P> тип ценной бумаги
 */
public interface PaperService<F, P> {
    /**
     * Метод для добавления ценной бумаги
     * @param form - форма с данными
     * @param userId - id владельца
     */
    void add(F form, Integer userId);

    /**
     * Метод для обновления данных о бумаге
     * @param form - форма с данными
     * @param paper - бумага
     */
    void update(F form, P paper);

    /**
     * Метод для удаления ценной бумаги
     * @param id
     */
    void delete(Integer id);

    /**
     * Метод для получения ценной бумаги по id
     * @param id
     * @return бумага
     */
    P getById(Integer id);

    /**
     * Метод получения всех ценных бумаг, принадлежащих пользователю
     * @param userId - id пользователя
     * @return список ценных бумаг
     */
    List<P> findAllByUserId(Integer userId);
}
