package com.biblioteca.ms_devoluciones.repository;

import com.biblioteca.ms_devoluciones.model.Devolucion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DevolucionRepository extends JpaRepository<Devolucion, Long> {
}