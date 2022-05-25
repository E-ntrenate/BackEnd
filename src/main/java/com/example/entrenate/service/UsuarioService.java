package com.example.entrenate.service;

import com.example.entrenate.model.Usuario;
import com.example.entrenate.web.dto.UsuarioRegistroDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UsuarioService extends UserDetailsService {
    Usuario save(UsuarioRegistroDto registroDto);
    public List<Usuario> listarUsuarios();
    public void eliminar(Integer id);
    Usuario getUsuarioById(Integer id);
    Usuario updateUsuario(Usuario Usuario);
}