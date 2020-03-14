package com.uriart.workout.repository;

import com.uriart.workout.domain.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrenadorRepository extends JpaRepository<Entrenador, Integer> {
}
