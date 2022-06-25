package com.example.entrenate.web.dto;

import com.example.entrenate.model.usuario.Usuario;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Lob;
import java.time.LocalDate;

public class CursoRegistroDto {

    private String nombre;

    @Lob
    private byte[] photo;
    private String desc;
    private String reseña;
    private String urlTrailer;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;
    private float precio;
    private String categoria;

    @Lob
    private byte[] frontImg;

    @Lob
    private byte[] backImg;
    private Usuario tutor;

    public CursoRegistroDto() {

    }

    public CursoRegistroDto(final String nombre, final byte[] photo, final String desc, final String reseña, final String urlTrailer, final LocalDate fecha, final float precio, final String categoria, final byte[] frontImg, final byte[] backImg, final Usuario tutor) {
        this.nombre = nombre;
        this.photo = photo;
        this.desc = desc;
        this.reseña = reseña;
        this.urlTrailer = urlTrailer;
        this.fecha = fecha;
        this.precio = precio;
        this.categoria = categoria;
        this.frontImg = frontImg;
        this.backImg = backImg;
        this.tutor = tutor;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public byte[] getPhoto() {
        return this.photo;
    }

    public void setPhoto(final byte[] photo) {
        this.photo = photo;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(final String desc) {
        this.desc = desc;
    }

    public String getReseña() {
        return this.reseña;
    }

    public void setReseña(final String reseña) {
        this.reseña = reseña;
    }

    public String getUrlTrailer() {
        return this.urlTrailer;
    }

    public void setUrlTrailer(final String urlTrailer) {
        this.urlTrailer = urlTrailer;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }

    public void setFecha(final LocalDate fecha) {
        this.fecha = fecha;
    }

    public float getPrecio() {
        return this.precio;
    }

    public void setPrecio(final float precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(final String categoria) {
        this.categoria = categoria;
    }

    public byte[] getFrontImg() {
        return this.frontImg;
    }

    public void setFrontImg(final byte[] frontImg) {
        this.frontImg = frontImg;
    }

    public byte[] getBackImg() {
        return this.backImg;
    }

    public void setBackImg(final byte[] backImg) {
        this.backImg = backImg;
    }

    public Usuario getTutor() {
        return this.tutor;
    }

    public void setTutor(final Usuario tutor) {
        this.tutor = tutor;
    }
}

