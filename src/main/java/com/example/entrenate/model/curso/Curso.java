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

    @Lob
    private MultipartFile photo;

    @Column(nullable = false)
    @Length(max = 100)
    private String desc;

    @Column(nullable = false)
    private String reseña;

    @Column(nullable = false)
    private String urlTrailer;

    @Column(nullable = false)
    private String fecha;

    @Column(nullable = false)
    private float precio;

    @Column(nullable = false)
    private float duracion;

    @Lob
    private MultipartFile frontImg;

    @Lob
    private MultipartFile backImg;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Incripción_Curso",
            joinColumns = @JoinColumn(
                    name = "curso_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "usuario_id", referencedColumnName = "id"))
    private Collection<Usuario> usuarios;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tutor", nullable = false)
    private Usuario tutor;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Categorias_Cursos",
            joinColumns = @JoinColumn(
                    name = "curso_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "categoria", referencedColumnName = "id"))
    private Collection<Categoria> categorias;

    @OneToMany(mappedBy = "curso")
    private Collection<Clase> clases;

    public Curso(final String nombre, final MultipartFile photo, final String desc, final String reseña, final String urlTrailer, final String fecha, final float precio, final float duracion, final MultipartFile frontImg, final MultipartFile backImg,  final Usuario tutor, final Collection<Categoria> categorias) {
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
}
