package com.unam.poo.services.Ciudad;

import com.unam.poo.models.City;

import java.util.List;

public interface CiudadService {
    List<City> findAll();
    void deleteCiudadById(Long id);
    City getCiudadById(Long id);
    City saveCiudad(City city);

}
