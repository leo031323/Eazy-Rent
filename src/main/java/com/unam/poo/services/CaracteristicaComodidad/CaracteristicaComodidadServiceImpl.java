package com.unam.poo.services.CaracteristicaComodidad;

import com.unam.poo.models.FeatureComfort;
import com.unam.poo.repository.FeatureComfortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaracteristicaComodidadServiceImpl implements CaracteristicaComodidadService {

    @Autowired
    private FeatureComfortRepository featureComfortRepository;

    @Override
    public List<FeatureComfort> findAll() {
        return featureComfortRepository.findAll();
    }

    @Override
    public void deleteCaracteristicaComodidadById(Long id) {

    }

    @Override
    public FeatureComfort getCaracteristicaComodidadById(Long id) {
        return featureComfortRepository.findById(id).get();
    }

    @Override
    public FeatureComfort saveCaracteristicaComodidad(FeatureComfort featureComfort) {
        return null;
    }
}
