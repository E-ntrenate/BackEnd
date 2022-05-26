package com.example.entrenate.model;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cursos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //@Column(nullable = false, unique = true)
    private String nombre;

    private String desc;
    private String fecha;
    private String tutor;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "Cursos_Inscritos",
            joinColumns = @JoinColumn(
                    name = "curso_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "usuario_id", referencedColumnName = "id"))
    private Collection<Usuario> usuarios;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contenidoCurso")
    private Contenido_Cursos contenido_cursos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoriaCursos")
    private Categoria_Cursos categoria_cursos;

    public Cursos(String nombre, String desc, String fecha, String tutor, Collection<Usuario> usuarios, Contenido_Cursos contenido_cursos, Categoria_Cursos categoria_cursos) {
        this.nombre = nombre;
        this.desc = desc;
        this.fecha = fecha;
        this.tutor = tutor;
        this.usuarios = usuarios;
        this.contenido_cursos = contenido_cursos;
        this.categoria_cursos = categoria_cursos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public Collection<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Collection<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Contenido_Cursos getContenido_cursos() {
        return contenido_cursos;
    }

    public void setContenido_cursos(Contenido_Cursos contenido_cursos) {
        this.contenido_cursos = contenido_cursos;
    }

    public Categoria_Cursos getCategoria_cursos() {
        return categoria_cursos;
    }

    public void setCategoria_cursos(Categoria_Cursos categoria_cursos) {
        this.categoria_cursos = categoria_cursos;
    }
}
