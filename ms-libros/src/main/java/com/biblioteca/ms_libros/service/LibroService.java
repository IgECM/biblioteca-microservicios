package com.biblioteca.ms_libros.service;

import com.biblioteca.ms_libros.model.Libro;
import com.biblioteca.ms_libros.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    private LibroRepository repository;

    public LibroService(LibroRepository repository) {
        this.repository = repository;
    }

    public List<Libro> obtenerLibros() {
        return repository.findAll();
    }

    public Libro obtenerLibroPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Libro guardarLibro(Libro libro) {
        return repository.save(libro);
    }

    public Libro actualizarLibro(Long id, Libro libro) {

        Libro libroExistente = repository.findById(id).orElse(null);

        if (libroExistente != null) {
            libroExistente.setTitulo(libro.getTitulo());
            libroExistente.setAutor(libro.getAutor());
            libroExistente.setStock(libro.getStock());

            return repository.save(libroExistente);
        }

        return null;
    }

    public void eliminarLibro(Long id) {
        repository.deleteById(id);
    }
}