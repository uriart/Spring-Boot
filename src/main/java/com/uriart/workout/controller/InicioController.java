package com.uriart.workout.controller;

import com.uriart.workout.domain.ApiAccess;
import com.uriart.workout.domain.Ejercicio;
import com.uriart.workout.service.EjercicioService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class InicioController {

    private final EjercicioService ejercicioService;
    private final EjercicioService materialService;
    private final EjercicioService relacionService;

    public InicioController(EjercicioService ejercicioService, EjercicioService materialService, EjercicioService relacionService) {
        this.ejercicioService = ejercicioService;
        this.materialService = materialService;
        this.relacionService = relacionService;
    }

    @RequestMapping("/")
    public String paginaInicial(Model model) {
        List<Ejercicio> ejercicios = ejercicioService.buscarEjercicios();
        model.addAttribute("ejerciciosSalida", ejercicios);
        return "inicio";
    }

    @RequestMapping(value = "/filtrar", method = RequestMethod.POST)
    public String filtrarEjercicio(Model model,
            @RequestParam("inputZonaMuscular") String zonaMuscular,
            @RequestParam(value = "inputMaterial", required = false) List<Integer> inputMaterial) {

        List<Ejercicio> ejercicios = ejercicioService.buscarEjercicios();

        List<Ejercicio> salida = new ArrayList();

        //Recorremos lista de salida de todos los ejercicios y filtramos por zona muscular
        for (int x = 0; x < ejercicios.size(); x++) {
            if (ejercicios.get(x).getZonaMuscular().equalsIgnoreCase(zonaMuscular)
                    || (null != ejercicios.get(x).getZonaMuscular2() && ejercicios.get(x).getZonaMuscular2().equalsIgnoreCase(zonaMuscular))
                    || zonaMuscular.equalsIgnoreCase("1")) {

                Ejercicio ejer = new Ejercicio();
                ejer.setNombre(ejercicios.get(x).getNombre());
                ejer.setImagenUrl(ejercicios.get(x).getImagenUrl());
                ejer.setId(ejercicios.get(x).getId());
                salida.add(ejer);

            }
        }

        /*
        TODO Filtro por material
        for (int y = 0; y < salida.size(); y++) {
            List<Relaciones> listaRelaciones = ejercicioService.relacion(salida.get(y).getId());
            for (int l = 0; l < listaRelaciones.size(); l++) {
                for (int m = 0; null != inputMaterial && m < inputMaterial.size(); m++) {
                    if (null != inputMaterial && inputMaterial.get(m).toString().equalsIgnoreCase(listaRelaciones.get(l).getId_material().toString())) {
                        salida.remove(y);
                    }
                }
            }
        }
         */
        model.addAttribute("ejerciciosSalida", salida);

        return "inicio";
    }

    @RequestMapping("/detalles")
    public String paginaDetalle(Model model,
            @RequestParam("idEjercicio") String idEjercicio) {

        //Ejercicio detalleEjercicio = ejercicioService.detalleEjercicio(Integer.valueOf(idEjercicio));
        //model.addAttribute("detallesSalida", detalleEjercicio);

        
        
        
        
        //Prueba acceso API pública
        RestTemplate restTemplate = new RestTemplate();
        ApiAccess obj = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", ApiAccess.class);
       
        System.out.print("value: "+obj.getValue());
        System.out.print("type: "+obj.getType());
        
        List<ApiAccess> apiAccess = null;
        model.addAttribute("detallesSalida", obj);
        
        
        
        
        
        
        
        
        
        return "detalles";
    }
}
