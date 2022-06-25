package com.example.entrenate.web.usuarios;

import com.example.entrenate.auth.UsuarioService;
import com.example.entrenate.web.dto.UsuarioRegistroDto;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;


@CrossOrigin
@Controller
@RequestMapping("/registro")
public class RegistrationController {
    private final UsuarioService usuarioService;

    public RegistrationController(UsuarioService usuarioService) {
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
            return "principal/registro";
        }
        return "redirect:/";
    }

    @PostMapping
    public String registrarCuentaUsuario(@Valid @ModelAttribute("usuario") UsuarioRegistroDto registroDto,
                                         BindingResult bindingResult,
                                         @RequestParam("archivo") MultipartFile archivo,
                                         @RequestParam("fechaNacimiento") String fechaNacimiento) throws IOException{

        LocalDate nacimiento = LocalDate.parse(fechaNacimiento);
        LocalDate today = LocalDate.now();
        byte edad = (byte) Period.between(nacimiento, today).getYears();

        byte[] documento = archivo.getBytes();

        if (edad < 12 || edad > 100){
            return "redirect:/registro?error";
        }

        registroDto.setFechaNacimiento(nacimiento);
        registroDto.setEdad(edad);
        registroDto.setDocumento(documento);
        usuarioService.save(registroDto);

        if (bindingResult.hasErrors()){
            System.out.println(bindingResult.getAllErrors());
            return "redirect:/registro?error";
        } else {
            return "redirect:/registro?success";
        }
    }
}
