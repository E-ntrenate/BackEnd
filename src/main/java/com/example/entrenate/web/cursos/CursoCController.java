package com.example.entrenate.web.cursos;

import com.example.entrenate.model.curso.Curso;
import com.example.entrenate.service.CursoService;
import com.example.entrenate.service.CursosCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/usuario/cursos/comprar")
public class CursoCController {
    @Autowired
    private CursoService cursoService;

    @Autowired
    private CursosCService cursosCService;

    @GetMapping
    public String listarJuegos(Model model) {
        Curso curso = cursoService.buscarPorId(cursosCService.Mas_comprado());
        List<Curso> ListadoCursos = cursoService.listarCursos();
        model.addAttribute("Titulo", "Lista de cursos");
        model.addAttribute("cursoMC", curso);
        model.addAttribute("cursos", ListadoCursos);
        return "principal/Home";
    }

}
