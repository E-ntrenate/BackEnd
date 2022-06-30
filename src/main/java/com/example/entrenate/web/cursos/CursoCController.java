package com.example.entrenate.web.cursos;

import com.example.entrenate.model.curso.Compra;
import com.example.entrenate.model.curso.Curso;
import com.example.entrenate.repository.CursoRepository;
import com.example.entrenate.service.CursoService;
import com.example.entrenate.service.CursosCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping
public class CursoCController {

    private CursoService cursoService;

    private CursoRepository cursoRepository;
    private CursosCService cursosCService;
    @Autowired
    public CursoCController(CursoService cursoService, CursoRepository cursoRepository, CursosCService cursosCService) {
        this.cursoService = cursoService;
        this.cursoRepository = cursoRepository;
        this.cursosCService = cursosCService;
    }

    @ModelAttribute("cursos")
    public List<Curso> Cargarcursos(){

        return cursoRepository.findAll();

    }
    /*@ModelAttribute("Home")
    public List<Compra> CargarcursosC(){
        List<Compra> milista = cursosCService.listarCursosC();
        //System.out.println(milista.get(0).getNombre_curso());
        return milista;
    }

     */
    @GetMapping("/cursos")
    public String listarCursos(Model model) {
        return "cursos";
    }
    @GetMapping ("/buy/{id}")
    public String comprar(@PathVariable("id") Long id_Cursos){
        cursosCService.comprar(id_Cursos);
        return "redirect:/cursos";
    }
    @GetMapping ("/home")
    public String listarJuegosC(Model model){
        List<Compra> listadoJuegosC = cursosCService.listarCursosC();
        model.addAttribute("Home", listadoJuegosC);

        return "principal/Home";
    }

}
