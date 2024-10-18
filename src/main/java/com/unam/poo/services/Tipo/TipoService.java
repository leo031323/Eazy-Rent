package com.unam.poo.services.Tipo;

import com.unam.poo.models.Type;

import java.util.List;

public interface TipoService {

    List<Type> findAll();
    void deleteTipoById(Long id);
    Type getTipoById(Long id);
    Type saveTipo(Type type);

}
