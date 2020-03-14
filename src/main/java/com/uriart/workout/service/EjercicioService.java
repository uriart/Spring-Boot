package com.uriart.workout.service;

import com.uriart.workout.domain.Ejercicio;
import com.uriart.workout.repository.EjercicioRepository;
import java.util.List;
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

    public List<Ejercicio> buscarPorEntrenador(int entrenadorId) {
        return ejercicioRepository.findByEntrenadorId(entrenadorId);
    }

    public List<Ejercicio> buscar(String consulta) {
        return ejercicioRepository.findByNombreContaining(consulta);
    }
    
    public Ejercicio guardar(Ejercicio ejercicio) {
        return ejercicioRepository.save(ejercicio);
    }
}
