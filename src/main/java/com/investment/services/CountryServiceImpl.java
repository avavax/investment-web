package com.investment.services;

import com.investment.exceptions.PageNotFoundException;
import com.investment.models.Country;
import com.investment.repositories.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Класс сервиса для работы со странами (Country)
 * @author Илья Петров
 * @version 1.0
 */
@Component
public class CountryServiceImpl implements CountryService {

    /** Поле репозитория стран */
    @Autowired
    private CountryRepository countryRepository;

    /**
     * Метод получения списка всех стран
     * @return список стран
     */
    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll(Sort.by("name"));
    }

    /**
     * Метод получения страны по её id
     * @param id страны
     * @return возвращает объект Country или выбрасывает 404 ошибку
     */
    @Override
    public Country getCountryById(Integer id) {
        return countryRepository.findById(id).orElseThrow(PageNotFoundException::new);
    }
}
