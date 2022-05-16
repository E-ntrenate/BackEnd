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

    @Column(nullable = false, unique = true)
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
}
