package com.example.entrenate.web;

import com.example.entrenate.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @GetMapping("/login")
    public String login(){
        return "FormLogin";
    }
  /*
    @GetMapping("/")
    public String home(){

        return "index";
    }


    @GetMapping("/")
    public String listarUsuarios(Model model){

        List<Usuario> ListadoUsuarios = usuarioService.listarUsuarios();
        model.addAttribute("Titulo","Lista de Juegos");
        model.addAttribute("usuarios", ListadoUsuarios);
        return "BuscadorUsuarios";
    }

      */


}
