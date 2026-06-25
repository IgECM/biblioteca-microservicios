package com.biblioteca.ms_prestamos.service;

import com.biblioteca.ms_prestamos.client.UsuarioClient;
import com.biblioteca.ms_prestamos.dto.PrestamoRequestDTO;
import com.biblioteca.ms_prestamos.dto.PrestamoResponseDTO;
import com.biblioteca.ms_prestamos.dto.UsuarioDTO;
import com.biblioteca.ms_prestamos.model.Prestamo;
import com.biblioteca.ms_prestamos.repository.PrestamoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrestamoService {

    private PrestamoRepository repository;
    private UsuarioClient usuarioClient;

    public PrestamoService(PrestamoRepository repository, UsuarioClient usuarioClient) {
        this.repository = repository;
        this.usuarioClient = usuarioClient;
    }

    public List<PrestamoResponseDTO> obtenerPrestamos() {
        return repository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public PrestamoResponseDTO obtenerPrestamoPorId(Long id) {
        return repository.findById(id)
                .map(this::toResponseDTO)
                .orElse(null);
    }

    public PrestamoResponseDTO guardarPrestamo(PrestamoRequestDTO dto) {
        UsuarioDTO usuario = usuarioClient.obtenerUsuario(dto.getUsuarioId());
        if (usuario == null) {
            return null;
        }
        Prestamo prestamo = new Prestamo();
        prestamo.setUsuarioId(dto.getUsuarioId());
        prestamo.setLibroId(dto.getLibroId());
        prestamo.setFechaPrestamo(dto.getFechaPrestamo());
        return toResponseDTO(repository.save(prestamo));
    }

    public PrestamoResponseDTO actualizarPrestamo(Long id, PrestamoRequestDTO dto) {
        Prestamo existente = repository.findById(id).orElse(null);
        if (existente != null) {
            existente.setUsuarioId(dto.getUsuarioId());
            existente.setLibroId(dto.getLibroId());
            existente.setFechaPrestamo(dto.getFechaPrestamo());
            return toResponseDTO(repository.save(existente));
        }
        return null;
    }

    public void eliminarPrestamo(Long id) {
        repository.deleteById(id);
    }

    private PrestamoResponseDTO toResponseDTO(Prestamo prestamo) {
        return new PrestamoResponseDTO(
                prestamo.getId(),
                prestamo.getUsuarioId(),
                prestamo.getLibroId(),
                prestamo.getFechaPrestamo()
        );
    }
}
