package com.unam.poo.services.Publicacion;


import com.unam.poo.models.Publication;
import com.unam.poo.repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicacionServiceImpl implements PublicacionService{

    @Autowired
    private PublicationRepository publicationRepository;


    @Override
    public Publication getPublicacionById(Long id) {
        return publicationRepository.findById(id).get();
    }

    @Override
    public Publication savePublicacion(Publication publication) {
        return publicationRepository.save(publication);
    }

    @Override
    public List<Publication> findAll() {
        return publicationRepository.findAll();
    }

    @Override
    public void updatePublicacion(Publication publication, Long id) {

        publicationRepository.save(publication);
    }

    @Override
    public List<Publication> findAllByEstadoPublicacion(String estadoPublicacion) {
        return publicationRepository.findAllByStatePublication(estadoPublicacion);
    }

    //    borrado logico de publicacion
    @Override
    public void deletePublicacionById(Long id) {
        Publication publication = publicationRepository.findById(id).get();
        publication.setStatePublication("eliminado");
        publicationRepository.save(publication);
    }

    //    metodo de busqueda publicaciones por id o titulo
    @Override
    public List<Publication> findByTituloPublicacionContaining(String titulo) {
        return publicationRepository.findByQualificationPublicationContaining(titulo);
    }




}
