package com.unam.poo.services.Publicacion;


import com.unam.poo.models.Publicacion;
import com.unam.poo.repository.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicacionServiceImpl implements PublicacionService{

    @Autowired
    private PublicacionRepository publicacionRepository;

    @Override
    public void deletePublicacionById(Long id) {
        publicacionRepository.deleteById(id);
    }

    @Override
    public Publicacion getPublicacionById(Long id) {
        return publicacionRepository.findById(id).get();
    }

    @Override
    public Publicacion savePublicacion(Publicacion publicacion) {
        return publicacionRepository.save(publicacion);
    }

    @Override
    public List<Publicacion> findAll() {
        return publicacionRepository.findAll();
    }

    @Override
    public Publicacion updatePublicacion(Publicacion publicacion, Long id) {
        Publicacion publicacion1 = publicacionRepository.findById(id).get();
        publicacion1.setTituloPublicacion(publicacion.getTituloPublicacion());
        publicacion1.setDescripcionPublicacion(publicacion.getDescripcionPublicacion());
        publicacion1.setPrecioPublicacion(publicacion.getPrecioPublicacion());
        publicacion1.setIdTipo(publicacion.getIdTipo());
//        publicacion1.setUsuario(publicacion.getUsuario());
        publicacion1.setIdCiudad(publicacion.getIdCiudad());
        publicacion1.setCaracteristicasComodidades(publicacion.getCaracteristicasComodidades());
        return publicacionRepository.save(publicacion1);
    }

}
