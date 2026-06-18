package com.biblioteca.ms_prestamos.repository;

import com.biblioteca.ms_prestamos.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {

}