package com.example.entrenate.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Controller
@RequestMapping("/test")
public class TestController {

    @GetMapping("inscrito")
    public String cursoInscrito(){
        return "Curso-Inscrito";
    }

    @GetMapping("noinscrito")
    public String cursoNoInscrito(){
        return "Curso-Noinscrito";
    }

    @GetMapping("buscar/cursos")
    public String buscacursos(){
        return "BuscadorCursos";
    }
}
