package com.biblioteca.ms_devoluciones.controller;

import com.biblioteca.ms_devoluciones.dto.DevolucionRequestDTO;
import com.biblioteca.ms_devoluciones.dto.DevolucionResponseDTO;
import com.biblioteca.ms_devoluciones.service.DevolucionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devoluciones")
public class DevolucionController {

    private DevolucionService service;

    public DevolucionController(DevolucionService service) {
        this.service = service;
    }

    @GetMapping
    public List<DevolucionResponseDTO> listarDevoluciones() {
        return service.obtenerDevoluciones();
    }

    @GetMapping("/{id}")
    public DevolucionResponseDTO obtenerDevolucion(@PathVariable Long id) {
        return service.obtenerDevolucionPorId(id);
    }

    @PostMapping
    public DevolucionResponseDTO guardarDevolucion(@RequestBody DevolucionRequestDTO dto) {
        return service.guardarDevolucion(dto);
    }

    @PutMapping("/{id}")
    public DevolucionResponseDTO actualizarDevolucion(@PathVariable Long id,
                                                      @RequestBody DevolucionRequestDTO dto) {
        return service.actualizarDevolucion(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminarDevolucion(@PathVariable Long id) {
        service.eliminarDevolucion(id);
    }
}
