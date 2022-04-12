package com.example.entrenate.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;


@Entity
@Table
public class Usuario {
    @Id
    @GeneratedValue(strategy  =GenerationType.IDENTITY)
    private Long id_usuario;
    private String Nombre_usuario;
    private  Long Documento;
    private String Correo;
    private  String Contraseña;
    private Long Edad;
    private String Ciudad;
    private Long Numero_identidad;
    private String Tipo_documento;
    private Date Fecha_nacimiento;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "usuario_id", referencedColumnName = "id_usuario"),
            inverseJoinColumns = @JoinColumn(
                    name = "rol_id", referencedColumnName = "id_rol"))



    private Collection< Rol > roles;
/*

 */




    public Usuario() {
    }

    public Usuario(String nombre_usuario, Long documento, String correo, String contraseña, Long edad, String ciudad, Long numero_identidad, String tipo_documento, Date fecha_nacimiento, Collection<Rol> roles) {

        this.Nombre_usuario = nombre_usuario;
        this.Documento = documento;
        this.Correo = correo;
        this.Contraseña = contraseña;
        this.Edad = edad;
        this.Ciudad = ciudad;
        this.Numero_identidad = numero_identidad;
        this.Tipo_documento = tipo_documento;
        this.Fecha_nacimiento = fecha_nacimiento;
        this.roles = roles;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return Nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        Nombre_usuario = nombre_usuario;
    }

    public Long getDocumento() {
        return Documento;
    }

    public void setDocumento(Long documento) {
        Documento = documento;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }

    public Long getEdad() {
        return Edad;
    }

    public void setEdad(Long edad) {
        Edad = edad;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }

    public Long getNumero_identidad() {
        return Numero_identidad;
    }

    public void setNumero_identidad(Long numero_identidad) {
        Numero_identidad = numero_identidad;
    }

    public String getTipo_documento() {
        return Tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        Tipo_documento = tipo_documento;
    }

    public Date getFecha_nacimiento() {
        return Fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        Fecha_nacimiento = fecha_nacimiento;
    }
}
