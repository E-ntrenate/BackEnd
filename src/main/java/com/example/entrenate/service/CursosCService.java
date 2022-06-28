package com.example.entrenate.service;

import com.example.entrenate.model.curso.Curso;
import com.example.entrenate.model.curso.CursosC;

public interface CursosCService {
    public  CursosC comprar(Long id_Juego);
    public void eliminar(Long id);
    public Curso buscarPorId(Long id);
   // public List<Compra> listarJuegosC();
    public Long Mas_comprado();
}


