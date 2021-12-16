package com.investment.services;

import com.investment.exceptions.PageNotFoundException;
import com.investment.models.Sector;
import com.investment.repositories.SectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Класс сервиса для работы с отраслями (Sector)
 * @author Илья Петров
 * @version 1.0
 */
@Component
public class SectorServiceImpl implements SectorService {

    /** Поле репозитория отраслей */
    @Autowired
    private SectorRepository sectorRepository;

    /**
     * Метод получения списка всех отраслей
     * @return список отраслей
     */
    @Override
    public List<Sector> getAllSectors() {
        return sectorRepository.findAll(Sort.by("id"));
    }

    /**
     * Метод получения отрасли по её id
     * @param id отрасли
     * @return возвращает объект Sector или выбрасывает 404 ошибку
     */
    @Override
    public Sector getSectorById(Integer id) {
        return sectorRepository.findById(id).orElseThrow(PageNotFoundException::new);
    }
}
