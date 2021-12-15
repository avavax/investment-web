package com.investment.services;

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

@Component
public class StockServiceImpl implements StockService {

    private StockRepository stockRepository;
    private CountryService countryService;
    private SectorService sectorService;

    @Autowired
    public StockServiceImpl(StockRepository stockRepository, CountryService countryService, SectorService sectorService) {
        this.stockRepository = stockRepository;
        this.countryService = countryService;
        this.sectorService = sectorService;
    }

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

    @Override
    public void delete(Integer id) {
        stockRepository.deleteById(id);
    }

    @Override
    public Stock getById(Integer id) {
        return stockRepository.findById(id).orElseThrow(PageNotFoundException::new);
    }

    @Override
    public List<Stock> findAllByUserId(Integer userId) {
        return stockRepository.findAllByUserId(userId);
    }
}
