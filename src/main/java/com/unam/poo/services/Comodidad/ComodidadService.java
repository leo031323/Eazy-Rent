package com.unam.poo.services.Comodidad;

import com.unam.poo.models.Comfort;

import java.util.List;

public interface ComodidadService {

    List<Comfort> findAll();
    void deleteComodidadById(Long id);
    Comfort getComodidadById(Long id);
    Comfort saveComodidad(Comfort comfort);

}
