package com.uriart.workout.repository;

import com.uriart.workout.domain.Relaciones;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RelacionRepository extends JpaRepository<Relaciones, Integer> {

   // @Query("SELECT id FROM Relaciones relaciones WHERE id_ejercicio = (:id_ejercicio)")
    //List<Relaciones> findByFirstname(@Param("id_ejercicio") Integer idEjercicio);

    @Query("from Relaciones where id_ejercicio = (:id_ejercicio)")
    public List<Relaciones> search(@Param("id_ejercicio") Integer idEjercicio);

}
