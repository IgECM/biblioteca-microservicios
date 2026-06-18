package com.biblioteca.ms_prestamos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "prestamos")
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long usuarioId;

    private Long libroId;

    private String fechaPrestamo;

    public Prestamo() {
    }

    public Prestamo(Long id, Long usuarioId, Long libroId, String fechaPrestamo) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.libroId = libroId;
        this.fechaPrestamo = fechaPrestamo;
    }

    public Long getId() {
        return id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public Long getLibroId() {
        return libroId;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void setLibroId(Long libroId) {
        this.libroId = libroId;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
}