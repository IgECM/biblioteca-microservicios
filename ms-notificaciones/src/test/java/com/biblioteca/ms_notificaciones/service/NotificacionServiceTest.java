package com.biblioteca.ms_notificaciones.service;

import com.biblioteca.ms_notificaciones.model.Notificacion;
import com.biblioteca.ms_notificaciones.repository.NotificacionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NotificacionServiceTest {

    @Mock
    private NotificacionRepository repository;

    @InjectMocks
    private NotificacionService service;

    @Test
    void obtenerNotificacionPorId() {

        Notificacion notificacion = new Notificacion(
                1L,
                "usuario@correo.com",
                "Libro disponible"
        );

        when(repository.findById(1L))
                .thenReturn(Optional.of(notificacion));

        Notificacion resultado = service.obtenerNotificacionPorId(1L);

        assertNotNull(resultado);
        assertEquals("usuario@correo.com", resultado.getDestinatario());
    }

    @Test
    void guardarNotificacion() {

        Notificacion notificacion = new Notificacion(
                null,
                "usuario@correo.com",
                "Libro disponible"
        );

        when(repository.save(notificacion))
                .thenReturn(new Notificacion(
                        1L,
                        "usuario@correo.com",
                        "Libro disponible"
                ));

        Notificacion resultado = service.guardarNotificacion(notificacion);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
    }

    @Test
    void eliminarNotificacion() {

        service.eliminarNotificacion(1L);

        verify(repository, times(1)).deleteById(1L);
    }
}
