package com.biblioteca.ms_libros.service;

import com.biblioteca.ms_libros.dto.LibroRequestDTO;
import com.biblioteca.ms_libros.dto.LibroResponseDTO;
import com.biblioteca.ms_libros.model.Libro;
import com.biblioteca.ms_libros.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroService {

    private LibroRepository repository;

    public LibroService(LibroRepository repository) {
        this.repository = repository;
    }

    public List<LibroResponseDTO> obtenerLibros() {
        return repository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public LibroResponseDTO obtenerLibroPorId(Long id) {
        Libro libro = repository.findById(id).orElse(null);
        return libro != null ? toResponseDTO(libro) : null;
    }

    public LibroResponseDTO guardarLibro(LibroRequestDTO dto) {
        Libro libro = new Libro();
        libro.setTitulo(dto.getTitulo());
        libro.setAutor(dto.getAutor());
        libro.setStock(dto.getStock());
        return toResponseDTO(repository.save(libro));
    }

    public LibroResponseDTO actualizarLibro(Long id, LibroRequestDTO dto) {
        Libro libroExistente = repository.findById(id).orElse(null);

        if (libroExistente != null) {
            libroExistente.setTitulo(dto.getTitulo());
            libroExistente.setAutor(dto.getAutor());
            libroExistente.setStock(dto.getStock());
            return toResponseDTO(repository.save(libroExistente));
        }

        return null;
    }

    public void eliminarLibro(Long id) {
        repository.deleteById(id);
    }

    private LibroResponseDTO toResponseDTO(Libro libro) {
        return new LibroResponseDTO(libro.getId(), libro.getTitulo(), libro.getAutor(), libro.getStock());
    }
}