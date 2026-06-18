package com.biblioteca.ms_prestamos.dto;

public class UsuarioDTO {

    private Long id;
    private String nombre;
    private String correo;


    // Constructor vacio para el spring
    public UsuarioDTO() {
    }


    // constructor para los tests (los q estan en test > service > PrestamoServiceTest.java)
    public UsuarioDTO(Long id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }


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


    public String getCorreo() {
        return correo;
    }


    public void setCorreo(String correo) {
        this.correo = correo;
    }
}