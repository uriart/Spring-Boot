package com.uriart.workout.service;

import com.uriart.workout.domain.Ejercicio;
import com.uriart.workout.domain.Material;
import com.uriart.workout.domain.Relaciones;
import com.uriart.workout.repository.EjercicioRepository;
import com.uriart.workout.repository.MaterialRepository;
import com.uriart.workout.repository.RelacionRepository;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EjercicioService {

    private final EjercicioRepository ejercicioRepository;
    private final MaterialRepository materialRepository;
    private final RelacionRepository relacionRepository;

    public EjercicioService(EjercicioRepository ejercicioRepository, MaterialRepository materialRepository, RelacionRepository relacionRepository) {
        this.ejercicioRepository = ejercicioRepository;
        this.materialRepository = materialRepository;
        this.relacionRepository = relacionRepository;
    }

    public List<Ejercicio> buscarEjercicios() {
        return ejercicioRepository.findAll(Sort.by("nombre"));
    }

    public Ejercicio detalleEjercicio(Integer id) {
        //Retrona un resultado según el ID de la tabla
        return ejercicioRepository.getOne(id);
    }

    public List<Material> buscarMaterial() {
        return materialRepository.findAll(Sort.by("nombreMaterial"));
    }

    public List<Relaciones> relacion() {
        return relacionRepository.findAll();
    }

}