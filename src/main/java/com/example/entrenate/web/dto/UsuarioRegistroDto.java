package com.example.entrenate.web.dto;

import org.springframework.web.multipart.MultipartFile;

public class UsuarioRegistroDto {
    private String nombre;
    private String apellido;
    private String nickname;
    private MultipartFile documento;
    private String correo;
    private String password;
    private byte edad;
    private String ciudad;
    private long numeroIdentidad;
    private String tipoIdentidad;
    private String fechaNacimiento;
    private MultipartFile fotoPerfil;

    public UsuarioRegistroDto() {

    }

    public UsuarioRegistroDto(String nombre, String apellido, String nickname, MultipartFile documento, String correo, String password, byte edad, String ciudad, long numeroIdentidad, String tipoIdentidad, String fechaNacimiento, MultipartFile fotoPerfil) {
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
        this.fotoPerfil = fotoPerfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public MultipartFile getDocumento() {
        return documento;
    }

    public void setDocumento(MultipartFile documento) {
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

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public long getNumeroIdentidad() {
        return numeroIdentidad;
    }

    public void setNumeroIdentidad(long numeroIdentidad) {
        this.numeroIdentidad = numeroIdentidad;
    }

    public String getTipoIdentidad() {
        return tipoIdentidad;
    }

    public void setTipoIdentidad(String tipoIdentidad) {
        this.tipoIdentidad = tipoIdentidad;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public MultipartFile getFotoPerfil() {
        return this.fotoPerfil;
    }

    public void setFotoPerfil(final MultipartFile fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }
}
