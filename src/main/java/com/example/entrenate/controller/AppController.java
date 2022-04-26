package com.example.entrenate.controller;

import com.example.entrenate.model.Usuario;
import com.example.entrenate.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {
    @Autowired
    private UsuarioRepository usuarioRepo;
    @GetMapping("/")
    public String loadIndex(){
        return "index";
    }
    @GetMapping("/login")
    public String loadLogin(){
        return "FormLogin";
    }
    @GetMapping("/register")
    public String loadRegister(Model model){
        model.addAttribute("usuario", new Usuario());

        return "FormRegister";
    }
    @GetMapping("/usuarios")
    public String viewUsers(){
        return "BuscadorUsuarios";
    }
    @PostMapping("/process_register")
    public String processRegister(Usuario usuario){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(usuario.getPassword());
        usuario.setPassword(encodedPassword);

        usuarioRepo.save(usuario);

        return "registroExitoso";
    }
}
