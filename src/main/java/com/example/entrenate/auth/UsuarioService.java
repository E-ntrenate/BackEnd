package com.example.entrenate.auth;

import com.example.entrenate.model.Usuario;
import com.example.entrenate.web.dto.UsuarioRegistroDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UsuarioService extends UserDetailsService {
    Usuario save(UsuarioRegistroDto registroDto);
    List<Usuario> listarUsuarios();
    void eliminar(Integer id);
    Usuario getUsuarioById(Integer id);
    Usuario updateUsuario(Usuario Usuario);
}