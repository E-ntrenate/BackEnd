package com.example.entrenate.service;

import com.example.entrenate.model.curso.Curso;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface CursoService extends UserDetailsService {

    List<Curso> getAllCursos();
    Curso saveCurso(Curso curso);
    Curso updateCurso(Curso curso);
    void deleteCursotById(Integer id);
    Curso getCursoById(Integer id);

}