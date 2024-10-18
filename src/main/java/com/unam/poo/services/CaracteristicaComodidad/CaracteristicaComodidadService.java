package com.unam.poo.services.Characteristic  Comfort;

import com.unam.poo.models.FeatureComfort;

import java.util.List;

public interface Characteristic  ComfortService {

    List<FeatureComfort> findAll();
    void deleteCharacteristic  ComfortById(Long id);
    FeatureComfort getCharacteristic  ComfortById(Long id);
    FeatureComfort saveCharacteristic  Comfort(FeatureComfort featureComfort);

}
