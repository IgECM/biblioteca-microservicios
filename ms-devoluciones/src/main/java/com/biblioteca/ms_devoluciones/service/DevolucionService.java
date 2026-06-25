package com.biblioteca.ms_devoluciones.service;

import com.biblioteca.ms_devoluciones.dto.DevolucionRequestDTO;
import com.biblioteca.ms_devoluciones.dto.DevolucionResponseDTO;
import com.biblioteca.ms_devoluciones.model.Devolucion;
import com.biblioteca.ms_devoluciones.repository.DevolucionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DevolucionService {

    private DevolucionRepository repository;

    public DevolucionService(DevolucionRepository repository) {
        this.repository = repository;
    }

    public List<DevolucionResponseDTO> obtenerDevoluciones() {
        return repository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public DevolucionResponseDTO obtenerDevolucionPorId(Long id) {
        return repository.findById(id)
                .map(this::toResponseDTO)
                .orElse(null);
    }

    public DevolucionResponseDTO guardarDevolucion(DevolucionRequestDTO dto) {
        Devolucion devolucion = new Devolucion();
        devolucion.setPrestamoId(dto.getPrestamoId());
        devolucion.setFechaDevolucion(dto.getFechaDevolucion());
        return toResponseDTO(repository.save(devolucion));
    }

    public DevolucionResponseDTO actualizarDevolucion(Long id, DevolucionRequestDTO dto) {
        Devolucion existente = repository.findById(id).orElse(null);
        if (existente != null) {
            existente.setPrestamoId(dto.getPrestamoId());
            existente.setFechaDevolucion(dto.getFechaDevolucion());
            return toResponseDTO(repository.save(existente));
        }
        return null;
    }

    public void eliminarDevolucion(Long id) {
        repository.deleteById(id);
    }

    private DevolucionResponseDTO toResponseDTO(Devolucion devolucion) {
        return new DevolucionResponseDTO(
                devolucion.getId(),
                devolucion.getPrestamoId(),
                devolucion.getFechaDevolucion()
        );
    }
}
