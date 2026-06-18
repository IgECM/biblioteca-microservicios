package com.biblioteca.ms_devoluciones.model;

import jakarta.persistence.*;

@Entity
@Table(name = "devoluciones")
public class Devolucion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long prestamoId;

    private String fechaDevolucion;

    public Devolucion() {
    }

    public Devolucion(Long id, Long prestamoId, String fechaDevolucion) {
        this.id = id;
        this.prestamoId = prestamoId;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Long getId() {
        return id;
    }

    public Long getPrestamoId() {
        return prestamoId;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrestamoId(Long prestamoId) {
        this.prestamoId = prestamoId;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}