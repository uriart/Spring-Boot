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
        return ejercicioRepository.findAll(Sort.by("nombre"));
    }
}
