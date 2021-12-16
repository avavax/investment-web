package com.investment.services;

import com.investment.models.Paper;
import com.investment.models.Position;

import java.util.List;

/**
 * Интерфейс сервиса для работы с позициями портфеля (Position)
 * @author Илья Петров
 * @version 1.0
 */
public interface PositionService {

    /**
     * Метод для получения позиции
     * @param paperList список ценных бумаг
     * @param <T> тип ценных бумаг (акции или облигации)
     * @return список позиций
     */
    <T extends Paper> List<Position<T>> getListPosition(List<T> paperList);
}
