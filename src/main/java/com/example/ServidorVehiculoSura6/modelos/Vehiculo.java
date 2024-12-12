package com.example.ServidorVehiculoSura6.modelos;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


@Entity
@Table(name = "vehiculos")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    private String placa;

    @Column(nullable = false, length = 4)
    private String modelo;

    @Column(nullable = false, length = 20)
    private String marca;

    @Column(nullable = false, length = 4)
    private String cilindraje;

    @Column(nullable = false, length = 20)
    private String color;

    @Column(length = 255)
    private String descripcion;

    @Column(name = "numero_siniestros")
    private Integer numeroSiniestro;
    private Boolean activo;

    //
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id")
    private Usuario usuario;

    // Constructor sin parámetros (requerido por JPA)
    public Vehiculo() {
    }

    // Constructor con todos los parámetros

    public Vehiculo(Long id, String placa, String modelo, String marca, String cilindraje, String color, String descripcion, Integer numeroSiniestro, Boolean activo) {
        this.id = id;
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.cilindraje = cilindraje;
        this.color = color;
        this.descripcion = descripcion;
        this.numeroSiniestro = numeroSiniestro;
        this.activo = activo;
    }


    // Encapsulamiento

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getNumeroSiniestro() {
        return numeroSiniestro;
    }

    public void setNumeroSiniestro(Integer numeroSiniestro) {
        this.numeroSiniestro = numeroSiniestro;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}