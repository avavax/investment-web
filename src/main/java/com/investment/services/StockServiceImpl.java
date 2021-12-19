package com.investment.services;

import com.investment.exceptions.DatabaseQueryError;
import com.investment.exceptions.PageNotFoundException;
import com.investment.forms.StockForm;
import com.investment.models.Country;
import com.investment.models.Sector;
import com.investment.models.Stock;
import com.investment.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Класс сервиса для работы с акциями (Stock)
 * @author Илья Петров
 * @version 1.0
 */
@Component
public class StockServiceImpl implements StockService {

    private StockRepository stockRepository;
    private CountryService countryService;
    private SectorService sectorService;

    /**
     * Конструктор объекта
     * @param stockRepository - репозиторий акций
     * @param sectorService - репозиторий отраслей
     * @param countryService - сервис для работы со странами
     */
    @Autowired
    public StockServiceImpl(StockRepository stockRepository, CountryService countryService, SectorService sectorService) {
        this.stockRepository = stockRepository;
        this.countryService = countryService;
        this.sectorService = sectorService;
    }

    /**
     * Метод добавления акции
     * @param stockForm форма ввода данных об акции
     * @param userId id пользователя-владельца
     */
    @Override
    public void add(StockForm stockForm, Integer userId) {
        Country country = countryService.getCountryById(stockForm.getCountry());
        Sector sector = sectorService.getSectorById(stockForm.getSector());
        Stock stock = Stock.builder()
                .userId(userId)
                .count(stockForm.getCount())
                .price(stockForm.getPrice())
                .company(stockForm.getCompany())
                .symbol(stockForm.getSymbol())
                .country(country)
                .sector(sector)
                .build();
        stockRepository.save(stock);
    }

    /**
     * Метод обновления акции
     * @param stockForm форма ввода данных об акции
     * @param stock текущая акция, в которой обновляются данные
     */
    @Override
    public void update(StockForm stockForm, Stock stock) {
        Country country = countryService.getCountryById(stockForm.getCountry());
        Sector sector = sectorService.getSectorById(stockForm.getSector());

        stock.setCount(stockForm.getCount());
        stock.setPrice(stockForm.getPrice());
        stock.setCompany(stockForm.getCompany());
        stock.setSymbol(stockForm.getSymbol());
        stock.setCountry(country);
        stock.setSector(sector);

        stockRepository.save(stock);
    }

    /**
     * Метод удаления акции
     * @param id акции для удаления
     */
    @Override
    public void delete(Integer id) {
        try {
            stockRepository.deleteById(id);
        } catch(RuntimeException e) {
            throw new DatabaseQueryError();
        }
    }

    /**
     * Методо получения акции по id
     * @param id акции, которую запрашивают
     * @return возвращаем акцию или выбрасываем 404-ошибку
     */
    @Override
    public Stock getById(Integer id) {
        return stockRepository.findById(id).orElseThrow(PageNotFoundException::new);
    }

    /**
     * Метод получения списка акций данного пользователя
     * @param userId пользователь, все акции которого запрашивают
     * @return список акций данного пользователя
     */
    @Override
    public List<Stock> findAllByUserId(Integer userId) {
        try {
            return stockRepository.findAllByUserId(userId);
        } catch(RuntimeException e) {
            throw new DatabaseQueryError();
        }
    }
}
