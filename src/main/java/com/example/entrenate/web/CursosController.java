package com.example.entrenate.web;

import com.example.entrenate.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CursosController {

    @Autowired
    private CursoService cursoService;

    public CursosController(CursoService cursoService) {
        super();
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
    public String editStudentForm(@PathVariable Integer id, Model model) {
        model.addAttribute("student", cursoService.getCursoById(id));
        return "editarCurso";
    }

}
