package com.example.entrenate.service;

import com.example.entrenate.model.Rol;
import com.example.entrenate.model.Usuario;
import com.example.entrenate.repository.UsuarioRepository;
import com.example.entrenate.web.dto.UsuarioRegistroDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    //Recibe los datos del cliente por el DTO y los persiste en la Base de Datos.
    @Override
    public Usuario save(UsuarioRegistroDto registroDto) {
        Usuario usuario = new Usuario(
                registroDto.getNombre(),
                registroDto.getApellido(),
                registroDto.getNickname(),
                registroDto.getDocumento(),
                registroDto.getCorreo(),
                encoder.encode(registroDto.getPassword()),
                registroDto.getEdad(),
                registroDto.getCiudad(),
                registroDto.getNumeroIdentidad(),
                registroDto.getTipoIdentidad(),
                registroDto.getFechaNacimiento(),
                Arrays.asList(new Rol("ROL_USUARIO"))
        );
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    public void eliminar(Integer id) {
        Authentication usuario = SecurityContextHolder.getContext().getAuthentication();
        usuario.getAuthorities();
        usuarioRepository.deleteById(id);

    }

    @Override
    public Usuario updateUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario getUsuarioById(Integer id) {
        return usuarioRepository.findById(id).get();
    }


    //Obtiene el usuario por el nickname dado.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByNickname(username);

        if (usuario == null){
            throw new UsernameNotFoundException("Usuario o contraseña inválidos.");
        }

        return new User(
                usuario.getNickname(),
                usuario.getPassword(),
                mapRolesToAuthorities(usuario.getRoles()));
    }

    //Mapea los roles del usuario a permisos.
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Rol> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
    }
}