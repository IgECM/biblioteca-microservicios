package com.biblioteca.ms_notificaciones.controller;

import com.biblioteca.ms_notificaciones.dto.NotificacionRequestDTO;
import com.biblioteca.ms_notificaciones.dto.NotificacionResponseDTO;
import com.biblioteca.ms_notificaciones.service.NotificacionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionController {

    private NotificacionService service;

    public NotificacionController(NotificacionService service) {
        this.service = service;
    }

    @GetMapping
    public List<NotificacionResponseDTO> listarNotificaciones() {
        return service.obtenerNotificaciones();
    }

    @GetMapping("/{id}")
    public NotificacionResponseDTO obtenerNotificacion(@PathVariable Long id) {
        return service.obtenerNotificacionPorId(id);
    }

    @PostMapping
    public NotificacionResponseDTO guardarNotificacion(@RequestBody NotificacionRequestDTO notificacion) {
        return service.guardarNotificacion(notificacion);
    }

    @PutMapping("/{id}")
    public NotificacionResponseDTO actualizarNotificacion(@PathVariable Long id,
                                                           @RequestBody NotificacionRequestDTO notificacion) {
        return service.actualizarNotificacion(id, notificacion);
    }

    @DeleteMapping("/{id}")
    public void eliminarNotificacion(@PathVariable Long id) {
        service.eliminarNotificacion(id);
    }
}