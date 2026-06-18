package com.biblioteca.ms_libros.controller;

import com.biblioteca.ms_libros.model.Libro;
import com.biblioteca.ms_libros.service.LibroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {

    private LibroService service;

    public LibroController(LibroService service) {
        this.service = service;
    }

    @GetMapping
    public List<Libro> listarLibros() {
        return service.obtenerLibros();
    }

    @GetMapping("/{id}")
    public Libro obtenerLibro(@PathVariable Long id) {
        return service.obtenerLibroPorId(id);
    }

    @PostMapping
    public Libro guardarLibro(@RequestBody Libro libro) {
        return service.guardarLibro(libro);
    }

    @PutMapping("/{id}")
    public Libro actualizarLibro(@PathVariable Long id,
                                 @RequestBody Libro libro) {
        return service.actualizarLibro(id, libro);
    }

    @DeleteMapping("/{id}")
    public void eliminarLibro(@PathVariable Long id) {
        service.eliminarLibro(id);
    }
}