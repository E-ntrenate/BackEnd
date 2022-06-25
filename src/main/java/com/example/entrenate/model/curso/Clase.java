package com.example.entrenate.model.curso;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Clase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String desc;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private float duracion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

    public Clase(final String nombre, final String desc, final String link, final float duracion) {
        this.nombre = nombre;
        this.desc = desc;
        this.link = link;
        this.duracion = duracion;
    }
}