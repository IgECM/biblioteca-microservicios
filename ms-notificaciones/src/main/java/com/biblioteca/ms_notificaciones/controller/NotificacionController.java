package com.biblioteca.ms_notificaciones.controller;

import com.biblioteca.ms_notificaciones.model.Notificacion;
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
    public List<Notificacion> listarNotificaciones() {
        return service.obtenerNotificaciones();
    }

    @GetMapping("/{id}")
    public Notificacion obtenerNotificacion(@PathVariable Long id) {
        return service.obtenerNotificacionPorId(id);
    }

    @PostMapping
    public Notificacion guardarNotificacion(@RequestBody Notificacion notificacion) {
        return service.guardarNotificacion(notificacion);
    }

    @PutMapping("/{id}")
    public Notificacion actualizarNotificacion(@PathVariable Long id,
                                               @RequestBody Notificacion notificacion) {
        return service.actualizarNotificacion(id, notificacion);
    }

    @DeleteMapping("/{id}")
    public void eliminarNotificacion(@PathVariable Long id) {
        service.eliminarNotificacion(id);
    }
}