package com.unam.poo.services.CharacteristicComfort;

import com.unam.poo.models.CharacteristicComfort;
import com.unam.poo.repository.CharacteristicComfortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacteristicComfortServiceImpl implements CharacteristicComfortService {

    @Autowired
    private CharacteristicComfortRepository characteristicComfortRepository;

    @Override
    public List<CharacteristicComfort> findAll() {
        return characteristicComfortRepository.findAll();
    }

    @Override
    public void deleteCharacteristicComfortById(Long id) {

    }

    @Override
    public CharacteristicComfort getCharacteristicComfortById(Long id) {
        return characteristicComfortRepository.findById(id).get();
    }

    @Override
    public CharacteristicComfort saveCharacteristicComfort(CharacteristicComfort characteristicComfort) {
        return null;
    }
}
