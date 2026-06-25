package com.biblioteca.ms_notificaciones.service;

import com.biblioteca.ms_notificaciones.dto.NotificacionRequestDTO;
import com.biblioteca.ms_notificaciones.dto.NotificacionResponseDTO;
import com.biblioteca.ms_notificaciones.model.Notificacion;
import com.biblioteca.ms_notificaciones.repository.NotificacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificacionService {

    private NotificacionRepository repository;

    public NotificacionService(NotificacionRepository repository) {
        this.repository = repository;
    }

    public List<NotificacionResponseDTO> obtenerNotificaciones() {
        return repository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public NotificacionResponseDTO obtenerNotificacionPorId(Long id) {
        return repository.findById(id)
                .map(this::toResponseDTO)
                .orElse(null);
    }

    public NotificacionResponseDTO guardarNotificacion(NotificacionRequestDTO dto) {
        Notificacion notificacion = new Notificacion();
        notificacion.setDestinatario(dto.getDestinatario());
        notificacion.setMensaje(dto.getMensaje());
        return toResponseDTO(repository.save(notificacion));
    }

    public NotificacionResponseDTO actualizarNotificacion(Long id, NotificacionRequestDTO dto) {
        Notificacion existente = repository.findById(id).orElse(null);
        if (existente != null) {
            existente.setDestinatario(dto.getDestinatario());
            existente.setMensaje(dto.getMensaje());
            return toResponseDTO(repository.save(existente));
        }
        return null;
    }

    public void eliminarNotificacion(Long id) {
        repository.deleteById(id);
    }

    private NotificacionResponseDTO toResponseDTO(Notificacion notificacion) {
        return new NotificacionResponseDTO(
                notificacion.getId(),
                notificacion.getDestinatario(),
                notificacion.getMensaje()
        );
    }
}
