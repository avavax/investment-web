package com.investment.services;

import com.investment.models.Sector;

import java.util.List;

/**
 * Интерфейс сервиса для работы с отраслями (Sector)
 * @author Илья Петров
 * @version 1.0
 */
public interface SectorService {
    /**
     * Метод для получения всех отраслей
     * @return список стран
     */
    List<Sector> getAllSectors();

    /**
     * Метод для получения одной отрасли
     * @param id отрасли
     * @return отрасль
     */
    Sector getSectorById(Integer id);
}
