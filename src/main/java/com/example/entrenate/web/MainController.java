package com.example.entrenate.web;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@Controller
public class MainController {
    @GetMapping("/")
    public String landing(){
        return "principal/landing";
    }

    @GetMapping("/login")
    public String login(){
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //Si ya está autenticado, se redirige a la página principal.
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "principal/login";
        }

        return "redirect:/";
    }

    @GetMapping("/home")
    public String home(){
        return "principal/Home";
    }

    @GetMapping("/buscadorusuarios")
    public String buscadorusuarios(){
        return "BuscadorUsuarios";
    }

}
