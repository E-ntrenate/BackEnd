package com.example.entrenate.service;

import com.example.entrenate.model.Cursos;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface CursoService extends UserDetailsService {

    List<Cursos> getAllCursos();
    Cursos saveCurso(Cursos curso);
    Cursos updateCurso(Cursos curso);
    void deleteCursotById(Integer id);
    Cursos getCursoById(Integer id);

}