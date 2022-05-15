package com.example.entrenate.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Categoria_Cursos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_categoria;
    private String Nombre_categoria;
}