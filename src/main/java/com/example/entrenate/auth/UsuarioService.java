package com.example.entrenate.auth;

import com.example.entrenate.model.usuario.Usuario;
import com.example.entrenate.web.dto.UsuarioRegistroDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UsuarioService extends UserDetailsService {
    Usuario saveWithRole(UsuarioRegistroDto registroDto, String rol);
    List<Usuario> listarUsuarios();
    void eliminar(Long id);
    Usuario getUsuarioById(Long id);
    Usuario updateUsuario(Usuario Usuario);
}