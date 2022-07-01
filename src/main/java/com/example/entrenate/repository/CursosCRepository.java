package com.example.entrenate.repository;

import com.example.entrenate.model.curso.CursosC;
import com.example.entrenate.model.usuario.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursosCRepository extends CrudRepository<CursosC, Long> {
    List<CursosC> findAllByIdCurso(Long idCurso);


}