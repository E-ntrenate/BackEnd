package com.example.entrenate.repository;

import com.example.entrenate.model.usuario.Rol;
import com.example.entrenate.model.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByNickname(String username);

    List<Usuario> findByRoles(Rol rol);
}
