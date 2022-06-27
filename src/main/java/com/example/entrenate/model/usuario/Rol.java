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
    private Long id;
    @Column(nullable = false, unique = true)
    private String nombre;

    //Constructor sin Id.
    public Rol(String nombre) {
        this.nombre = nombre;
    }
}
