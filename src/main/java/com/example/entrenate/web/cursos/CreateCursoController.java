package com.example.entrenate.web.cursos;

import com.example.entrenate.model.usuario.Rol;
import com.example.entrenate.model.usuario.Usuario;
import com.example.entrenate.repository.RolRepository;
import com.example.entrenate.repository.UsuarioRepository;
import com.example.entrenate.service.CursoService;
import com.example.entrenate.web.dto.CursoRegistroDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/admin/cursos/crear")
public class CreateCursoController {
    private final CursoService cursoService;
    private final UsuarioRepository usuarioRepository;

    private final RolRepository rolRepository;

    public CreateCursoController(final CursoService cursoService, final UsuarioRepository usuarioRepository, final RolRepository rolRepository) {
        this.cursoService = cursoService;
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
    }

    @ModelAttribute("curso")
    public CursoRegistroDto cursoRegistroDto(){
        return new CursoRegistroDto();
    }

    @GetMapping
    public String mostrarFormularioRegistro(Model model){
        /*Rol rol = rolRepository.findByNombre("ADMIN");
        List<Usuario> tutores = usuarioRepository.findByRoles(rol);
        model.addAttribute("tutores", tutores);

         */

        return "cursos/FormRegistrarCurso";
    }

    @PostMapping
    public String crearCurso(/*@Valid */ @ModelAttribute CursoRegistroDto curso){
                             /*BindingResult bindingResult,
                             @RequestParam("photo")MultipartFile photoFile,
                             @RequestParam("frontImg")MultipartFile frontFile,
                             @RequestParam("backImg")MultipartFile backFile) throws IOException {

        curso.setPhoto(photoFile.getBytes());
        curso.setFrontImg(frontFile.getBytes());
        curso.setFrontImg(backFile.getBytes());

                              */

        cursoService.save(curso);
        return "redirect:/admin/cursos/crear?success";
/*
        if (bindingResult.hasErrors()){
            return "redirect:/admin/cursos/crear?error";
        } else {
            return "redirect:/admin/cursos/crear?success";
        }

 */
    }

}
