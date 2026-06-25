package com.biblioteca.ms_prestamos.controller;

import com.biblioteca.ms_prestamos.dto.PrestamoRequestDTO;
import com.biblioteca.ms_prestamos.dto.PrestamoResponseDTO;
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
    public List<PrestamoResponseDTO> listarPrestamos() {
        return service.obtenerPrestamos();
    }

    @GetMapping("/{id}")
    public PrestamoResponseDTO obtenerPrestamo(@PathVariable Long id) {
        return service.obtenerPrestamoPorId(id);
    }

    @PostMapping
    public PrestamoResponseDTO guardarPrestamo(@RequestBody PrestamoRequestDTO dto) {
        return service.guardarPrestamo(dto);
    }

    @PutMapping("/{id}")
    public PrestamoResponseDTO actualizarPrestamo(@PathVariable Long id,
                                                  @RequestBody PrestamoRequestDTO dto) {
        return service.actualizarPrestamo(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminarPrestamo(@PathVariable Long id) {
        service.eliminarPrestamo(id);
    }
}
