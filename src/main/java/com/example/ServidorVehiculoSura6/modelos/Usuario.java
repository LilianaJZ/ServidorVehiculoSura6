package com.example.ServidorVehiculoSura6.modelos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 20)
    private String contrasena;

    @Column(length = 20)
    private String telefono;

    @Column(nullable = false, length = 50)
    private String cedula;

    @Column(nullable = false, length = 50)
    private String correo;

    private LocalDate fecha_nacimiento;

    private Boolean activo;

    //Las relaciones serán nuevos atributos
    @OneToMany(mappedBy = "usuario")
    @JsonManagedReference
    private List<Vehiculo> vehiculos;

    //constructor vacío
    public Usuario() {
    }
    //constructores

    public Usuario(Long id, String nombre, String contrasena, String telefono, String cedula, String correo, LocalDate fecha_nacimiento, Boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.cedula = cedula;
        this.correo = correo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.activo = activo;
    }


    //encapsulamiento


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}