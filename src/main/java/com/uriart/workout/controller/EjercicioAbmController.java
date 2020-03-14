package com.uriart.workout.controller;

import com.uriart.workout.domain.Ejercicio;
import com.uriart.workout.domain.Entrenador;
import com.uriart.workout.service.EjercicioService;
import com.uriart.workout.service.EntrenadorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EjercicioAbmController {

    private final EntrenadorService entrenadorService;
    private final EjercicioService ejercicioService;

    public EjercicioAbmController(EntrenadorService entrenadorService, EjercicioService ejercicioService) {
        this.entrenadorService = entrenadorService;
        this.ejercicioService = ejercicioService;
    }

    @RequestMapping("/ejercicios/crear")
    public String mostrarFormAlta(Model model, Integer id) {
        
        Ejercicio ejercicio = null;
        if (null != id) {
            ejercicio = ejercicioService.detalleEjercicio(Integer.valueOf(id));
        } else {
            ejercicio = new Ejercicio();
        }

        model.addAttribute("ejercicio", ejercicio);
        model.addAttribute("entrenadores", entrenadorService.buscarTodos());

        return "formEjercicio";
    }

    @PostMapping("/ejercicios/guardar")
    public String guardar(Ejercicio ejercicio) {

        ejercicioService.guardar(ejercicio);
        System.out.println("Valores recibidos de la pantalla de crear ejercicio: " + ejercicio.toString());
        return "redirect:/";
    }

}
