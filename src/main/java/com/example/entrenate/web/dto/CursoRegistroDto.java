package com.example.entrenate.web.dto;

import org.springframework.web.multipart.MultipartFile;

public class CursoRegistroDto {

    private String nombre;
    private String desc;
    private String fecha;
    private String reseña;
    private String urlTrailer;
    private String precio;
    //private float duracion;


    public CursoRegistroDto() {
    }

    public CursoRegistroDto(String nombre, String desc, String fecha, String reseña, String urlTrailer, String precio) {
        this.nombre = nombre;
        this.desc = desc;
        this.fecha = fecha;
        this.reseña = reseña;
        this.urlTrailer = urlTrailer;
        this.precio = precio;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}

