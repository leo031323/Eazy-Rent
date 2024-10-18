package com.unam.poo.repository;

import com.unam.poo.models.CharacteristicComfort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacteristicComfortRepository extends JpaRepository<CharacteristicComfort, Long> {

}
