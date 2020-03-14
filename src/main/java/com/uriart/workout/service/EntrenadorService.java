package com.uriart.workout.service;

import com.uriart.workout.domain.Entrenador;
import com.uriart.workout.repository.EntrenadorRepository;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EntrenadorService {

    private final EntrenadorRepository entrenadorRepository;

    public EntrenadorService(EntrenadorRepository entrenadorRepository) {
        this.entrenadorRepository = entrenadorRepository;
    }
    
    public List<Entrenador> buscarTodos() {
        return entrenadorRepository.findAll(Sort.by("nombre"));
    }
}
