package com.unam.poo.services.Pais;

import java.util.List;

import com.unam.poo.models.Country;

public interface PaisService {
    List<Country> findAll();
    void deletePaisById(Long id);
    Country getPaisById(Long id);
    Country savePais(Country country);
}
