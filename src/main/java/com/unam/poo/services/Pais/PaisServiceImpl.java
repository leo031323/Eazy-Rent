package com.unam.poo.services.Pais;

import java.util.List;

import com.unam.poo.models.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unam.poo.repository.CountryRepository;

@Service
public class PaisServiceImpl implements PaisService{

    @Autowired
    CountryRepository countryRepository;

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public void deletePaisById(Long id) {
        countryRepository.deleteById(id);
    }

    @Override
    public Country getPaisById(Long id) {
        return countryRepository.findById(id).get();
    }

    @Override
    public Country savePais(Country country) {
        return countryRepository.save(country);
    } 
}
