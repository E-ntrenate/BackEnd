package com.example.entrenate.service;

import com.example.entrenate.model.curso.Curso;
import com.example.entrenate.repository.CursoRepository;
import com.example.entrenate.web.dto.CursoRegistroDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoServiceImpl implements CursoService{
    private final CursoRepository cursoRepository;

    @Autowired
    public CursoServiceImpl(final CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public Curso save(CursoRegistroDto cursoDto) {
        Curso curso = new Curso(
                cursoDto.getNombre(),
                cursoDto.getPhoto(),
                cursoDto.getDesc(),
                cursoDto.getReseña(),
                cursoDto.getUrlTrailer(),
                cursoDto.getFecha(),
                cursoDto.getPrecio(),
                cursoDto.getCategoria(),
                cursoDto.getFrontImg(),
                cursoDto.getBackImg(),
                cursoDto.getTutor());

        return cursoRepository.save(curso);
    }
}
