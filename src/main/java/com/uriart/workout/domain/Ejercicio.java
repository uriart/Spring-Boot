package com.uriart.workout.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ejercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String imagenUrl;
    private String zonaMuscular;
    private String zonaMuscular2;
    @ManyToOne
    private Entrenador entrenador;

    public String getZonaMuscular2() {
        return zonaMuscular2;
    }

    public void setZonaMuscular2(String zonaMuscular2) {
        this.zonaMuscular2 = zonaMuscular2;
    }
   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
        
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public String getZonaMuscular() {
        return zonaMuscular;
    }

    public void setZonaMuscular(String zonaMuscular) {
        this.zonaMuscular = zonaMuscular;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    @Override
    public String toString() {
        return "Ejercicio{" + "id=" + id + ", nombre=" + nombre + ", imagenUrl=" + imagenUrl + ", zonaMuscular=" + zonaMuscular + ", zonaMuscular2=" + zonaMuscular2 + ", entrenador=" + entrenador.getId() + '}';
    }
    
}
