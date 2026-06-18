package com.biblioteca.ms_prestamos.controller;

import com.biblioteca.ms_prestamos.model.Prestamo;
import com.biblioteca.ms_prestamos.service.PrestamoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prestamos")
public class PrestamoController {

    private PrestamoService service;

    public PrestamoController(PrestamoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Prestamo> listarPrestamos() {
        return service.obtenerPrestamos();
    }

    @GetMapping("/{id}")
    public Prestamo obtenerPrestamo(@PathVariable Long id) {
        return service.obtenerPrestamoPorId(id);
    }

    @PostMapping
    public Prestamo guardarPrestamo(@RequestBody Prestamo prestamo) {
        return service.guardarPrestamo(prestamo);
    }

    @PutMapping("/{id}")
    public Prestamo actualizarPrestamo(@PathVariable Long id,
                                       @RequestBody Prestamo prestamo) {
        return service.actualizarPrestamo(id, prestamo);
    }

    @DeleteMapping("/{id}")
    public void eliminarPrestamo(@PathVariable Long id) {
        service.eliminarPrestamo(id);
    }
}