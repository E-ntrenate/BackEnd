package com.example.entrenate.model.curso;

import com.example.entrenate.model.usuario.Usuario;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Length(max = 100)
    private String desc;

    private String detalles;
    private String fecha;
    private String tutor;

    /*
    ID propia
    nombre
    foto principal
    descripción corta
    Reseña larga
    Video presentacional
    fecha de creación
    Tutor (usuario.nombre)
    calificación (promedio)
        usuario
        puntaje
        reseña
    precio
    2 fotos presentacionales
    Clases lista
        Nombre
        Descripción
        Link
        Duración
    tiempo total
     */
    @Lob
    private MultipartFile photo;

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
    private Contenido contenido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoriaCursos")
    private Categoria categoria;

    public Curso(String nombre, String desc, String fecha, String tutor, Collection<Usuario> usuarios, Contenido contenido, Categoria categoria) {
        this.nombre = nombre;
        this.desc = desc;
        this.fecha = fecha;
        this.tutor = tutor;
        this.usuarios = usuarios;
        this.contenido = contenido;
        this.categoria = categoria;
    }
}
