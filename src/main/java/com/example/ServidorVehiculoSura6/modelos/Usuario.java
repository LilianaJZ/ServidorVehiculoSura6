package com.example.ServidorVehiculoSura6.modelos;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "documento_usuario", nullable = false, length = 50)
    private String cedula;

    @Column(name = "nombre_usuario", nullable = false, length = 50)
    private String nombres;

    @Column(length = 20)
    private String telefono;

    @Column(name = "direccion_usuario", length = 100)
    private String direccion;

    @Column(name = "e_mail", nullable = false, length = 50)
    private String correo;

    @Column(name = "clave", nullable = false, length = 20)
    private String contrasena;
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
    private Boolean activo;

    //constructores
    public Usuario() {
    }

    public Usuario(Long id, String cedula, String nombres, String telefono, String direccion, String correo, String contrasena, LocalDate fechaNacimiento, Boolean activo) {
        this.id = id;
        this.cedula = cedula;
        this.nombres = nombres;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.contrasena = contrasena;
        this.fechaNacimiento = fechaNacimiento;
        this.activo = activo;
    }
    //encapsulamiento


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}