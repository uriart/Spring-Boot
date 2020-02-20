package com.uriart.workout.service;

import com.uriart.workout.domain.Ejercicio;
import com.uriart.workout.repository.EjercicioRepository;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EjercicioService {

    private final EjercicioRepository ejercicioRepository;

    public EjercicioService(EjercicioRepository ejercicioRepository) {
        this.ejercicioRepository = ejercicioRepository;
    }

    public List<Ejercicio> buscarEjercicios() {
        return ejercicioRepository.buscarTodos();
    }

    public Ejercicio detalleEjercicio(Integer id) {
        //Retrona un resultado según el ID de la tabla
        return ejercicioRepository.getOne(id);
    }

    /*
    TODO Filtro por material
    public List<Relaciones> relacion(Integer idEjercicio) {
        return relacionRepository.search(idEjercicio);
    }
    */

}