package com.biblioteca.ms_devoluciones.controller;

import com.biblioteca.ms_devoluciones.model.Devolucion;
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
    public List<Devolucion> listarDevoluciones() {
        return service.obtenerDevoluciones();
    }

    @GetMapping("/{id}")
    public Devolucion obtenerDevolucion(@PathVariable Long id) {
        return service.obtenerDevolucionPorId(id);
    }

    @PostMapping
    public Devolucion guardarDevolucion(@RequestBody Devolucion devolucion) {
        return service.guardarDevolucion(devolucion);
    }

    @PutMapping("/{id}")
    public Devolucion actualizarDevolucion(@PathVariable Long id,
                                           @RequestBody Devolucion devolucion) {
        return service.actualizarDevolucion(id, devolucion);
    }

    @DeleteMapping("/{id}")
    public void eliminarDevolucion(@PathVariable Long id) {
        service.eliminarDevolucion(id);
    }
}