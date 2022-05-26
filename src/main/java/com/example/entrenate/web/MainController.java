package com.example.entrenate.web;

import com.example.entrenate.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@CrossOrigin
@Controller
public class MainController {
    @GetMapping("/")
    public String loadRoot(){
        return "landing-page";
    }
    @GetMapping("/login")
    public String login(){
        return "FormLogin";
    }

}
