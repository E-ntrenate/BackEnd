package com.example.entrenate.service;

import com.example.entrenate.model.curso.Compra;
import com.example.entrenate.model.curso.Curso;
import com.example.entrenate.model.curso.CursosC;
import com.example.entrenate.model.usuario.Usuario;

import java.util.List;

public interface CursosCService {
    public  CursosC comprar(Long id_Cursos);
    public void eliminar(Long id);
    public Curso buscarPorId(Long id);
    public List<Compra> listarCursosC();
    public List<Usuario> listarEstudiantes(Long Id_Cursos);



}


