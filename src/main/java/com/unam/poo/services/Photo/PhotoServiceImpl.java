package com.unam.poo.services.Photo;

import java.util.List;

import com.unam.poo.models.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unam.poo.repository.PhotosRepository;

@Service
public class PhotoServiceImpl implements PhotoService{

    @Autowired
    PhotosRepository photosRepository;

    @Override
    public List<Photo> findAll() {
        return photosRepository.findAll();
    }

    @Override
    public void deletePhotoById(Long id) {
        photosRepository.deleteById(id);
    }

    @Override
    public Photo getPhotoById(Long id) {
        return photosRepository.findById(id).orElse(null);
    }
 
    @Override
    public Photo savePhoto(Photo photo) {
        return photosRepository.save(photo);
    }

    @Override
    public String transformToDataURI(Photo photo) {
        String str = "";
        str += "data:image/png;base64,";
        //str += Base64.getEncoder().encodeToString(photo.getBytes());
        return str;
    }
    
}
