package com.example.entrenate.web;

import com.example.entrenate.model.Usuario;
import com.example.entrenate.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @GetMapping("/")
    public String listarUsuarios(Model model){

        List<Usuario> ListadoUsuarios = usuarioService.listarUsuarios();
        model.addAttribute("Titulo","Lista de Juegos");
        model.addAttribute("usuarios", ListadoUsuarios);
        return "/BuscadorUsuarios";
    }
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Integer id){
        usuarioService.eliminar(id);
        System.out.println("Registro Eliminado con Exito!");
        return "redirect:/";
    }



}
