package com.example.entrenate.model.usuario;

import com.example.entrenate.model.curso.Curso;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Length(min = 3, max = 50)
    private String nombre;

    private String apellido;

    @Column(nullable = false, unique = true)
    @Length(min = 4)
    private String nickname;

    @Lob
    private byte[] documento;

    @Column(nullable = false, unique = true)
    @Email
    private String correo;

    @Column(nullable = false, unique = true, length = 64)
    @Length(min = 8)
    private String password;

    @Column(nullable = false)
    @Range(min = 2, max = 100)
    private byte edad;

    @Column(nullable = false)
    @Length(min = 3)
    private String ciudad;

    @Column(nullable = false, unique = true)
    @Range(min = 10000000L, max = 999999999999L)
    private long numeroIdentidad;

    @Column(nullable = false)
    private String tipoIdentidad;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;

    @Lob
    private byte[] fotoPerfil;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "usuario_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "rol_id", referencedColumnName = "id"))
    private Set<Rol> roles = new HashSet<>();

    @OneToMany(mappedBy = "tutor")
    private Set<Curso> cursosTutora;

    public Usuario(final String nombre, final String apellido, final String nickname, final byte[] documento, final String correo, final String password, final byte edad, final String ciudad, final long numeroIdentidad, final String tipoIdentidad, final LocalDate fechaNacimiento) {
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
    }

    public void agregarRol(Rol rol){
        this.roles.add(rol);
    }
}
