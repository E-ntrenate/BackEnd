package com.example.entrenate.web.dto;

import com.example.entrenate.model.curso.Categoria;
import com.example.entrenate.model.curso.Clase;
import com.example.entrenate.model.usuario.Usuario;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Collection;

public class CursoRegistroDto {

    private String nombre;
    private MultipartFile photo;
    private String desc;
    private String reseña;
    private String urlTrailer;
    private String fecha;
    private float precio;
    private float duracion;
    private MultipartFile frontImg;
    private MultipartFile backImg;
    private Usuario tutor;
    private Collection<Categoria> categorias;

    public CursoRegistroDto(final String nombre, final MultipartFile photo, final String desc, final String reseña, final String urlTrailer, final String fecha, final float precio, final float duracion, final MultipartFile frontImg, final MultipartFile backImg, final Usuario tutor, final Collection<Categoria> categorias) {
        this.nombre = nombre;
        this.photo = photo;
        this.desc = desc;
        this.reseña = reseña;
        this.urlTrailer = urlTrailer;
        this.fecha = fecha;
        this.precio = precio;
        this.duracion = duracion;
        this.frontImg = frontImg;
        this.backImg = backImg;
        this.tutor = tutor;
        this.categorias = categorias;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public MultipartFile getPhoto() {
        return this.photo;
    }

    public void setPhoto(final MultipartFile photo) {
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

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(final String fecha) {
        this.fecha = fecha;
    }

    public float getPrecio() {
        return this.precio;
    }

    public void setPrecio(final float precio) {
        this.precio = precio;
    }

    public float getDuracion() {
        return this.duracion;
    }

    public void setDuracion(final float duracion) {
        this.duracion = duracion;
    }

    public MultipartFile getFrontImg() {
        return this.frontImg;
    }

    public void setFrontImg(final MultipartFile frontImg) {
        this.frontImg = frontImg;
    }

    public MultipartFile getBackImg() {
        return this.backImg;
    }

    public void setBackImg(final MultipartFile backImg) {
        this.backImg = backImg;
    }

    public Usuario getTutor() {
        return this.tutor;
    }

    public void setTutor(final Usuario tutor) {
        this.tutor = tutor;
    }

    public Collection<Categoria> getCategorias() {
        return this.categorias;
    }

    public void setCategorias(final Collection<Categoria> categorias) {
        this.categorias = categorias;
    }
}

