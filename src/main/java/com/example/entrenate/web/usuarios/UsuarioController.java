package com.example.entrenate.web.usuarios;

import com.example.entrenate.auth.UsuarioPrincipal;
import com.example.entrenate.auth.UsuarioService;
import com.example.entrenate.model.usuario.Usuario;
import com.example.entrenate.repository.UsuarioRepository;
import com.example.entrenate.web.dto.UsuarioRegistroDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
@RequestMapping
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioController(final UsuarioService usuarioService, final UsuarioRepository usuarioRepository) {
        this.usuarioService = usuarioService;
        this.usuarioRepository = usuarioRepository;
    }

    @ModelAttribute("usuario")
    public UsuarioRegistroDto usuarioRegistroDto(@AuthenticationPrincipal UsuarioPrincipal usuarioPrincipal) {

        Usuario usuario = usuarioRepository.findByNickname(usuarioPrincipal.getUsername());

        return new UsuarioRegistroDto(
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getNickname(),
                usuario.getDocumento(),
                usuario.getCorreo(),
                usuario.getPassword(),
                usuario.getEdad(),
                usuario.getCiudad(),
                usuario.getNumeroIdentidad(),
                usuario.getTipoIdentidad(),
                usuario.getFechaNacimiento(),
                usuario.getFotoPerfil()
        );
    }

    @GetMapping("/perfil")
    public String mostrarPerfil(){
        return "principal/Perfil";
    }

    @PostMapping
    public String registrarCuentaUsuario(@Valid @ModelAttribute("usuario") UsuarioRegistroDto registroDto,
                                         BindingResult bindingResult,
                                         @RequestParam("archivo") MultipartFile archivo,
                                         @RequestParam("fechaNacimiento") String fechaNacimiento) throws IOException {
        
        LocalDate nacimiento = LocalDate.parse(fechaNacimiento);
        LocalDate today = LocalDate.now();
        byte edad = (byte) Period.between(nacimiento, today).getYears();

        byte[] documento = archivo.getBytes();

        if (edad < 12 || edad > 100) {
            return "redirect:/perfil?error";
        }

        registroDto.setFechaNacimiento(nacimiento);
        registroDto.setEdad(edad);
        registroDto.setDocumento(documento);

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            return "redirect:/perfil?error";
        } else {
            return "redirect:/perfil?success";
        }
    }

}