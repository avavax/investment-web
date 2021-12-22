package com.investment.repositories;

import com.investment.models.Country;
import com.investment.models.Sector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@RunWith(SpringRunner.class)
@DisplayName(value = "Sector Repository is working when")
class SectorRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private SectorRepository sectorRepository;

    @Test
    @DisplayName("getAllSectors() is working")
    public void getAllSectors() {
        Sector sector1 = Sector.builder().title("Sector 1").build();
        entityManager.persist(sector1);

        Sector sector2 = Sector.builder().title("Sector 1").build();
        entityManager.persist(sector2);

        List<Sector> sectors = sectorRepository.findAll();;

        assertTrue(sectors.contains(sector1));
        assertTrue(sectors.contains(sector2));
        assertEquals(2, sectors.size());
    }

    @Test
    @DisplayName("getSectorById() is working")
    public void getSectorById() {
        Sector sector1 = Sector.builder().title("Sector 1").build();
        entityManager.persist(sector1);

        Integer id = sector1.getId();
        assertEquals(id, sectorRepository.getById(id).getId());
    }
}