package com.example.entrenate.auth;

import com.example.entrenate.model.usuario.Rol;
import com.example.entrenate.model.usuario.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class UsuarioPrincipal implements UserDetails {

    final private Usuario usuario;

    public UsuarioPrincipal(final Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Rol> roles = usuario.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Rol rol : roles) {
            authorities.add(new SimpleGrantedAuthority(rol.getNombre()));
        }

        return authorities;
    }

    @Override
    public String getPassword() {
        return usuario.getPassword();
    }

    @Override
    public String getUsername() {
        return usuario.getNickname();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
