package com.example.entrenate.service;

import com.example.entrenate.model.curso.Curso;
import com.example.entrenate.repository.CursoRepository;
import com.example.entrenate.web.dto.CursoRegistroDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
                cursoDto.getDesc(),
                cursoDto.getReseña(),
                cursoDto.getUrlTrailer(),
                cursoDto.getFecha(),
                cursoDto.getPrecio(),
                cursoDto.getDuracion(),
                cursoDto.getCategoria());


        return cursoRepository.save(curso);
    }
    @Override
    public Curso buscarPorId(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }


    @Override
    public List<Curso> listarCursos() {
        return (List<Curso>) cursoRepository.findAll();
    }
}
