package com.unam.poo.services.Tipo;

import com.unam.poo.models.Type;
import com.unam.poo.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoServiceImpl implements TipoService {

    @Autowired
    private TypeRepository typeRepository;

    @Override
    public List<Type> findAll() {
        return typeRepository.findAll();
    }

    @Override
    public void deleteTipoById(Long id) {

    }

    @Override
    public Type getTipoById(Long id) {
        return typeRepository.findById(id).get();
    }

    @Override
    public Type saveTipo(Type type) {
        return typeRepository.save(type);
    }
}

