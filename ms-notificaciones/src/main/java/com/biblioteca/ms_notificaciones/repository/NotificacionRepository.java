package com.biblioteca.ms_notificaciones.repository;

import com.biblioteca.ms_notificaciones.model.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {

}