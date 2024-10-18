package com.unam.poo.services.CaracteristicaComodidad;

import com.unam.poo.models.FeatureComfort;

import java.util.List;

public interface CaracteristicaComodidadService {

    List<FeatureComfort> findAll();
    void deleteCaracteristicaComodidadById(Long id);
    FeatureComfort getCaracteristicaComodidadById(Long id);
    FeatureComfort saveCaracteristicaComodidad(FeatureComfort featureComfort);

}
