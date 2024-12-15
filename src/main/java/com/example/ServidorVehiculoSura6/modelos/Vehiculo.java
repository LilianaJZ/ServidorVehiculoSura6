package com.example.ServidorVehiculoSura6.modelos;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


@Entity
@Table(name = "vehiculos")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 4)
    private String cilindraje;

    @Column(nullable = false, length = 20)
    private String color;

    @Column(nullable = false, length = 20)
    private String marca;

    @Column(nullable = false, length = 4)
    private String modelo;

    private Integer siniestros;

    @Column(nullable = false, length = 10)
    private String placa;

    @Column(length = 255)
    private String descripcion;
    @Column(length = 255)
    private String poliza;
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

    public Vehiculo(Long id, String cilindraje, String color, String marca, String modelo, Integer siniestros, String placa, String descripcion, String poliza, Boolean activo, Usuario usuario) {
        this.id = id;
        this.cilindraje = cilindraje;
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.siniestros = siniestros;
        this.placa = placa;
        this.descripcion = descripcion;
        this.poliza = poliza;
        this.activo = activo;
        this.usuario = usuario;
    }


    // Encapsulamiento


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getSiniestros() {
        return siniestros;
    }

    public void setSiniestros(Integer siniestros) {
        this.siniestros = siniestros;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPoliza() {
        return poliza;
    }

    public void setPoliza(String poliza) {
        this.poliza = poliza;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}