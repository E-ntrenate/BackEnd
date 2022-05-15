package com.example.entrenate.model;

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
    private Long idRol;
    private String nombreRol;

    @ManyToMany(mappedBy = "roles")
    private List<Usuario> usuarios;

    //Constructor sin Id.
    public Rol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
}
