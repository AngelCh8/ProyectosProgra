package com.umg.banco.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double monto;
    private String tipo;
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "cuenta_id")
    private Cuenta cuenta;

    // Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Double getMonto() {
        return monto;
    }
    public void setMonto(Double monto) {
        this.monto = monto;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public LocalDateTime getFecha() {
        return fecha;
    }
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    public Cuenta getCuenta() {
        return cuenta;
    }
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
