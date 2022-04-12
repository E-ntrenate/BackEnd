package com.example.entrenate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria_Cursos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_categoria;
    private String Nombre_categoria;

    public Categoria_Cursos() {
    }

    public Categoria_Cursos(String nombre_categoria) {
        this.Nombre_categoria = nombre_categoria;
    }

    public Long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre_categoria() {
        return Nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        Nombre_categoria = nombre_categoria;
    }
}