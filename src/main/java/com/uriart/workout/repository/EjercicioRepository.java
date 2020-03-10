package com.uriart.workout.repository;

import com.uriart.workout.domain.Ejercicio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EjercicioRepository extends JpaRepository<Ejercicio, Integer> {
    
    //Query nativa SQL
    //@Query(value = "select * from ejercicio order by nombre", nativeQuery=true)
    
    //Query en JPQL
    @Query("from Ejercicio v order by v.entrenador")
    List<Ejercicio>  buscarTodos();
    
//    @Query("from Ejercicio v where v.entrenador.id = ?1 order by v.nombre")
    List<Ejercicio> findByEntrenadorId(int entrenadorId);
    
//    @Query("from Ejercicio v where v.nombre like %?1%")
    List<Ejercicio> findByNombreContaining(String consulta);
    
    
}
