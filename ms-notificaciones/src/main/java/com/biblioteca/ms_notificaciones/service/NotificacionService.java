package com.biblioteca.ms_notificaciones.service;

import com.biblioteca.ms_notificaciones.model.Notificacion;
import com.biblioteca.ms_notificaciones.repository.NotificacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacionService {

    private NotificacionRepository repository;

    public NotificacionService(NotificacionRepository repository) {
        this.repository = repository;
    }

    public List<Notificacion> obtenerNotificaciones() {
        return repository.findAll();
    }

    public Notificacion obtenerNotificacionPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Notificacion guardarNotificacion(Notificacion notificacion) {
        return repository.save(notificacion);
    }

    public Notificacion actualizarNotificacion(Long id, Notificacion notificacion) {

        Notificacion existente = repository.findById(id).orElse(null);

        if (existente != null) {
            existente.setDestinatario(notificacion.getDestinatario());
            existente.setMensaje(notificacion.getMensaje());

            return repository.save(existente);
        }

        return null;
    }

    public void eliminarNotificacion(Long id) {
        repository.deleteById(id);
    }
}