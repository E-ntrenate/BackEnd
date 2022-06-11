package com.example.entrenate.web;

import com.example.entrenate.auth.UsuarioService;
import com.example.entrenate.web.dto.UsuarioRegistroDto;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@Controller
@RequestMapping("/registro")
public class UsuarioRegistrationController {
    private final UsuarioService usuarioService;

    public UsuarioRegistrationController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @ModelAttribute("usuario")
    public UsuarioRegistroDto usuarioRegistroDto(){
        return new UsuarioRegistroDto();
    }

    @GetMapping
    public String mostrarRegistrationForm(){
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "FormRegister";
        }
        return "redirect:/";
    }

    @PostMapping
    public String registrarCuentaUsuario(@ModelAttribute("usuario") UsuarioRegistroDto registroDto){
        usuarioService.save(registroDto);
        return "redirect:/registro?success";
    }
}
