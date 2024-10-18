package com.unam.poo.services.Comfort;

import com.unam.poo.models.Comfort;

import java.util.List;

public interface   ComfortService {

    List<Comfort> findAll();
    void deleteComfortById(Long id);
    Comfort getComfortById(Long id);
    Comfort saveComfort(Comfort comfort);

}
