package com.example.entrenate.repository;

import com.example.entrenate.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query("SELECT u FROM Usuario u WHERE u.nickname = ?1")
    public Usuario findByNickname(String username);
}
