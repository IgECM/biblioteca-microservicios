package com.biblioteca.ms_prestamos.service;

import com.biblioteca.ms_prestamos.client.UsuarioClient;
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

        // Mock del repositorio de prestamos
        @Mock
        private PrestamoRepository repository;

        // Mock para comunicarse con usuarios
        @Mock
        private UsuarioClient usuarioClient;

        // Inserta los mocks dentro del service
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

        // Simula que existe un prestamo
        when(repository.findById(1L))
                .thenReturn(Optional.of(prestamo));


        Prestamo resultado = service.obtenerPrestamoPorId(1L);


        assertNotNull(resultado);
        assertEquals(1L, resultado.getUsuarioId());
        assertEquals(2L, resultado.getLibroId());
        }

    @Test
    void guardarPrestamo() {


        Prestamo prestamo = new Prestamo(
                null,
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


        when(repository.save(prestamo))
                .thenReturn(new Prestamo(
                        1L,
                        1L,
                        2L,
                        "2026-06-18"
                ));


        Prestamo resultado = service.guardarPrestamo(prestamo);


        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        }


        @Test
        void eliminarPrestamo() {


        service.eliminarPrestamo(1L);


        // para confirmar que de VERDAD se borro el prestamo
        verify(repository, times(1))
                .deleteById(1L);
        }
}