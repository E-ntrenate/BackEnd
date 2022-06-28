package com.example.entrenate.model.curso;

import javax.persistence.*;

@Entity
@Table(name = "CursosC")
public class CursosC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_CursosC;
    @Column(name = "Juego")
    private Long id_Curso;
    @Column(name = "Usuario")
    private String id_Usuario;

    public CursosC() {
    }

    public CursosC(Long id_Curso, String id_Usuario) {
        this.id_Curso = id_Curso;
        this.id_Usuario = id_Usuario;
    }

    public Long getId_CursosC() {
        return id_CursosC;
    }

    public void setId_CursosC(Long id_CursosC) {
        this.id_CursosC = id_CursosC;
    }

    public Long getId_Curso() {
        return id_Curso;
    }

    public void setId_Curso(Long id_Curso) {
        this.id_Curso = id_Curso;
    }

    public String getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(String id_Usuario) {
        this.id_Usuario = id_Usuario;
    }
}
