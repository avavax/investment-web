package com.investment.services;

import com.investment.models.Sector;

import java.util.List;

public interface SectorService {
    List<Sector> getAllSectors();
    Sector getSectorById(Integer id);
}
