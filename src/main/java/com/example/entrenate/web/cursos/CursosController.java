package com.example.entrenate.web.cursos;

import com.example.entrenate.model.curso.Curso;
import com.example.entrenate.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CursosController {

    @Autowired
    private CursoService cursoService;

    public CursosController(CursoService cursoService) {
        this.cursoService = cursoService;
    }
    @GetMapping("/cursos/{id}")
    public String deleteCurso(@PathVariable("id") Integer id){
        cursoService.deleteCursotById(id);
        return "redirect:/cursos";
    }
    @GetMapping("/cursos")
    public String listCursos(Model model){
        model.addAttribute("cursos", cursoService.getAllCursos());
        return "redirect:/";
    }

    @GetMapping("/cursos/edit/{id}")
    public String editCursoForm(@PathVariable Integer id, Model model) {
        model.addAttribute("curso", cursoService.getCursoById(id));
        return "editarCurso";
    }

    @PostMapping("/cursos/{id}")
    public String updateCurso(@PathVariable("id") Integer id, @ModelAttribute("cursos") Curso curso, Model model){
        Curso existingCurso = cursoService.getCursoById(id);
        existingCurso.setNombre(curso.getNombre());
        existingCurso.setDesc(curso.getDesc());
        existingCurso.setTutor(curso.getTutor());
        existingCurso.setFecha(curso.getFecha());

        // save updated curso object
        cursoService.updateCurso(existingCurso);
        return "redirect:/";
    }

}
