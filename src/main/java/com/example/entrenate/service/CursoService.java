package com.example.entrenate.service;

import com.example.entrenate.model.curso.Curso;
import com.example.entrenate.web.dto.CursoRegistroDto;

import java.util.List;

public interface CursoService {
    Curso save(CursoRegistroDto cursoDto);
    public Curso buscarPorId(Long id);
    public List<Curso> listarCursos();

}
