package com.example.entrenate.model.curso;

import lombok.*;

import javax.persistence.GenerationType;
import javax.persistence.*;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contenido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String link;

    public Contenido(String link) {
        this.link = link;
    }
}