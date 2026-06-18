package com.biblioteca.ms_devoluciones.service;

import com.biblioteca.ms_devoluciones.model.Devolucion;
import com.biblioteca.ms_devoluciones.repository.DevolucionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevolucionService {

    private DevolucionRepository repository;

    public DevolucionService(DevolucionRepository repository) {
        this.repository = repository;
    }

    public List<Devolucion> obtenerDevoluciones() {
        return repository.findAll();
    }

    public Devolucion obtenerDevolucionPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Devolucion guardarDevolucion(Devolucion devolucion) {
        return repository.save(devolucion);
    }

    public Devolucion actualizarDevolucion(Long id, Devolucion devolucion) {

        Devolucion existente = repository.findById(id).orElse(null);

        if (existente != null) {
            existente.setPrestamoId(devolucion.getPrestamoId());
            existente.setFechaDevolucion(devolucion.getFechaDevolucion());

            return repository.save(existente);
        }

        return null;
    }

    public void eliminarDevolucion(Long id) {
        repository.deleteById(id);
    }
}