package com.investment.services;

/**
 * Интерфейс сервиса для получения текущей цены
 * @author Илья Петров
 * @version 1.0
 */
public interface PriceService {

    /**
     * Метод для получения текущей цены ценной бумаги
     * @param symbol - тикер акции или облигации
     * @return - цена в рублях
     */
    Double getPaperPrice(String symbol);
}
