package com.unam.poo.services.CharacteristicComfort;

import com.unam.poo.models.FeatureComfort;
import com.unam.poo.repository.FeatureComfortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Characteristic ComfortServiceImpl implements Characteristic ComfortService {

    @Autowired
    private FeatureComfortRepository featureComfortRepository;

    @Override
    public List<FeatureComfort> findAll() {
        return featureComfortRepository.findAll();
    }

    @Override
    public void deleteCharacteristic ComfortById(Long id) {

    }

    @Override
    public FeatureComfort getCharacteristic ComfortById(Long id) {
        return featureComfortRepository.findById(id).get();
    }

    @Override
    public FeatureComfort saveCharacteristic Comfort(FeatureComfort featureComfort) {
        return null;
    }
}
