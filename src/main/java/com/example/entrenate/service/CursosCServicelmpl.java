package com.example.entrenate.service;

import com.example.entrenate.model.curso.Compra;
import com.example.entrenate.model.curso.Curso;
import com.example.entrenate.model.curso.CursosC;
import com.example.entrenate.repository.CursoRepository;
import com.example.entrenate.repository.CursosCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class CursosCServicelmpl implements CursosCService {
    @Autowired
    private CursosCRepository cursosCRepository;
    @Autowired
    private CursoRepository cursoRepository;
    public CursosCServicelmpl(CursosCRepository  cursosCRepository) {
        super();
        this.cursosCRepository = cursosCRepository;
    }
    @Override
    public CursosC comprar(Long id_Cursos) {
        Authentication usuario = SecurityContextHolder.getContext().getAuthentication();
        usuario.getAuthorities();
        String id_Usuario = usuario.getName();
        CursosC cursoC = new CursosC(id_Cursos,id_Usuario);
        return cursosCRepository.save(cursoC);

    }

    @Override
    public void eliminar(Long id) {
        Authentication usuario = SecurityContextHolder.getContext().getAuthentication();
        usuario.getAuthorities();
        cursosCRepository.deleteById(id);

    }

    @Override
    public Curso buscarPorId(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Compra> listarCursosC() {
        ArrayList<CursosC> cursosComp = (ArrayList<CursosC>) cursosCRepository.findAll();
        System.out.println(cursosComp.size());
        List<Compra> aux = new ArrayList<>();
        Authentication usuario = SecurityContextHolder.getContext().getAuthentication();
        String id_Usuario = usuario.getName();

        for(int i = 0; i < cursosComp.size(); i++){
            if (cursosComp.get(i).getId_Usuario().equals(id_Usuario)){
                CursosC auxJC = cursosComp.get(i);
                Curso auxJ = buscarPorId(auxJC.getId_Curso());
                Compra auxC = new Compra(auxJC.getId_CursosC(), auxJ.getId(), auxJ.getNombre(), auxJ.getCategoria(), auxJ.getFecha(),auxJ.getUrlTrailer());

                aux.add(auxC);
            }
        }

        return aux;
    }




}
