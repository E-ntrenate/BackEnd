package com.example.entrenate.model;

import lombok.*;

import javax.persistence.*;
import java.io.File;
import java.util.Collection;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre;

    private String apellido;

    @Column(nullable = false, unique = true)
    private String nickname;

    private File documento;

    @Column(nullable = false, unique = true)
    private String correo;

    @Column(nullable = false, unique = true, length = 64)
    private String password;

    @Column(nullable = false)
    private byte edad;

    @Column(nullable = false)
    private String ciudad;

    @Column(nullable = false, unique = true)
    private long numeroIdentidad;

    private String tipoIdentidad;

    @Column(nullable = false)
    private String fechaNacimiento;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "usuario_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "rol_id", referencedColumnName = "id"))
    private Collection<Rol> roles;

    //Constructor sin Id.
    public Usuario(String nombre, String apellido, String nickname, File documento, String correo, String password, byte edad, String ciudad, long numeroIdentidad, String tipoIdentidad, String fechaNacimiento, Collection<Rol> roles) {
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
