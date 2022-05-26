package com.example.entrenate.web;

import com.example.entrenate.service.UsuarioService;
import com.example.entrenate.web.dto.UsuarioRegistroDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@Controller
@RequestMapping("/registro")
public class UsuarioRegistrationController {
    private UsuarioService usuarioService;

    public UsuarioRegistrationController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @ModelAttribute("usuario")
    public UsuarioRegistroDto usuarioRegistroDto(){
        return new UsuarioRegistroDto();
    }

    @GetMapping
    public String mostrarRegistrationForm(){
        return "FormRegister";
    }

    @PostMapping
    public String registrarCuentaUsuario(@ModelAttribute("usuario") UsuarioRegistroDto registroDto){
        usuarioService.save(registroDto);
        return "redirect:/registro?success";
    }
}
