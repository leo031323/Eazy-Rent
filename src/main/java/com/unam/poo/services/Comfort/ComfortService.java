package com.unam.poo.services.Comfort;

import com.unam.poo.models.Comfort;

import java.util.List;

public interface   ComfortService {

    List<Comfort> findAll();
    void delete ComfortById(Long id);
    Comfort get ComfortById(Long id);
    Comfort save Comfort(Comfort comfort);

}
