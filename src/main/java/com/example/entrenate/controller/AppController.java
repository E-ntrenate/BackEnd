package com.example.entrenate.controller;

import com.example.entrenate.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @GetMapping("/")
    public String loadLogin(){
        return "FormLogin";
    }

    @GetMapping("/register")
    public String loadRegister(){
        return "FormRegister";
    }
}
