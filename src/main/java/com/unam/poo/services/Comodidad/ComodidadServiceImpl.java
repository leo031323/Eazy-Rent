package com.unam.poo.services.Comodidad;

import com.unam.poo.models.Comfort;
import com.unam.poo.repository.ComfortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComodidadServiceImpl implements ComodidadService {

    @Autowired
    private ComfortRepository comfortRepository;

    @Override
    public List<Comfort> findAll() {
        return comfortRepository.findAll();
    }

    @Override
    public void deleteComodidadById(Long id) {

    }

    @Override
    public Comfort getComodidadById(Long id) {
        return comfortRepository.findById(id).get();
    }

    @Override
    public Comfort saveComodidad(Comfort comfort) {
        return null;
    }
}

