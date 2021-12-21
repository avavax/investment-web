package com.investment.services;

import com.investment.forms.BondForm;
import com.investment.models.Bond;
import com.investment.repositories.BondRepository;
import com.investment.repositories.CountryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DisplayName(value = "Bond Service is working when")
class BondServiceImplTest {

    @Mock
    private BondRepository bondRepositoryMock;

    @Mock
    private CountryService countryServiceMock;

    @InjectMocks
    private BondServiceImpl bondService;

    @Test
    @DisplayName("add() is working")
    void add() {
        Bond bond = Bond.builder().userId(1).build();
        bondService.add(new BondForm(), 1);
        Mockito.verify(bondRepositoryMock).save(bond);
    }

    @Test
    @DisplayName("update() is working")
    void update() {
        Bond bond = Bond.builder().count(100).build();
        BondForm bondForm = new BondForm();
        bondForm.setCount(200);
        bondService.update(bondForm, bond);
        Mockito.verify(bondRepositoryMock).save(bond);
    }

    @Test
    @DisplayName("delete() is working")
    void delete() {
        bondService.delete(1);
        Mockito.verify(bondRepositoryMock).deleteById(1);
    }

    @Test
    @DisplayName("getById() is working")
    void getById() {
        Integer id = 1;
        Bond bond = Bond.builder().id(id).build();
        Mockito.when(bondRepositoryMock.findById(id)).thenReturn(java.util.Optional.of(bond));
        Bond resultBond = bondService.getById(id);
        assertEquals(bond, resultBond);
        Mockito.verify(bondRepositoryMock).findById(id);
    }

    @Test
    @DisplayName("findAllByUserId() is working")
    void findAllByUserId() {
        List<Bond> bonds = new ArrayList<>();
        Bond bond1 = Bond.builder().id(1).userId(1).build();
        Bond bond2 = Bond.builder().id(2).userId(1).build();
        bonds.add(bond1);
        bonds.add(bond2);

        Mockito.when(bondRepositoryMock.findAllByUserId(1)).thenReturn(bonds);

        List<Bond> result = bondService.findAllByUserId(1);
        assertEquals(2, result.size());
        assertTrue(result.contains(bond1));
        assertTrue(result.contains(bond2));
        Mockito.verify(bondRepositoryMock).findAllByUserId(1);
    }
}
