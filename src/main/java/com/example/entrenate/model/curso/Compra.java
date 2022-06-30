package com.example.entrenate.model.curso;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
@Entity
public class Compra {
    @Id
    private Long id;
    private Long Id_CursosC;
    private Long id_Curso;
    private String Nombre_curso;
    private String Categoria;
    private LocalDate Fecha;
    private String Url_curso;
    private String Desc;
    public Compra(){
    }

    public Compra(Long id_CursosC, Long id_Curso, String nombre_curso, String categoria, LocalDate fecha, String url_curso, String desc) {
        Id_CursosC = id_CursosC;
        this.id_Curso = id_Curso;
        Nombre_curso = nombre_curso;
        Categoria = categoria;
        Fecha = fecha;
        Url_curso = url_curso;
        Desc = desc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getUrl_curso() {
        return Url_curso;
    }

    public void setUrl_curso(String url_curso) {
        Url_curso = url_curso;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }
}
//(auxJC.getId_Curso(), auxJ.getId(), auxJ.getNombre(), auxJ.getCategoria(), auxJ.getFecha());