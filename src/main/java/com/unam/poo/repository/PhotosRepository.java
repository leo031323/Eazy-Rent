package com.unam.poo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unam.poo.models.Photo;

@Repository
public interface PhotosRepository extends JpaRepository<Photo, Long>{
    
}
