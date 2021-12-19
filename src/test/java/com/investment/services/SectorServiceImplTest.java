package com.investment.services;

import com.investment.models.Country;
import com.investment.models.Sector;
import com.investment.repositories.CountryRepository;
import com.investment.repositories.SectorRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DisplayName(value = "Sector Service is working when")
class SectorServiceImplTest {

    @Mock
    private SectorRepository sectorRepositoryMock;

    @InjectMocks
    private SectorServiceImpl sectorService;

    @Test
    @DisplayName("getAllSectors() is working")
    void getAllSectors() {
        List<Sector> sectors = new ArrayList<>();
        sectors.add(Sector.builder().title("Sector 1").build());
        sectors.add(Sector.builder().title("Sector 2").build());

        Mockito.when(sectorRepositoryMock.findAll(Sort.by("id"))).thenReturn(sectors);
        List<Sector> resultList = sectorService.getAllSectors();

        assertEquals(2, resultList.size());
        Mockito.verify(sectorRepositoryMock).findAll(Sort.by("id"));
    }

    @Test
    @DisplayName("getSectorById() is working")
    void getSectorById() {
        Sector sector = Sector.builder().title("Sector 1").build();
        Integer sectorId = sector.getId();

        Mockito.when(sectorRepositoryMock.findById(sectorId)).thenReturn(java.util.Optional.of(sector));


        Sector resultSector = sectorService.getSectorById(sectorId);
        assertEquals(resultSector, sector);
        Mockito.verify(sectorRepositoryMock).findById(sectorId);
    }
}