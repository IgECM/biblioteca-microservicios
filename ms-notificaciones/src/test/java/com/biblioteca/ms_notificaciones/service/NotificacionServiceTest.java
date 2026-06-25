package com.biblioteca.ms_notificaciones.service;

import com.biblioteca.ms_notificaciones.dto.NotificacionRequestDTO;
import com.biblioteca.ms_notificaciones.dto.NotificacionResponseDTO;
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

        NotificacionResponseDTO resultado = service.obtenerNotificacionPorId(1L);

        assertNotNull(resultado);
        assertEquals("usuario@correo.com", resultado.getDestinatario());
    }

    @Test
    void guardarNotificacion() {

        NotificacionRequestDTO dto = new NotificacionRequestDTO(
                "usuario@correo.com",
                "Libro disponible"
        );

        when(repository.save(any(Notificacion.class)))
                .thenReturn(new Notificacion(
                        1L,
                        "usuario@correo.com",
                        "Libro disponible"
                ));

        NotificacionResponseDTO resultado = service.guardarNotificacion(dto);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
    }

    @Test
    void eliminarNotificacion() {

        service.eliminarNotificacion(1L);

        verify(repository, times(1)).deleteById(1L);
    }
}
