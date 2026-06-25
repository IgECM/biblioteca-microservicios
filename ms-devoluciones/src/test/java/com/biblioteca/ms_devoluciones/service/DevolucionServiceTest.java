package com.biblioteca.ms_devoluciones.service;

import com.biblioteca.ms_devoluciones.dto.DevolucionRequestDTO;
import com.biblioteca.ms_devoluciones.dto.DevolucionResponseDTO;
import com.biblioteca.ms_devoluciones.model.Devolucion;
import com.biblioteca.ms_devoluciones.repository.DevolucionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DevolucionServiceTest {

    @Mock
    private DevolucionRepository repository;

    @InjectMocks
    private DevolucionService service;

    @Test
    void obtenerDevolucionPorId() {

        Devolucion devolucion = new Devolucion(
                1L,
                10L,
                "2026-06-18"
        );

        when(repository.findById(1L))
                .thenReturn(Optional.of(devolucion));

        DevolucionResponseDTO resultado = service.obtenerDevolucionPorId(1L);

        assertNotNull(resultado);
        assertEquals(10L, resultado.getPrestamoId());
    }

    @Test
    void guardarDevolucion() {

        DevolucionRequestDTO dto = new DevolucionRequestDTO(10L, "2026-06-18");

        when(repository.save(any(Devolucion.class)))
                .thenReturn(new Devolucion(1L, 10L, "2026-06-18"));

        DevolucionResponseDTO resultado = service.guardarDevolucion(dto);

        assertNotNull(resultado);
        assertEquals(10L, resultado.getPrestamoId());
    }

    @Test
    void eliminarDevolucion() {

        service.eliminarDevolucion(1L);

        verify(repository, times(1)).deleteById(1L);
    }
}
