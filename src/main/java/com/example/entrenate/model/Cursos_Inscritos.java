package com.example.entrenate.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "cursos_inscritos")
public class Cursos_Inscritos {
    @Id
    @Column(name = "curso_id", nullable = false)
    private int curso_id;
    @Column(name = "usuario_id", nullable = false)
    private int usuario_id;



    public int getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(int curso_id) {
        this.curso_id = curso_id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }
}
