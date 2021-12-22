package com.investment.services;

import com.investment.forms.StockForm;
import com.investment.models.Stock;
import com.investment.models.User;

/**
 * Интерфейс сервиса для работы с акциями (Stock)
 * Наследует интерфейс сервиса для работы с ценными бумагами (Paper)
 * @author Илья Петров
 * @version 1.0
 */
public interface StockService extends PaperService<StockForm, Stock> {
}
