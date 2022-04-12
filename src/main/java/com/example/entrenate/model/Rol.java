package com.example.entrenate.model;

import javax.persistence.*;
@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_rol;
    private String Nombre_rol;

    public Rol() {
    }

    public Rol(String nombre_rol) {
        this.Nombre_rol = nombre_rol;
    }

    public Long getId_rol() {
        return id_rol;
    }

    public void setId_rol(Long id_rol) {
        this.id_rol = id_rol;
    }

    public String getNombre_rol() {
        return Nombre_rol;
    }

    public void setNombre_rol(String nombre_rol) {
        Nombre_rol = nombre_rol;
    }
}
