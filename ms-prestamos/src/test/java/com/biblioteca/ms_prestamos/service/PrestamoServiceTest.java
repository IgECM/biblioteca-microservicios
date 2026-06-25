package com.biblioteca.ms_prestamos.service;

import com.biblioteca.ms_prestamos.client.UsuarioClient;
import com.biblioteca.ms_prestamos.dto.PrestamoRequestDTO;
import com.biblioteca.ms_prestamos.dto.PrestamoResponseDTO;
import com.biblioteca.ms_prestamos.dto.UsuarioDTO;
import com.biblioteca.ms_prestamos.model.Prestamo;
import com.biblioteca.ms_prestamos.repository.PrestamoRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PrestamoServiceTest {

        @Mock
        private PrestamoRepository repository;

        @Mock
        private UsuarioClient usuarioClient;

        @InjectMocks
        private PrestamoService service;

        @Test
        void obtenerPrestamoPorId() {

        Prestamo prestamo = new Prestamo(
                1L,
                1L,
                2L,
                "2026-06-18"
        );

        when(repository.findById(1L))
                .thenReturn(Optional.of(prestamo));

        PrestamoResponseDTO resultado = service.obtenerPrestamoPorId(1L);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getUsuarioId());
        assertEquals(2L, resultado.getLibroId());
        }

    @Test
    void guardarPrestamo() {

        PrestamoRequestDTO dto = new PrestamoRequestDTO(
                1L,
                2L,
                "2026-06-18"
        );

        when(usuarioClient.obtenerUsuario(1L))
                .thenReturn(new UsuarioDTO(
                        1L,
                        "Juan",
                        "juan@test.cl"
                ));

        when(repository.save(any(Prestamo.class)))
                .thenReturn(new Prestamo(
                        1L,
                        1L,
                        2L,
                        "2026-06-18"
                ));

        PrestamoResponseDTO resultado = service.guardarPrestamo(dto);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        }

        @Test
        void eliminarPrestamo() {

        service.eliminarPrestamo(1L);

        verify(repository, times(1))
                .deleteById(1L);
        }
}
