package com.example.entrenate.model;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
                    name = "usuario_id", referencedColumnName = "idUsuario"))
    private Collection<Usuario> usuarios;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contenidoCurso")
    private Contenido_Cursos contenido_cursos;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoriaCursos")
    private Categoria_Cursos categoria_cursos;
}
