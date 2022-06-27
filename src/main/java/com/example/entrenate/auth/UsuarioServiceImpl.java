package com.example.entrenate.auth;

import com.example.entrenate.model.usuario.Rol;
import com.example.entrenate.model.usuario.Usuario;
import com.example.entrenate.repository.RolRepository;
import com.example.entrenate.repository.UsuarioRepository;
import com.example.entrenate.web.dto.UsuarioRegistroDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    //INYECCIÓN DE DEPENDENCIAS//
    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, final RolRepository rolRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //Obtiene el usuario por el nickname dado.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByNickname(username);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario o contraseña inválidos.");
        }

        return new UsuarioPrincipal(usuario);
    }

    //Recibe los datos del cliente por el DTO y los persiste en la Base de Datos.
    @Override
    public Usuario saveWithRole(UsuarioRegistroDto registroDto, String rol) {

        Rol rolUsuario = rolRepository.findByNombre(rol);

        Usuario usuario = new Usuario(
                registroDto.getNombre(),
                registroDto.getApellido(),
                registroDto.getNickname(),
                registroDto.getDocumento(),
                registroDto.getCorreo(),
                passwordEncoder.encode(registroDto.getPassword()),
                registroDto.getEdad(),
                registroDto.getCiudad(),
                registroDto.getNumeroIdentidad(),
                registroDto.getTipoIdentidad(),
                registroDto.getFechaNacimiento());

        usuario.agregarRol(rolUsuario);

        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public void eliminar(Long id) {
        Authentication usuario = SecurityContextHolder.getContext().getAuthentication();
        usuario.getAuthorities();
        usuarioRepository.deleteById(id);

    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id).get();
    }
}