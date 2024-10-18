package com.unam.poo.services.Publicacion;

import com.unam.poo.models.Publication;

import java.util.List;

public interface PublicacionService {

    List<Publication> findAll();
    void deletePublicacionById(Long id);
    Publication getPublicacionById(Long id);
    Publication savePublicacion(Publication publication);

//    metodo para actualizar una publication
    void updatePublicacion(Publication publication, Long id);

    List<Publication> findAllByStatePublicacion(String statePublicacion);

//    metodo de busqueda publicaciones por id o qualification
    List<Publication> findByQualificationPublicacionContaining(String qualification);

}
