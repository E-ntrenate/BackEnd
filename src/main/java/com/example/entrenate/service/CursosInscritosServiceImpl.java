package com.example.entrenate.service;

import com.example.entrenate.model.Cursos_Inscritos;
import com.example.entrenate.repository.CursosInscritosRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursosInscritosServiceImpl implements CursosInscritosService{

    private CursosInscritosRepository cursosInscritosRepository;

    public CursosInscritosServiceImpl(CursosInscritosRepository cursosInscritosRepository) {
        this.cursosInscritosRepository = cursosInscritosRepository;
    }

    @Override
    public List<Cursos_Inscritos> getAllCursosInscritos() {
        return cursosInscritosRepository.findAll();
    }

    @Override
    public Cursos_Inscritos saveCurso(Cursos_Inscritos cursos_inscritos) {
        return cursosInscritosRepository.save(cursos_inscritos);
    }

    @Override
    public Cursos_Inscritos updateCurso(Cursos_Inscritos cursos_inscritos) {
        return cursosInscritosRepository.save(cursos_inscritos);
    }

    @Override
    public void deleteCursotById(Integer id) {
        cursosInscritosRepository.deleteById(id);
    }

    @Override
    public Cursos_Inscritos getCursoById(Integer id) {
        return cursosInscritosRepository.findById(id).get();
    }
    //me metio esta porqueria a la fuerza
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
