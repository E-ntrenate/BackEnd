package com.example.entrenate.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
@Entity
public class Cursos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_curso;
    private String Nombre_curso;
    private String Descripción;
    private Date Fecha_creación;
    private String Nombre_tutor;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "Cursos_Inscritos",
            joinColumns = @JoinColumn(
                    name = "curso_id", referencedColumnName = "id_curso"),
            inverseJoinColumns = @JoinColumn(
                    name = "usuario_id", referencedColumnName = "id_usuario"))
    private Collection<Usuario> usuarios;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contenidoCurso")
    private Contenido_Cursos contenido_cursos;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoriaCursos")
    private Categoria_Cursos categoria_cursos;



    public Cursos() {
    }

    public Cursos(String nombre_curso, String descripción, Date fecha_creación, String nombre_tutor) {
        this.Nombre_curso = nombre_curso;
        this.Descripción = descripción;
        this.Fecha_creación = fecha_creación;
        this.Nombre_tutor = nombre_tutor;
    }

    public Long getId_curso() {
        return id_curso;
    }

    public void setId_curso(Long id_curso) {
        this.id_curso = id_curso;
    }

    public String getNombre_curso() {
        return Nombre_curso;
    }

    public void setNombre_curso(String nombre_curso) {
        Nombre_curso = nombre_curso;
    }

    public String getDescripción() {
        return Descripción;
    }

    public void setDescripción(String descripción) {
        Descripción = descripción;
    }

    public Date getFecha_creación() {
        return Fecha_creación;
    }

    public void setFecha_creación(Date fecha_creación) {
        Fecha_creación = fecha_creación;
    }

    public String getNombre_tutor() {
        return Nombre_tutor;
    }

    public void setNombre_tutor(String nombre_tutor) {
        Nombre_tutor = nombre_tutor;
    }
}
