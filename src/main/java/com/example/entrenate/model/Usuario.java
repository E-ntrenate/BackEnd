package com.example.entrenate.model;

import javax.persistence.*;
import java.io.File;
import java.util.Collection;
import java.util.Date;


@Entity
@Table
public class Usuario {
    @Id
    @GeneratedValue(strategy  =GenerationType.IDENTITY)
    private Long idUsuario;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String nickname;
    private File documento;
    private String correo;
    private String password;
    private Long edad;
    private String ciudad;
    private Long numeroIdentidad;
    private String tipoIdentidad;
    private Date fechaNacimiento;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "usuario_id", referencedColumnName = "idUsuario"),
            inverseJoinColumns = @JoinColumn(
                    name = "rol_id", referencedColumnName = "id_rol"))
    private Collection< Rol > roles;

    public Usuario() {
    }

    public Usuario(Long idUsuario, String nombreUsuario, String apellidoUsuario, String nickname, File documento, String correo, String password, Long edad, String ciudad, Long numeroIdentidad, String tipoIdentidad, Date fechaNacimiento, Collection<Rol> roles) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
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

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public File getDocumento() {
        return documento;
    }

    public void setDocumento(File documento) {
        this.documento = documento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getEdad() {
        return edad;
    }

    public void setEdad(Long edad) {
        this.edad = edad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Long getNumeroIdentidad() {
        return numeroIdentidad;
    }

    public void setNumeroIdentidad(Long numeroIdentidad) {
        this.numeroIdentidad = numeroIdentidad;
    }

    public String getTipoIdentidad() {
        return tipoIdentidad;
    }

    public void setTipoIdentidad(String tipoIdentidad) {
        this.tipoIdentidad = tipoIdentidad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Collection<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Rol> roles) {
        this.roles = roles;
    }
}
