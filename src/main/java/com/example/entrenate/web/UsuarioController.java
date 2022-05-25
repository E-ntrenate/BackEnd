package com.example.entrenate.web;

import com.example.entrenate.model.Usuario;
import com.example.entrenate.service.CursoService;
import com.example.entrenate.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private CursoService cursoService;
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
        return "redirect:/cursos";
    }

    @GetMapping("/usuario/cursosInscritos/{id}")
    public String mostrarCursosInscritos(@PathVariable("id") Integer id, Model model){
        model.addAttribute("usuario", usuarioService.getUsuarioById(id));
        return "cursosInscritos";
    }

    @GetMapping("/usuario/cursos/{id}")
    public String deleteCurso(@PathVariable("id") Integer id){
        cursoService.deleteCursotById(id);
        return "redirect:/";
    }
    @GetMapping("/usuario/cursos")
    public String listCursos(Model model){
        model.addAttribute("cursos", cursoService.getAllCursos());
        return "listaCursos";
    }

    @GetMapping("/usuario/cursos/edit/{id}")
    public String editStudentForm(@PathVariable Integer id, Model model) {
        model.addAttribute("student", cursoService.getCursoById(id));
        return "editarCurso";
    }
    @GetMapping("/usuario/edit/{id}")
    public String editUsuarioForm(@PathVariable("id") Integer id, Model model){
        model.addAttribute("usuario", usuarioService.getUsuarioById(id));
        return "editarUsuario";
    }
    @PostMapping("/usuario/{id}")
    public String updateUsuario(@PathVariable("id") Integer id, @ModelAttribute("Usuario") Usuario usuario, Model model){
        Usuario existingUsuario = usuarioService.getUsuarioById(id);
        existingUsuario.setNombre(usuario.getNombre());
        existingUsuario.setApellido(usuario.getApellido());
        existingUsuario.setCorreo(usuario.getCorreo());
        existingUsuario.setCiudad(usuario.getCiudad());
        existingUsuario.setNickname(usuario.getNickname());

        // save updated usuario object
        usuarioService.updateUsuario(existingUsuario);
        return "redirect:/";
    }

}