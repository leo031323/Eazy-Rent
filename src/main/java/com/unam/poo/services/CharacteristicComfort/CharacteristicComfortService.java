package com.unam.poo.services.CharacteristicComfort;

import com.unam.poo.models.CharacteristicComfort;

import java.util.List;

public interface CharacteristicComfortService {

    List<CharacteristicComfort> findAll();
    void deleteCharacteristicComfortById(Long id);
    CharacteristicComfort getCharacteristicComfortById(Long id);
    CharacteristicComfort saveCharacteristicComfort(CharacteristicComfort characteristicComfort);

}
