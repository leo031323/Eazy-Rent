package com.unam.poo.repository;

import com.unam.poo.models.FeatureComfort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureComfortRepository extends JpaRepository<FeatureComfort, Long> {

}
