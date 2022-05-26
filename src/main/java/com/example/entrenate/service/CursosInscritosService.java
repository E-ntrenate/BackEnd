package com.example.entrenate.service;

import com.example.entrenate.model.Cursos_Inscritos;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface CursosInscritosService extends UserDetailsService {

    List<Cursos_Inscritos> getAllCursosInscritos();
    Cursos_Inscritos saveCurso(Cursos_Inscritos cursos_inscritos);
    Cursos_Inscritos updateCurso(Cursos_Inscritos cursos_inscritos);
    void deleteCursotById(Integer id);
    Cursos_Inscritos getCursoById(Integer id);

}
