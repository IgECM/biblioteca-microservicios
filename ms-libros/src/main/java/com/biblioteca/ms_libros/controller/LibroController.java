package com.biblioteca.ms_libros.controller;

import com.biblioteca.ms_libros.dto.LibroRequestDTO;
import com.biblioteca.ms_libros.dto.LibroResponseDTO;
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
    public List<LibroResponseDTO> listarLibros() {
        return service.obtenerLibros();
    }

    @GetMapping("/{id}")
    public LibroResponseDTO obtenerLibro(@PathVariable Long id) {
        return service.obtenerLibroPorId(id);
    }

    @PostMapping
    public LibroResponseDTO guardarLibro(@RequestBody LibroRequestDTO libro) {
        return service.guardarLibro(libro);
    }

    @PutMapping("/{id}")
    public LibroResponseDTO actualizarLibro(@PathVariable Long id,
                                             @RequestBody LibroRequestDTO libro) {
        return service.actualizarLibro(id, libro);
    }

    @DeleteMapping("/{id}")
    public void eliminarLibro(@PathVariable Long id) {
        service.eliminarLibro(id);
    }
}