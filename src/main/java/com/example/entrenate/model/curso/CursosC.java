package com.example.entrenate.model.curso;

import javax.persistence.*;

@Entity
@Table(name = "CursosC")
public class CursosC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCursosC;

    private Long idCurso;
    @Column(name = "Usuario")
    private String idUsuario;

    public CursosC() {
    }

    public CursosC(Long idCurso, String idUsuario) {
        this.idCurso = idCurso;
        this.idUsuario = idUsuario;
    }

    public Long getIdCursosC() {
        return idCursosC;
    }

    public void setIdCursosC(Long idCursosC) {
        this.idCursosC = idCursosC;
    }

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
}
