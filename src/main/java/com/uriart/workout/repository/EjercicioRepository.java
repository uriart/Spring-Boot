package com.uriart.workout.repository;

import com.uriart.workout.domain.Ejercicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EjercicioRepository extends JpaRepository<Ejercicio, Integer> {
    
}
