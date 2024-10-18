package com.unam.poo.repository;

import com.unam.poo.models.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {

//    list of all posts with statusPublication = active
    List<Publication> findAllByStatePublication(String statePublication);

//    Search method for publications by title using like before and after
    List<Publication> findByQualificationPublicationContaining(String qualification);

//   bring all the favorites of a user



}

