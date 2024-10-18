package com.unam.poo.repository;

import com.unam.poo.models.Comfort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComfortRepository extends JpaRepository<Comfort, Long> {

}

