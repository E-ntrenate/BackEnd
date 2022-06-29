package com.example.entrenate.model.curso;

import java.time.LocalDate;

public class Compra {
    private Long Id_CursosC;
    private Long id_Curso;
    private String Nombre_curso;
    private String Categoria;
    private LocalDate Fecha;
    public Compra(){
    }

    public Compra(Long id_CursosC, Long id_Curso, String nombre_curso, String categoria, LocalDate fecha) {
        this.Id_CursosC = id_CursosC;
        this.id_Curso = id_Curso;
        this.Nombre_curso = nombre_curso;
        this.Categoria = categoria;
        this.Fecha = fecha;
    }

    public Long getId_CursosC() {
        return Id_CursosC;
    }

    public void setId_CursosC(Long id_CursosC) {
        Id_CursosC = id_CursosC;
    }

    public Long getId_Curso() {
        return id_Curso;
    }

    public void setId_Curso(Long id_Curso) {
        this.id_Curso = id_Curso;
    }

    public String getNombre_curso() {
        return Nombre_curso;
    }

    public void setNombre_curso(String nombre_curso) {
        Nombre_curso = nombre_curso;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public LocalDate getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDate fecha) {
        Fecha = fecha;
    }
}
//(auxJC.getId_Curso(), auxJ.getId(), auxJ.getNombre(), auxJ.getCategoria(), auxJ.getFecha());