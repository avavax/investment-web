package com.investment.services;

import com.investment.exceptions.PageNotFoundException;
import com.investment.models.Sector;
import com.investment.repositories.SectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SectorServiceImpl implements SectorService {

    @Autowired
    private SectorRepository sectorRepository;

    @Override
    public List<Sector> getAllSectors() {
        return sectorRepository.findAll(Sort.by("id"));
    }

    @Override
    public Sector getSectorById(Integer id) {
        return sectorRepository.findById(id).orElseThrow(PageNotFoundException::new);
    }
}
