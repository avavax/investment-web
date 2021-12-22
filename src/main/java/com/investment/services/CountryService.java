package com.investment.services;

import com.investment.models.Country;

import java.util.List;

/**
 * Интерфейс сервиса для работы со странами (Country)
 * @author Илья Петров
 * @version 1.0
 */
public interface CountryService {
    /**
     * Метод для получения всех стран
     * @return список стран
     */
    List<Country> getAllCountries();

    /**
     * Метод для получения одной страны
     * @param id страны
     * @return страна
     */
    Country getCountryById(Integer id);
}
