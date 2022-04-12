package com.example.entrenate.model;

import javax.persistence.GenerationType;
import javax.persistence.*;
@Entity
public class Contenido_Cursos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_contenido;
    private String Link_contenido;

    public Contenido_Cursos() {
    }

    public Contenido_Cursos(String link_contenido) {
        this.Link_contenido = link_contenido;
    }

    public Long getId_contenido() {
        return id_contenido;
    }

    public void setId_contenido(Long id_contenido) {
        this.id_contenido = id_contenido;
    }

    public String getLink_contenido() {
        return Link_contenido;
    }

    public void setLink_contenido(String link_contenido) {
        Link_contenido = link_contenido;
    }
}