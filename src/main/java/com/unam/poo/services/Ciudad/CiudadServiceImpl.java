package com.unam.poo.services.Ciudad;

import com.unam.poo.models.City;
import com.unam.poo.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CiudadServiceImpl implements CiudadService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public void deleteCiudadById(Long id) {

    }

    @Override
    public City getCiudadById(Long id) {
        return cityRepository.findById(id).get();
    }

    @Override
    public City saveCiudad(City city) {
        return cityRepository.save(city);
    }
}

