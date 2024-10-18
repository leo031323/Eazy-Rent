package com.unam.poo.services.Foto;

import java.util.List;

import com.unam.poo.models.Photo;

public interface FotoService {
    List<Photo> findAll();
    void deleteFotoById(Long id);
    Photo getFotoById(Long id);
    Photo saveFoto(Photo photo);
    String transformToDataURI(Photo photo);
}
