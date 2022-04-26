package com.example.entrenate.service;

import com.example.entrenate.model.Usuario;
import com.example.entrenate.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUsuarioDetailsService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepo.findByNickname(username);
        if (usuario == null){
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return new CustomUsuarioDetails(usuario);
    }
}
