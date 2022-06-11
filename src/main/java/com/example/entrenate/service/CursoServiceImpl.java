package com.example.entrenate.service;

import com.example.entrenate.model.Cursos;
import com.example.entrenate.repository.CursoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService{

    private final CursoRepository cursoRepository;

    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public List<Cursos> getAllCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public Cursos saveCurso(Cursos curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public Cursos getCursoById(Integer id) {
        return cursoRepository.findById(id).get();
    }

    @Override
    public Cursos updateCurso(Cursos curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public void deleteCursotById(Integer id) {
        cursoRepository.deleteById(id);
    }
    //me metio esta porqueria a la fuerza
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}