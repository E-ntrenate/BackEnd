package com.example.entrenate.service;

import com.example.entrenate.model.curso.Curso;
import com.example.entrenate.model.curso.CursosC;
import com.example.entrenate.repository.CursoRepository;
import com.example.entrenate.repository.CursosCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

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
    public CursosC comprar(Long id_Juego) {
        Authentication usuario = SecurityContextHolder.getContext().getAuthentication();
        usuario.getAuthorities();
        String id_Usuario = usuario.getName();
        CursosC juego = new CursosC(id_Juego,id_Usuario);
        return cursosCRepository.save(juego);

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
    public Long Mas_comprado() {
        List<Long> aux = cursosCRepository.findByMas_comprado().stream().map(CursosC::getId_Curso).collect(Collectors.toList());
        HashMap<Long, Integer> mapa = new HashMap<>();
        for (int x = 0; x < aux.size(); x++) {
            Long numero = aux.get(x);
            if (mapa.containsKey(numero)) {
                mapa.put(numero, mapa.get(numero) + 1);
            } else {
                mapa.put(numero, 1);
            }
        }
        int mayor = 0;
        Long moda = null;
        for (HashMap.Entry<Long, Integer> entry : mapa.entrySet()) {
            if (entry.getValue() > mayor) {
                mayor = entry.getValue();
                moda = entry.getKey();
            }
        }
        return moda;
    }
}
