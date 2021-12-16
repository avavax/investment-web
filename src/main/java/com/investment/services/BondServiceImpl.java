package com.investment.services;

import com.investment.exceptions.PageNotFoundException;
import com.investment.forms.BondForm;
import com.investment.models.Bond;
import com.investment.models.Country;
import com.investment.repositories.BondRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Класс сервиса для работы с облигациями (Bond)
 * @author Илья Петров
 * @version 1.0
 */
@Component
public class BondServiceImpl implements BondService {

    private BondRepository bondRepository;
    private CountryService countryService;

    /**
     * Конструктор объекта
     * @param bondRepository - репозиторий облигаций
     * @param countryService - сервис для работы со странами
     */
    @Autowired
    public BondServiceImpl(BondRepository bondRepository, CountryService countryService) {
        this.bondRepository = bondRepository;
        this.countryService = countryService;
    }

    /**
     * Метод добавления облигации
     * @param bondForm форма ввода данных об облигации
     * @param userId id пользователя-владельца
     */
    @Override
    public void add(BondForm bondForm, Integer userId) {
        Country country = countryService.getCountryById(bondForm.getCountry());
        Bond bond = Bond.builder()
                .userId(userId)
                .count(bondForm.getCount())
                .price(bondForm.getPrice())
                .company(bondForm.getCompany())
                .symbol(bondForm.getSymbol())
                .title(bondForm.getTitle())
                .cupon(bondForm.getCupon())
                .yield(bondForm.getYield())
                .maturity(bondForm.getMaturity())
                .country(country)
                .build();
        bondRepository.save(bond);
    }

    /**
     * Метод обновления облигации
     * @param bondForm форма ввода данных об облигации
     * @param bond текущая облигация, в которой обновляются данные
     */
    @Override
    public void update(BondForm bondForm, Bond bond) {
        Country country = countryService.getCountryById(bondForm.getCountry());

        bond.setCount(bondForm.getCount());
        bond.setPrice(bondForm.getPrice());
        bond.setCompany(bondForm.getCompany());
        bond.setSymbol(bondForm.getSymbol());
        bond.setCupon(bondForm.getCupon());
        bond.setMaturity(bondForm.getMaturity());
        bond.setTitle(bondForm.getTitle());
        bond.setYield(bondForm.getYield());
        bond.setCountry(country);

        bondRepository.save(bond);
    }

    /**
     * Метод удаления облигации
     * @param id облигации для удаления
     */
    @Override
    public void delete(Integer id) {
        bondRepository.deleteById(id);
    }

    /**
     * Методо получения облигации по id
     * @param id облигации, которую запрашивают
     * @return возвращаем облигацию или выбрасываем 404-ошибку
     */
    @Override
    public Bond getById(Integer id) {
        return bondRepository.findById(id).orElseThrow(PageNotFoundException::new);
    }

    /**
     * Метод получения списка облигаций данного пользователя
     * @param userId пользователь, все облигации которого запрашивают
     * @return список облигация данного пользователя
     */
    @Override
    public List<Bond> findAllByUserId(Integer userId) {
        return bondRepository.findAllByUserId(userId);
    }
}
