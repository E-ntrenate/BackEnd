package com.example.entrenate.model;

import lombok.*;

import javax.persistence.GenerationType;
import javax.persistence.*;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contenido_Cursos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_contenido;
    private String Link_contenido;
}