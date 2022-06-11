package com.example.entrenate.model.usuario;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String nombre;

    @ManyToMany(mappedBy = "roles")
    private List<Usuario> usuarios;

    //Constructor sin Id.
    public Rol(String nombre) {
        this.nombre = nombre;
    }
}
