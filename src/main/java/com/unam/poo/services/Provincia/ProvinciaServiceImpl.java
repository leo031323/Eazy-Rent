package com.unam.poo.services.Provincia;

import com.unam.poo.models.Province;
import com.unam.poo.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinciaServiceImpl implements ProvinciaService {

    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public List<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public void deleteProvinciaById(Long id) {

    }

    @Override
    public Province getProvinciaById(Long id) {
        return provinceRepository.findById(id).get();
    }

    @Override
    public Province saveProvincia(Province province) {
        return provinceRepository.save(province);
    }
}

