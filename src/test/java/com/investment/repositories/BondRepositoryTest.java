package com.investment.repositories;

import com.investment.models.Bond;
import org.junit.jupiter.api.BeforeEach;
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
@DisplayName(value = "Bond Repository is working when")
class BondRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BondRepository bondRepository;

    private Bond bond1;
    private Bond bond2;
    private Bond bond3;

    @BeforeEach
    void setUp() {
        bond1 = Bond.builder().userId(1).build();
        entityManager.persist(bond1);

        bond2 = Bond.builder().userId(1).build();
        entityManager.persist(bond2);

        bond3 = Bond.builder().userId(2).build();
        entityManager.persist(bond3);
    }

    @Test
    @DisplayName("findAllByUserId() is working")
    void findAllByUserId() {
        List<Bond> bonds = bondRepository.findAllByUserId(1);
        assertTrue(bonds.contains(bond1));
        assertTrue(bonds.contains(bond2));
        assertFalse(bonds.contains(bond3));
        assertEquals(2, bonds.size());
    }

    @Test
    @DisplayName("findAll() is working")
    void findAll() {
        List<Bond> bonds = bondRepository.findAll();
        assertTrue(bonds.contains(bond1));
        assertTrue(bonds.contains(bond2));
        assertTrue(bonds.contains(bond3));
        assertEquals(3, bonds.size());
    }
}