package com.unam.poo.services.Comfort;

import com.unam.poo.models.Comfort;
import com.unam.poo.repository.ComfortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class   ComfortServiceImpl implements   ComfortService {

    @Autowired
    private ComfortRepository comfortRepository;

    @Override
    public List<Comfort> findAll() {
        return comfortRepository.findAll();
    }

    @Override
    public void deleteComfortById(Long id) {

    }

    @Override
    public Comfort getComfortById(Long id) {
        return comfortRepository.findById(id).get();
    }

    @Override
    public Comfort saveComfort(Comfort comfort) {
        return null;
    }
}

