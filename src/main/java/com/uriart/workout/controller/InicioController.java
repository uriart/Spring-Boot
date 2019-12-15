package com.uriart.workout.controller;

import com.uriart.workout.domain.Ejercicio;
import com.uriart.workout.service.EjercicioService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InicioController {

    private final EjercicioService ejercicioService;

    public InicioController(EjercicioService ejercicioService) {
        this.ejercicioService = ejercicioService;
    }

    @RequestMapping("/")
    public String paginaInicial(Model model) {
        List<Ejercicio> ejercicios = ejercicioService.buscarEjercicios();
        model.addAttribute("ejerciciosSalida", ejercicios);
        return "inicio";
    }

    @RequestMapping(value = "/filtrar", method = RequestMethod.POST)
    public String anadirEjercicio(Model model,
            @RequestParam("inputZonaMuscular") String zonaMuscular) {

        List<Ejercicio> ejercicios = ejercicioService.buscarEjercicios();
        List<Ejercicio> salida = new ArrayList();

        for (int x = 0; x < ejercicios.size(); x++) {
            if (ejercicios.get(x).getZonaMuscular().equalsIgnoreCase(zonaMuscular) || zonaMuscular.equalsIgnoreCase("1")) {
                Ejercicio ejer = new Ejercicio();
                ejer.setNombre(ejercicios.get(x).getNombre());
                ejer.setImagenUrl(ejercicios.get(x).getImagenUrl());
                salida.add(ejer);
            }
        }

        for (int x = 0; x < ejercicios.size(); x++) {
            if (null != ejercicios.get(x).getZonaMuscular2() && ejercicios.get(x).getZonaMuscular2().equalsIgnoreCase(zonaMuscular)) {
                Ejercicio ejer = new Ejercicio();
                ejer.setNombre(ejercicios.get(x).getNombre());
                ejer.setImagenUrl(ejercicios.get(x).getImagenUrl());
                salida.add(ejer);
            }
        }

        model.addAttribute("ejerciciosSalida", salida);

        return "inicio";
    }
}
