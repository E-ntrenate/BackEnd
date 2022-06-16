package com.example.entrenate.model.usuario;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @Length(min = 3, max = 50)
    private String nombre;

    private String apellido;

    @Column(nullable = false, unique = true)
    @Length(min = 4)
    private String nickname;

    @Lob
    private MultipartFile documento;

    @Column(nullable = false, unique = true)
    @Email
    private String correo;

    @Column(nullable = false, unique = true, length = 64)
    @Length(min = 8)
    private String password;

    @Column(nullable = false)
    @Min(value = 12)
    @Max(value = 100)
    private byte edad;

    @Column(nullable = false)
    @Length(min = 3)
    private String ciudad;

    @Column(nullable = false, unique = true)
    @Length(min = 8, max = 12)
    private long numeroIdentidad;

    private String tipoIdentidad;

    @Column(nullable = false)
    private String fechaNacimiento;

    @Lob
    private MultipartFile fotoPerfil;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "usuario_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "rol_id", referencedColumnName = "id"))
    private Collection<Rol> roles;

    //Constructor sin Id.
    public Usuario(String nombre, String apellido, String nickname, MultipartFile documento, String correo, String password, byte edad, String ciudad, long numeroIdentidad, String tipoIdentidad, String fechaNacimiento, Collection<Rol> roles) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nickname = nickname;
        this.documento = documento;
        this.correo = correo;
        this.password = password;
        this.edad = edad;
        this.ciudad = ciudad;
        this.numeroIdentidad = numeroIdentidad;
        this.tipoIdentidad = tipoIdentidad;
        this.fechaNacimiento = fechaNacimiento;
        this.roles = roles;
    }
}
