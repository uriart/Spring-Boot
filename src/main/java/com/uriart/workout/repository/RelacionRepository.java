package com.uriart.workout.repository;

import com.uriart.workout.domain.Relaciones;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RelacionRepository extends JpaRepository<Relaciones, Integer> {
    
}
