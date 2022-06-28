package com.example.entrenate.web.dto;

import com.example.entrenate.model.usuario.Usuario;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Lob;
import java.time.LocalDate;

public class CursoRegistroDto {

    private String nombre;


    private String desc;
    private String reseña;
    private String urlTrailer;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;
    private float precio;
    private String categoria;
    @Column(nullable = false)
    private float duracion;

    public CursoRegistroDto() {

    }

    public CursoRegistroDto(String nombre, String desc, String reseña, String urlTrailer, LocalDate fecha, float precio, String categoria, float duracion) {
        this.nombre = nombre;
        this.desc = desc;
        this.reseña = reseña;
        this.urlTrailer = urlTrailer;
        this.fecha = fecha;
        this.precio = precio;
        this.categoria = categoria;
        this.duracion = duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getReseña() {
        return reseña;
    }

    public void setReseña(String reseña) {
        this.reseña = reseña;
    }

    public String getUrlTrailer() {
        return urlTrailer;
    }

    public void setUrlTrailer(String urlTrailer) {
        this.urlTrailer = urlTrailer;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }
}

