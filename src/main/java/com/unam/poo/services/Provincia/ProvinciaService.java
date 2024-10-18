package com.unam.poo.services.Provincia;

import com.unam.poo.models.Province;

import java.util.List;

public interface ProvinciaService {
    List<Province> findAll();
    void deleteProvinciaById(Long id);
    Province getProvinciaById(Long id);
    Province saveProvincia(Province province);

}
