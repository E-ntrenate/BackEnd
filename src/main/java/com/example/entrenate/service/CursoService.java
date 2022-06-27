package com.example.entrenate.service;

import com.example.entrenate.model.curso.Curso;
import com.example.entrenate.web.dto.CursoRegistroDto;

public interface CursoService {
    Curso save(CursoRegistroDto cursoDto);

}
