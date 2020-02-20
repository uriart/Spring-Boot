package com.uriart.workout.repository;

import com.uriart.workout.domain.Ejercicio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EjercicioRepository extends JpaRepository<Ejercicio, Integer> {
    
    @Query("select v from Ejercicio v order by v.nombre")
    List<Ejercicio>  buscarTodos();
    
}
