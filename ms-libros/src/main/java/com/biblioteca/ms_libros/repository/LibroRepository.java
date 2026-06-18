package com.biblioteca.ms_libros.repository;

import com.biblioteca.ms_libros.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {

}