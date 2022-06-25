package com.example.entrenate.model.curso;

import com.example.entrenate.model.usuario.Usuario;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
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
    private byte[] photo;

    @Column(nullable = false)
    @Length(max = 100)
    private String desc;

    @Column(nullable = false)
    private String reseña;

    @Column(nullable = false)
    private String urlTrailer;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;

    @Column(nullable = false)
    private float precio;

    @Column(nullable = false)
    private float duracion;

    private String categoria;

    @Lob
    private byte[] frontImg;

    @Lob
    private byte[] backImg;

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

    @OneToMany(mappedBy = "curso")
    private Collection<Clase> clases;

    public Curso(final String nombre, final byte[] photo, final String desc, final String reseña, final String urlTrailer, final LocalDate fecha, final float precio, final String categoria, final byte[] frontImg, final byte[] backImg, final Usuario tutor) {
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
}
