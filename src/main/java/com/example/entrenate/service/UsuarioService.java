package com.example.entrenate.service;

import com.example.entrenate.model.Usuario;
import com.example.entrenate.web.dto.UsuarioRegistroDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsuarioService extends UserDetailsService {
    Usuario save(UsuarioRegistroDto registroDto);
}
